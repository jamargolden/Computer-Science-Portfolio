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
  
  <div class="login">
    <h1 class="title">Login</h1>
    <form class="loginForm" action="includes/login.inc.php" method="POST">
        <h3>E-mail Address</h3>
        <input type="text" class="email inp" name="email">
        <h3>Password</h3>
        <input type="text" class="password inp" name="password">
        <button type="submit" name="submit" id="logBtn" class="btn animateBtn signUpBtn" onmouseover="hover('logBtn')" onmouseout="hoverOff('logBtn')">Login</button>
    </form>
    <p class="signUpLink"><a href="signup.php">Not a Member Yet? Sign Up Now</a></p>
    
  </div>
</body>
</html>