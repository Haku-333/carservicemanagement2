<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Register</title>
    <link rel="stylesheet" href="../css/Register.css">
    <style>
    body {
    font-family: 'Arial', sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-image: url('../images/garage-bg.jpg');
    background-size: cover;
    background-position: center;
}

.register-container {
    background-color: rgba(255, 255, 255, 0.9);
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 350px;
    text-align: center;
}

.logo {
    margin-bottom: 25px;
}

.logo img {
    width: 80px;
    height: auto;
}

.logo h1 {
    color: #333;
    font-size: 22px;
    margin-top: 10px;
}

.form-group {
    margin-bottom: 15px;
    text-align: left;
}

.form-group label {
    display: block;
    margin-bottom: 5px;
    color: #555;
    font-weight: bold;
}

.form-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}

.btn-register {
    width: 100%;
    padding: 12px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
}

.btn-register:hover {
    background-color: #218838;
}

.login-link {
    margin-top: 15px;
    font-size: 14px;
    color: #666;
}

.login-link a {
    color: #007bff;
    text-decoration: none;
}

.login-link a:hover {
    text-decoration: underline;
}
    
    </style>
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
                Already have an account? <a href="login">Login here</a>
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
