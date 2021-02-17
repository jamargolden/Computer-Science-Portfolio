<?php
    include_once 'includes/data.php';
?>

<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Login</title>
  <link rel="stylesheet" href="styles.css">
  <script src="app.js"></script>

  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
</head>

<body>
<input type="button" id="logAlt" class="loginAlt btn animateBtn" value="Login" onmouseover="hover('logAlt')" onmouseout="hoverOff('logAlt')" onclick="loginLink()">
  <div class="signUp">
    <h1 class="title">Sign Up</h1>
    <form class="loginForm" action="includes/signup.inc.php" method="POST">
        <h3>First Name</h3>
        <input type="text" id="first" name="first" class="firstName inp">
        <h3>Last Name</h3>
        <input type="text" id="last" name="last" class="lastName inp">
        <h3>E-mail Address</h3>
        <input type="text" id="em" name="em" class="email inp">
        <h3>Password</h3>
        <input type="text" id="pass" name="pass" class="password inp">

        <button type="submit" name="submit" id="signBtn" class="signUpBtn btn animateBtn" onmouseover="hover('signBtn')" onmouseout="hoverOff('signBtn')">Sign Up</button>
    </form>
  </div>
</body>
</html>