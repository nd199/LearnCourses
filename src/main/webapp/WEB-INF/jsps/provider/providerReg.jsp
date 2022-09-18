<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Provider Registration</title>
    <link rel="stylesheet" href="css/regstyle.css"/>
</head>
<body>
<div class="banner">
    <header>
        <div class="navbar">
            <a href="https://dxc.com/us/en"
            ><img src="images/LearningCourses.png" class="logo"
             alt=""/></a>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="">Contact</a></li>
            </ul>
        </div>
    </header>
    <middleSection>
        <div class="main">
            <div class="register">
                <h2>Register</h2>
                <center>${message}</center>
                <form action="providerReg" method="post" id="register">
                    <label for="firstName">First Name
                        <br/>
                        <input
                                type="text"
                                name="firstName"
                                pattern="^[A-Za-z]+$"
                                class="name"
                                id="firstName"
                                placeholder="Enter Your First Name"
                        />
                    </label>
                    <br/><br/>
                    <label for="lastName">Last Name</label>
                    <br/>
                    <input
                            type="text" name="lastName" class="name"
                            id="lastName"
                            placeholder="Enter Your Last Name"
                    />
                    <br/><br/>
                    <label for="age">Age</label>
                    <br/>
                    <input
                            type="number"
                            name="age"
                            min="16"
                            max="120"
                            id="age"
                            placeholder="How old are You"
                    />
                    <br/><br/>
                    <label for="name">Email </label>
                    <br/>
                    <input
                            type="email"
                            name="email"
                            id="name"
                            placeholder="Enter Your Email Address"
                    />
                    <br/><br/>
                    <label for="name">Password</label>
                    <br/>
                    <input
                            type="password"
                            name="password"
                            id="password"
                            pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,24}$" required
                            title="uppercase, lowercase, numbers, special characters-> 8to24 characters"
                            placeholder="Enter Your Password"
                            onkeyup='passConfirm();'
                    />
                    <br/><br/>
                    <label for="name">Confirm Password</label>
                    <br/>
                    <input
                            type="password"
                            name="confirmPassword"
                            id="confirmPassword"
                            pattern="^[a-zA-Z0-9@]+$"
                            placeholder="Confirm Your Password"
                            onkeyup='passConfirm();'
                    />
                    <br/><br/>
                    <span id="Message"></span>
                    <br><br>
                    <input type="submit" value="Sign Up"
                           name="submit" id="submit">
                </form>
                <p>Already Registered ?.. <a
                        class="link" href="loginProviderPage">SignIn</a>
                </p>
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
