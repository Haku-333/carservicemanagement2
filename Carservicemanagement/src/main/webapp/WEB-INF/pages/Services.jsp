<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Services</title>
    <link rel="stylesheet" href="../css/Services.css">
</head>
<body>
    <header>
        <h1>Admin Panel - Manage Services</h1>
        <nav>
            <a href="Home.jsp">Home</a>
            <a href="Services.jsp" class="active">Services</a>
            <a href="Appointment.jsp">Appointments</a>
            <a href="Customers.jsp">Customers</a>
            <a href="Reports.jsp">Reports</a>
        </nav>
    </header>
    
    <main>
        <!-- Available Services Section -->
        <section class="service-container">
            <div class="service-card">
                <h2>Oil Change</h2>
                <p>Regular oil maintenance services with high-quality products.</p>
                <div class="service-price">₹1200</div>
            </div>
            <div class="service-card">
                <h2>Brake Inspection</h2>
                <p>Complete brake system checking and minor repairs if needed.</p>
                <div class="service-price">₹800</div>
            </div>
            <div class="service-card">
                <h2>Cleaning Service</h2>
                <p>Professional cleaning for both interior and exterior of vehicles.</p>
                <div class="service-price">₹1500</div>
            </div>
            <div class="service-card">
                <h2>Battery Replacement</h2>
                <p>Replace old batteries with guaranteed new batteries.</p>
                <div class="service-price">₹3500</div>
            </div>
        </section>

        <!-- Add Vehicle to Service (after Appointment) Section -->
        <section class="service-container" style="margin-top: 3rem;">
            <div class="service-card" style="grid-column: span 2;">
                <h2>Assign Vehicle to Service</h2>
                <form action="VehicleServiceController" method="post" class="vehicle-form">
                    <div class="form-group">
                        <label for="vehicleNumber">Vehicle Number</label>
                        <input type="text" id="vehicleNumber" name="vehicleNumber" placeholder="Enter Vehicle Number" required>
                    </div>

                    <div class="form-group">
                        <label for="serviceName">Service Type</label>
                        <select id="serviceName" name="serviceName" required>
                            <option value="">Select Service</option>
                            <option value="Oil Change">Oil Change</option>
                            <option value="Brake Inspection">Brake Inspection</option>
                            <option value="Cleaning">Cleaning</option>
                            <option value="Battery Replacement">Battery Replacement</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="appointmentId">Appointment ID</label>
                        <input type="text" id="appointmentId" name="appointmentId" placeholder="Enter Appointment ID" required>
                    </div>

                    <button type="submit" class="book-btn">Assign Vehicle</button>
                </form>
            </div>
        </section>
    </main>
    
    <footer>
        <p>&copy; 2025 Car Service Management. Admin Panel</p>
    </footer>
</body>
</html>
