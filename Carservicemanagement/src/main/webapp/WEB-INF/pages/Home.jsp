<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Service - Dashboard</title>
    <link rel="stylesheet" href="../css/Home.css">
    <style>
    body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f8f9fa;
}

.dashboard {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

.header {
    background-color: #343a40;
    color: white;
    padding: 15px 30px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo {
    display: flex;
    align-items: center;
}

.logo img {
    width: 50px;
    height: auto;
    margin-right: 15px;
}

.logo h1 {
    font-size: 20px;
    margin: 0;
}

.nav ul {
    display: flex;
    list-style: none;
    margin: 0;
    padding: 0;
}

.nav li {
    margin: 0 15px;
}

.nav a {
    color: white;
    text-decoration: none;
    padding: 5px 10px;
    border-radius: 4px;
    transition: background-color 0.3s;
}

.nav a.active, .nav a:hover {
    background-color: #007bff;
}

.user-profile {
    display: flex;
    align-items: center;
}

.user-profile span {
    margin-right: 15px;
}

.user-profile a {
    color: white;
    text-decoration: none;
    padding: 5px 10px;
    background-color: #dc3545;
    border-radius: 4px;
    transition: background-color 0.3s;
}

.user-profile a:hover {
    background-color: #c82333;
}

.main-content {
    padding: 30px;
    flex: 1;
}

.quick-actions {
    margin-bottom: 30px;
}

.quick-actions h2 {
    color: #343a40;
    margin-bottom: 20px;
}

.action-cards {
    display: flex;
    gap: 20px;
}

.card {
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    padding: 20px;
    flex: 1;
}

.card h3 {
    color: #007bff;
    margin-top: 0;
}

.card p {
    color: #6c757d;
    margin: 10px 0 15px;
}

.card button {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 8px 15px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.card button:hover {
    background-color: #0056b3;
}

.recent-activity h2 {
    color: #343a40;
    margin-bottom: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 12px 15px;
    text-align: left;
    border-bottom: 1px solid #dee2e6;
}

th {
    background-color: #343a40;
    color: white;
}

.status-completed {
    color: #28a745;
    font-weight: bold;
}

.status-pending {
    color: #ffc107;
    font-weight: bold;
}

tr:hover {
    background-color: #f8f9fa;
}

/* Popup Modal */
.modal {
    display: none; 
    position: fixed; 
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100%; 
    height: 100%;
    overflow: auto; 
    background-color: rgba(0,0,0,0.5); 
}

.modal-content {
    background-color: #fff;
    margin: 10% auto;
    padding: 2rem;
    border: 1px solid #888;
    width: 50%;
    border-radius: 8px;
    position: relative;
}

.close {
    color: #aaa;
    position: absolute;
    top: 10px;
    right: 20px;
    font-size: 28px;
    font-weight: bold;
    cursor: pointer;
}

.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
}

.popup-section {
    display: none;
}
    
    </style>
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
                <a href="login">Logout</a>
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
