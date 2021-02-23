<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Login Success</title>
  <link rel="stylesheet" href="stylesPhp.css">

  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
</head>

<body>
</body>
</html>

<?php
    include_once 'data.php';
    $email = $_POST['email'];
    $enteredPwd = $_POST['password'];

    $sql = "SELECT * FROM users WHERE email='$email';";
    $result = mysqli_query($connect, $sql);
    $resultCheck = mysqli_num_rows($result);

    if($resultCheck > 0){
        $row = mysqli_fetch_assoc($result);
        $realPwd = $row['password'];
        if($enteredPwd == $realPwd){
            //header("Location: ../success.php?Login=success");
            echo "<div><h1>Welcome Back, " . $row['firstName'] . "</h1></div>";
        }
        else{
            header("Location: ../index.php?Login=failure");
        }
    }