<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Dashboard</title>
    <link rel="stylesheet" href="../css/Home.css">
</head>
<body>
    <div class="dashboard">
        <header class="header">
            <div class="logo">
                <img src="../images/car-logo.png" alt="Car Service Logo">
                <h1>Car Service Management</h1>
            </div>
            <nav class="nav">
                <ul>
                    <li><a href="Home.jsp" onclick="navigateTo('dashboard')" class="active">Dashboard</a></li>
                    <li><a href="Services.jsp" onclick="navigateTo('services')">Services</a></li>
                    <li><a href="Appointment.jsp" onclick="navigateTo('appointments')">Appointments</a></li>
                    <li><a href="Customer.jsp" onclick="navigateTo('customers')">Customers</a></li>
                    <li><a href="Reports.jsp" onclick="navigateTo('reports')">Reports</a></li>
                </ul>
                <script>
                    function navigateTo(page) {
                        document.querySelector('.nav a.active').classList.remove('active');
                        event.target.classList.add('active');
                        
                        // You'll need to implement the actual navigation logic in your controller
                        window.location.href = '/CarService/' + page;
                    }
                </script>
            </nav>
            <div class="user-profile">
                <span>Welcome, ${username}</span>
                <a href="Login.jsp">Logout</a>
            </div>
        </header>

        <main class="main-content">
            <div class="quick-actions">
                <h2>Quick Actions</h2>
                <div class="action-cards">
                    <div class="card">
                        <h3>New Service</h3>
                        <p>Create a new service request</p>
                        <button onclick="openModal('serviceForm')">Create</button>
                    </div>
                    <div class="card">
                        <h3>View Appointments</h3>
                        <p>Manage upcoming appointments</p>
                        <button onclick="openModal('appointmentView')">View</button>
                    </div>
                    <div class="card">
                        <h3>Add Vehicle</h3>
                        <p>Register a new vehicle</p>
                         <button onclick="openModal('vehicleForm')">Add</button>
                    </div>
                </div>
            </div>

            <div class="recent-activity">
                <h2>Recent Activity</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Service</th>
                            <th>Vehicle</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>2025-04-20</td>
                            <td>Oil Change</td>
                            <td>Toyota Camry</td>
                            <td class="status-completed">Completed</td>
                        </tr>
                        <tr>
                            <td>2025-04-18</td>
                            <td>Brake Inspection</td>
                            <td>Honda Civic</td>
                            <td class="status-pending">Pending</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
    	 <div id="popupModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>

            <!-- Service Form -->
            <div id="serviceForm" class="popup-section">
                <h2>New Service Request</h2>
                <form>
                    <input type="text" placeholder="Service Name" required><br><br>
                    <textarea placeholder="Service Description" required></textarea><br><br>
                    <button type="submit">Submit Service</button>
                </form>
            </div>

            <!-- Appointment View -->
            <div id="appointmentView" class="popup-section">
                <h2>View Appointments</h2>
                <p>Appointments data will be shown here.</p>
            </div>

            <!-- Vehicle Form -->
            <div id="vehicleForm" class="popup-section">
                <h2>Add New Vehicle</h2>
                <form>
                    <input type="text" placeholder="Vehicle Name" required><br><br>
                    <input type="text" placeholder="Model" required><br><br>
                    <button type="submit">Add Vehicle</button>
                </form>
            </div>
        </div>
  </div>
</body>
</html>
