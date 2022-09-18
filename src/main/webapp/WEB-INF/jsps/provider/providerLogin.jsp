<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Provider Sign</title>
    <link rel="stylesheet" href="css/regstyle.css" />
  </head>
  <body>
    <div class="banner">
      <header>
        <div class="navbar">
          <a href="https://dxc.com/us/en"
            ><img src="images/LearningCourses.png" class="logo"
          /></a>
          <ul>
            <li><a href="LandingPage.html">Home</a></li>
            <li><a href="">Contact</a></li>
          </ul>
        </div>
      </header>
      <middleSection>
        <div class="main">
          <div class="register">
            <h2>LOGIN</h2>
            <center>${message}</center>
            <form action="loginProvider" method="post" id="register">
              <label>Email</label>
              <br />
              <input
                type="email"
                name="email"
                id="name"
                placeholder="Enter Your Email Address"
              />
              <br /><br />
              <label>Password
              <br />
              <input
                type="password"
                name="password"
                id="password"
                placeholder="Enter Your Password"
                onkeyup='passConfirm();'
              />
              </label>
              <br/><br />
              <label>Confirm Password
              <br />
              <input
                type="password"
                name="confirmPassword"
                id="confirmPassword"
                placeholder="Confirm Your Password"
                onkeyup='passConfirm();'
              />
              </label>
              <br/><br/>
              <span id="Message"></span>
              <br><br>
              <input type="submit" value="Sign"
              name="submit" id="submit">
            </form>
            <script>
              const passConfirm = function () {
                if (document.getElementById("password").value ===
                        document.getElementById("confirmPassword").value) {
                  document.getElementById("Message").style.color = "Green";
                  document.getElementById("Message").innerHTML = "Passwords match!"
                } else {
                  document.getElementById("Message").style.color = "Red";
                  document.getElementById("Message").innerHTML = "Passwords do NOT match!"
                }
              };
            </script>
          </div>
        </div>
      </middleSection>
    </div>
  </body>
</html>
