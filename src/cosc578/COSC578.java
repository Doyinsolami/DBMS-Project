
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cosc578;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class COSC578 {

    // ================================
    // DATABASE CREDENTIALS
    // ================================
    private static final String ID  = "asillah";
    private static final String PW  = "COSC*rirg";
    private static final String SERVER = "jdbc:mysql://triton2.towson.edu:3360/asillah2db?serverTimezone=EST";

    //replace the above credentials with your own id, password, and database URL

    // ================================
    // DATABASE CONNECTION METHOD
    // ================================
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(SERVER, ID, PW);
    }

    // ================================
    // QUERY 1: All Clients + Documents
    // ================================
    public static ArrayList<String> getAllClientsAndDocuments() {
        ArrayList<String> list = new ArrayList<>();

        String sql =
            "SELECT C.client_id, C.first_name, C.last_name, D.document_name " +
            "FROM Client C LEFT JOIN Document D ON C.client_id = D.client_id " +
            "ORDER BY C.client_id ASC";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(
                    rs.getInt("client_id") + " | " +
                    rs.getString("first_name") + " " +
                    rs.getString("last_name") +
                    " | Document: " + rs.getString("document_name")
                );
            }

        } catch (SQLException e) {
            list.add("SQL ERROR: " + e.getMessage());
        }
        return list;
    }

    // =============================================
    // QUERY 2: Appointments for a Specific Client
    // =============================================
    public static ArrayList<String> getAppointmentsForClient(int clientId) {
        ArrayList<String> list = new ArrayList<>();

        String sql =
            "SELECT A.appointment_id, A.appointment_date, A.appointment_time, " +
            "E.first_name, E.last_name " +
            "FROM Appointment A " +
            "JOIN Employee E ON A.employee_id = E.employee_id " +
            "WHERE A.client_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                    "Appt #" + rs.getInt("appointment_id") +
                    " | " + rs.getDate("appointment_date") +
                    " at " + rs.getTime("appointment_time") +
                    " | Employee: " + rs.getString("first_name") +
                    " " + rs.getString("last_name")
                );
            }

        } catch (SQLException e) {
            list.add("SQL ERROR: " + e.getMessage());
        }

        return list;
    }

    // ========================================
    // QUERY 3: Upcoming Appointments (7 Days)
    // ========================================
    public static ArrayList<String> getUpcomingAppointments(LocalDate startDate, int daysAhead) {
        ArrayList<String> list = new ArrayList<>();
        LocalDate windowStart = (startDate == null) ? LocalDate.now() : startDate;
        int windowSize = Math.max(daysAhead, 1);
        LocalDate windowEnd = windowStart.plusDays(windowSize);

        String sql =
            "SELECT A.appointment_id, C.first_name AS first_name, C.last_name AS last_name, A.appointment_date " +
            "FROM Appointment A JOIN Client C ON A.client_id = C.client_id " +
            "WHERE A.appointment_date BETWEEN ? AND ? " +
            "ORDER BY A.appointment_date ASC";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(windowStart));
            ps.setDate(2, java.sql.Date.valueOf(windowEnd));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                    "Appt #" + rs.getInt("appointment_id") +
                    " | " + rs.getString("first_name") + " " +
                    rs.getString("last_name") +
                    " | " + rs.getString("appointment_date")
                );
            }
        } catch (SQLException e) {
            list.add("SQL ERROR: " + e.getMessage());
        }

        return list;
    }

    public static ArrayList<String> getUpcomingAppointments() {
        return getUpcomingAppointments(LocalDate.now(), 7);
    }

    // ======================================
    // QUERY 4: Unpaid Invoices + Balances
    // ======================================
    public static ArrayList<String> getUnpaidInvoices() {
        ArrayList<String> list = new ArrayList<>();

        String sql =
            "SELECT C.first_name, C.last_name, I.invoice_id, I.amount, " +
            "IFNULL(SUM(P.amount_paid), 0) AS paid, " +
            "(I.amount - IFNULL(SUM(P.amount_paid), 0)) AS balance " +
            "FROM Invoice I " +
            "JOIN Engagement E ON I.engagement_id = E.engagement_id " +
            "JOIN Client C ON E.client_id = C.client_id " +
            "LEFT JOIN Payment P ON I.invoice_id = P.invoice_id " +
            "GROUP BY I.invoice_id " +
            "HAVING balance > 0";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(
                    rs.getString("first_name") + " " + rs.getString("last_name") +
                    " | Invoice #" + rs.getInt("invoice_id") +
                    " | Balance: $" + rs.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            list.add("SQL ERROR: " + e.getMessage());
        }

        return list;
    }

    // ==========================================================
    // QUERY 5: Total Payments by Date Range
    // ==========================================================
    public static ArrayList<String> getPaymentsByMethod(String start, String end) {
        ArrayList<String> list = new ArrayList<>();

        String sql =
            "SELECT SUM(amount_paid) AS total " +
            "FROM Payment " +
            "WHERE payment_date BETWEEN ? AND ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, start);
            ps.setString(2, end);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add("Total: $" + rs.getDouble("total")
                );
            }

        } catch (SQLException e) {
            list.add("SQL ERROR: " + e.getMessage());
        }

        return list;
    }

    // ==========================================================
    // QUERY 6: Active Appointments per Employee
    // ==========================================================
    public static ArrayList<String> getAppointmentsForEmployee(int empId) {
        return getAppointmentsForEmployee(empId, LocalDate.now());
    }

    public static ArrayList<String> getAppointmentsForEmployee(int empId, LocalDate fromDate) {
        ArrayList<String> list = new ArrayList<>();
        LocalDate windowStart = (fromDate == null) ? LocalDate.now() : fromDate;

        String sql =
            "SELECT A.appointment_id, A.appointment_date, C.first_name, C.last_name " +
            "FROM Appointment A JOIN Client C ON A.client_id = C.client_id " +
            "WHERE A.employee_id = ? AND appointment_date >= ? " +
            "ORDER BY A.appointment_date ASC";
        

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ps.setDate(2, java.sql.Date.valueOf(windowStart));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                    "Appt #" + rs.getInt("appointment_id") +
                    " | " + rs.getString("appointment_date") +
                    " | Client: " + rs.getString("first_name") +
                    " " + rs.getString("last_name")
                );
            }

        } catch (SQLException e) {
            list.add("SQL ERROR: " + e.getMessage());
        }

        return list;
    }

    // ==========================================================
    // QUERY 7: Full Client History
    // ==========================================================
    public static ArrayList<String> getClientHistory(int clientId) {
        ArrayList<String> list = new ArrayList<>();

        // SERVICES
        list.add("=== SERVICES USED ===");

        String sql1 =
            "SELECT S.service_name, E.start_date, E.end_date " +
            "FROM Engagement E JOIN Service S ON E.service_id = S.service_id " +
            "WHERE client_id = ?";

        String sql2 =
            "SELECT amount_paid, payment_date " +
            "FROM Payment P " +
            "JOIN Invoice I ON P.invoice_id = I.invoice_id " +
            "JOIN Engagement E ON I.engagement_id = E.engagement_id " +
            "WHERE E.client_id = ?";

        try (Connection con = getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(sql1)) {

                ps.setInt(1, clientId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    list.add(
                        "Service: " + rs.getString("service_name") +
                        " | Start: " + rs.getString("start_date") +
                        " | End: " + rs.getString("end_date")
                    );
                }

            } catch (SQLException e) {
                list.add("SQL ERROR (Services): " + e.getMessage());
            }

            // PAYMENTS
            list.add("\n=== PAYMENTS ===");

            try (PreparedStatement ps = con.prepareStatement(sql2)) {

                ps.setInt(1, clientId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    list.add(
                        "Paid: $" + rs.getDouble("amount_paid") +
                        " | Date: " + rs.getString("payment_date")
                    );
                }

            } catch (SQLException e) {
                list.add("SQL ERROR (Payments): " + e.getMessage());
            }
        } catch (SQLException e) {
            list.add("SQL ERROR (Connection): " + e.getMessage());
        }

        return list;
    }

    // ==========================================================
    // MAIN METHOD — For Backend Testing Only
    // ==========================================================
    public static void main(String[] args) {

    
    }
}
