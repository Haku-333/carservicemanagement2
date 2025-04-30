<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Register</title>
    <link rel="stylesheet" href="../css/Register.css">
</head>
<body>
    <div class="register-container">
        <div class="logo">
            <img src="../images/car-logo.png" alt="Car Service Logo">
            <h1>Create Account</h1>
        </div>
        
        <form action="register" method="post">
            <div class="form-group">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="fullname" required>
            </div>
            
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-group">
                <label for="confirm-password">Confirm Password</label>
                <input type="password" id="confirm-password" name="confirm-password" required>
            </div>
            
            <button type="submit" class="btn-register">Register</button>
            
            <div class="login-link">
                Already have an account? <a href="Login.jsp">Login here</a>
            </div>
        </form>
    </div>
    <% Boolean success = (Boolean) request.getAttribute("success"); %>
<script>
    window.onload = function () {
        <% if (success != null && success) { %>
            alert("User registered successfully!");
        <% } %>
    };
</script>
    
</body>
</html>
