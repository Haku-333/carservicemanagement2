<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Customers</title>
    <link rel="stylesheet" href="../css/Customer.css">
</head>
<body>
    <header>
        <h1>Admin Panel - Manage Customers</h1>
        <nav>
            <a href="Home.jsp">Home</a>
            <a href="Services.jsp">Services</a>
            <a href="Appointment.jsp">Appointments</a>
            <a href="Customer.jsp" class="active">Customers</a>
            <a href="Reports.jsp">Reports</a>
        </nav>
    </header>

    <main>
        <!-- Customer List Section -->
        <section class="customer-container">
            <h2>Registered Customers</h2>
            <table class="customer-table">
                <thead>
                    <tr>
                        <th>Customer ID</th>
                        <th>Full Name</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Vehicle Number</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>CUST001</td>
                        <td>Rahul Sharma</td>
                        <td>9876543210</td>
                        <td>rahul@example.com</td>
                        <td>MH12AB1234</td>
                    </tr>
                    <tr>
                        <td>CUST002</td>
                        <td>Priya Singh</td>
                        <td>8765432109</td>
                        <td>priya@example.com</td>
                        <td>MH14CD5678</td>
                    </tr>
                </tbody>
            </table>
        </section>

        <!-- Add New Customer Section -->
        <section class="customer-form-container" style="margin-top: 3rem;">
            <h2>Add New Customer</h2>
            <form action="CustomerController" method="post" class="customer-form">
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" id="fullName" name="fullName" placeholder="Enter Full Name" required>
                </div>

                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number" required>
                </div>

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" placeholder="Enter Email Address" required>
                </div>

                <div class="form-group">
                    <label for="vehicleNumber">Vehicle Number</label>
                    <input type="text" id="vehicleNumber" name="vehicleNumber" placeholder="Enter Vehicle Number" required>
                </div>

                <button type="submit" class="add-btn">Add Customer</button>
            </form>
        </section>
    </main>

    <footer>
        <p>&copy; 2025 Car Service Management. Admin Panel</p>
    </footer>
</body>
</html>
