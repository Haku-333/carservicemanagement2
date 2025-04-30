<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Book Appointment</title>
    <link rel="stylesheet" href="../css/Appointment.css">
</head>
<body>
    <header>
        <h1>Book an Appointment</h1>
        <nav>
            <a href="Home.jsp">Home</a>
            <a href="Services.jsp">Services</a>
            <a href="Appointment.jsp" class="active">Appointments</a>
            <a href="Customer.jsp">Customers</a>
            <a href="Reports.jsp">Reports</a>
        </nav>
    </header>

    <main>
        <div class="appointment-form">
            <h2>Appointment Details</h2>
            <form action="AppointmentController" method="post">
                <div class="form-group">
                    <label for="customerName">Customer Name</label>
                    <input type="text" id="customerName" name="customerName" required>
                </div>

                <div class="form-group">
                    <label for="vehicleModel">Vehicle Model</label>
                    <input type="text" id="vehicleModel" name="vehicleModel" required>
                </div>

                <div class="form-group">
                    <label for="serviceType">Service Type</label>
                    <select id="serviceType" name="serviceType" required>
                        <option value="">Select Service</option>
                        <option value="Oil Change">Oil Change</option>
                        <option value="Brake Inspection">Brake Inspection</option>
                        <option value="Cleaning">Cleaning</option>
                        <option value="Battery Replacement">Battery Replacement</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="appointmentDate">Appointment Date</label>
                    <input type="date" id="appointmentDate" name="appointmentDate" required>
                </div>

                <div class="form-group">
                    <label for="notes">Additional Notes</label>
                    <textarea id="notes" name="notes" rows="4" placeholder="Any specific instructions..."></textarea>
                </div>

                <button type="submit">Book Appointment</button>
            </form>
        </div>
    </main>

    <footer>
        <p>&copy; 2025 Car Service Management. All rights reserved.</p>
    </footer>
</body>
</html>
