<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css">
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

.login-container {
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
    margin-bottom: 20px;
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

.btn-login {
    width: 100%;
    padding: 12px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
}

.btn-login:hover {
    background-color: #0056b3;
}

.register-link {
    margin-top: 15px;
    font-size: 14px;
    color: #666;
}

.register-link a {
    color: #007bff;
    text-decoration: none;
}

.register-link a:hover {
    text-decoration: underline;
}
    
    </style>
</head>
<body>
    <div class="login-container">
        <div class="logo">
            <img src="\Users\DELL\OneDrive\Desktop\Year 2\sem 2\Data Structure\img\Orange Black Modern Car Parts and Service Logo.png" contextPathalt="Car Service Logo">
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
                Don't have an account? <a href="register">Register here</a>
            </div>
        </form>
    </div>
</body>
</html>
