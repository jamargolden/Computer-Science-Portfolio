<?php
    include_once 'data.php';

    $firstName = $_POST['first'];
    $lastName = $_POST['last'];
    $email = $_POST['em'];
    $passwords = $_POST['pass'];

    
    $sql = "INSERT INTO users (firstName, lastName, email, password) VALUES ('$firstName', '$lastName', '$email', '$passwords');";
    mysqli_query($connect, $sql);

    header("Location: ../index.php?signup=success");