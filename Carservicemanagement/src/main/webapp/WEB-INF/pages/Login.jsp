<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Login</title>
    <link rel="stylesheet" href="../css/Login.css">
</head>
<body>
    <div class="login-container">
        <div class="logo">
            <img src="\Users\DELL\OneDrive\Desktop\Year 2\sem 2\Data Structure\img\Orange Black Modern Car Parts and Service Logo.png" alt="Car Service Logo">
            <h1>Car Service Management</h1>
        </div>
        
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="btn-login">Login</button>
            
            <div class="register-link">
                Don't have an account? <a href="Register.jsp">Register here</a>
            </div>
        </form>
    </div>
</body>
</html>
