package nits_ui.data;

import cosc578.COSC578;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple data-access facade that lets the UI reuse the COSC578 backend
 * connection logic without duplicating credentials or JDBC boilerplate.
 */
public final class BackendBridge {

    private static final String PLACEHOLDER = "-";

    private BackendBridge() {
    }

    public static List<Object[]> loadClients() throws SQLException {
        final String sql =
            "SELECT client_id, first_name, last_name, phone, email, " +
            "address, city, state, zip " +
            "FROM Client ORDER BY client_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("client_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    defaultString(rs.getString("phone")),
                    defaultString(rs.getString("email")),
                    buildAddress(rs.getString("address"),
                                 rs.getString("city"),
                                 rs.getString("state"),
                                 rs.getString("zip")),
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER
                });
            }
        }
        return rows;
    }

    public static List<Object[]> loadEmployees() throws SQLException {
        final String sql =
            "SELECT employee_id, first_name, last_name, phone, email " +
            "FROM Employee ORDER BY employee_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("employee_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    defaultString(rs.getString("phone")),
                    defaultString(rs.getString("email")),
                    PLACEHOLDER,
                    PLACEHOLDER
                });
            }
        }
        return rows;
    }

    public static List<Object[]> loadUpcomingAppointments(LocalDate startDate, int daysAhead)
            throws SQLException {

        LocalDate from = (startDate == null) ? LocalDate.now() : startDate;
        int window = Math.max(daysAhead, 1);
        LocalDate to = from.plusDays(window);

        final String sql =
            "SELECT A.appointment_id, " +
            "       CONCAT(C.first_name, ' ', C.last_name) AS client_name, " +
            "       CONCAT(E.first_name, ' ', E.last_name) AS employee_name, " +
            "       A.appointment_date, A.appointment_time " +
            "FROM Appointment A " +
            "JOIN Client C ON A.client_id = C.client_id " +
            "JOIN Employee E ON A.employee_id = E.employee_id " +
            "WHERE A.appointment_date BETWEEN ? AND ? " +
            "ORDER BY A.appointment_date ASC, A.appointment_time ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rows.add(new Object[] {
                        rs.getInt("appointment_id"),
                        rs.getString("client_name"),
                        rs.getString("employee_name"),
                        buildDateTime(rs.getDate("appointment_date"),
                                      rs.getTime("appointment_time")),
                        PLACEHOLDER,
                        "Scheduled"
                    });
                }
            }
        }
        return rows;
    }

    public static List<Object[]> loadServices() throws SQLException {
        final String sql =
            "SELECT service_id, service_name, fee " +
            "FROM Service ORDER BY service_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("service_id"),
                    rs.getString("service_name"),
                    PLACEHOLDER,
                    rs.getBigDecimal("fee")
                });
            }
        }
        return rows;
    }

    public static void insertService(Integer serviceId,
                                     String serviceName,
                                     String description,
                                     BigDecimal fee) throws SQLException {

        final boolean useCustomId = serviceId != null && serviceId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Service (service_id, service_name, fee) VALUES (?, ?, ?)"
            : "INSERT INTO Service (service_name, fee) VALUES (?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, serviceId);
            }
            ps.setString(idx++, serviceName);
            ps.setBigDecimal(idx, fee);
            ps.executeUpdate();
        }
    }

    public static void updateService(int serviceId,
                                     String serviceName,
                                     String description,
                                     BigDecimal fee) throws SQLException {

        final String sql = "UPDATE Service SET service_name = ?, fee = ? WHERE service_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, serviceName);
            ps.setBigDecimal(2, fee);
            ps.setInt(3, serviceId);
            ps.executeUpdate();
        }
    }

    public static void deleteService(int serviceId) throws SQLException {
        final String sql = "DELETE FROM Service WHERE service_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, serviceId);
            ps.executeUpdate();
        }
    }

    public static void insertClient(Integer clientId,
                                    String firstName,
                                    String lastName,
                                    String address,
                                    String city,
                                    String state,
                                    String zip,
                                    String phone,
                                    String email) throws SQLException {

        final boolean useCustomId = clientId != null && clientId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Client (client_id, first_name, last_name, address, city, state, zip, phone, email) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            : "INSERT INTO Client (first_name, last_name, address, city, state, zip, phone, email) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, clientId);
            }
            ps.setString(idx++, firstName);
            ps.setString(idx++, lastName);
            ps.setString(idx++, nullIfBlank(address));
            ps.setString(idx++, nullIfBlank(city));
            ps.setString(idx++, nullIfBlank(state));
            ps.setString(idx++, nullIfBlank(zip));
            ps.setString(idx++, nullIfBlank(phone));
            ps.setString(idx++, nullIfBlank(email));

            ps.executeUpdate();
        }
    }

    public static void deleteClient(int clientId) throws SQLException {
        final String sql = "DELETE FROM Client WHERE client_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, clientId);
            ps.executeUpdate();
        }
    }

    public static void insertAppointment(Integer appointmentId,
                                         int clientId,
                                         int employeeId,
                                         LocalDate appointmentDate,
                                         LocalTime appointmentTime) throws SQLException {

        final boolean useCustomId = appointmentId != null && appointmentId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Appointment (appointment_id, appointment_date, appointment_time, client_id, employee_id) "
              + "VALUES (?, ?, ?, ?, ?)"
            : "INSERT INTO Appointment (appointment_date, appointment_time, client_id, employee_id) "
              + "VALUES (?, ?, ?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, appointmentId);
            }
            ps.setDate(idx++, Date.valueOf(appointmentDate));
            ps.setTime(idx++, Time.valueOf(appointmentTime));
            ps.setInt(idx++, clientId);
            ps.setInt(idx++, employeeId);
            ps.executeUpdate();
        }
    }

    public static void deleteAppointment(int appointmentId) throws SQLException {
        final String sql = "DELETE FROM Appointment WHERE appointment_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            ps.executeUpdate();
        }
    }

    public static List<Object[]> loadInvoices() throws SQLException {
        final String sql =
            "SELECT invoice_id, engagement_id, invoice_date, amount " +
            "FROM Invoice ORDER BY invoice_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("invoice_id"),
                    rs.getInt("engagement_id"),
                    defaultString(rs.getString("invoice_date")),
                    PLACEHOLDER,
                    PLACEHOLDER,
                    rs.getBigDecimal("amount")
                });
            }
        }
        return rows;
    }

    public static void insertInvoice(Integer invoiceId,
                                     int engagementId,
                                     LocalDate invoiceDate,
                                     BigDecimal amount) throws SQLException {

        final boolean useCustomId = invoiceId != null && invoiceId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Invoice (invoice_id, invoice_date, amount, engagement_id) VALUES (?, ?, ?, ?)"
            : "INSERT INTO Invoice (invoice_date, amount, engagement_id) VALUES (?, ?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, invoiceId);
            }
            ps.setDate(idx++, Date.valueOf(invoiceDate));
            ps.setBigDecimal(idx++, amount);
            ps.setInt(idx, engagementId);
            ps.executeUpdate();
        }
    }

    public static void updateInvoice(int invoiceId,
                                     int engagementId,
                                     LocalDate invoiceDate,
                                     BigDecimal amount) throws SQLException {

        final String sql =
            "UPDATE Invoice SET invoice_date = ?, amount = ?, engagement_id = ? WHERE invoice_id = ?";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(invoiceDate));
            ps.setBigDecimal(2, amount);
            ps.setInt(3, engagementId);
            ps.setInt(4, invoiceId);
            ps.executeUpdate();
        }
    }

    public static void deleteInvoice(int invoiceId) throws SQLException {
        final String sql = "DELETE FROM Invoice WHERE invoice_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, invoiceId);
            ps.executeUpdate();
        }
    }

    public static List<Object[]> loadPayments() throws SQLException {
        final String sql =
            "SELECT P.payment_id, P.invoice_id, C.client_id, " +
            "       CONCAT(C.first_name, ' ', C.last_name) AS client_name, " +
            "       P.amount_paid, P.payment_date " +
            "FROM Payment P " +
            "JOIN Invoice I ON P.invoice_id = I.invoice_id " +
            "JOIN Engagement E ON I.engagement_id = E.engagement_id " +
            "JOIN Client C ON E.client_id = C.client_id " +
            "ORDER BY P.payment_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("payment_id"),
                    rs.getInt("invoice_id"),
                    formatOption(rs.getInt("client_id"), rs.getString("client_name")),
                    rs.getBigDecimal("amount_paid"),
                    PLACEHOLDER,
                    defaultString(rs.getString("payment_date"))
                });
            }
        }
        return rows;
    }

    public static void insertPayment(Integer paymentId,
                                     int invoiceId,
                                     BigDecimal amount,
                                     LocalDate paymentDate) throws SQLException {

        final boolean useCustomId = paymentId != null && paymentId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Payment (payment_id, invoice_id, amount_paid, payment_date) VALUES (?, ?, ?, ?)"
            : "INSERT INTO Payment (invoice_id, amount_paid, payment_date) VALUES (?, ?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, paymentId);
            }
            ps.setInt(idx++, invoiceId);
            ps.setBigDecimal(idx++, amount);
            ps.setDate(idx, Date.valueOf(paymentDate));
            ps.executeUpdate();
        }
    }

    public static void updatePayment(int paymentId,
                                     int invoiceId,
                                     BigDecimal amount,
                                     LocalDate paymentDate) throws SQLException {

        final String sql =
            "UPDATE Payment SET invoice_id = ?, amount_paid = ?, payment_date = ? WHERE payment_id = ?";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, invoiceId);
            ps.setBigDecimal(2, amount);
            ps.setDate(3, Date.valueOf(paymentDate));
            ps.setInt(4, paymentId);
            ps.executeUpdate();
        }
    }

    public static void deletePayment(int paymentId) throws SQLException {
        final String sql = "DELETE FROM Payment WHERE payment_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, paymentId);
            ps.executeUpdate();
        }
    }

    public static List<Object[]> loadDocuments() throws SQLException {
        final String sql =
            "SELECT D.document_id, D.document_name, C.client_id, " +
            "       CONCAT(C.first_name, ' ', C.last_name) AS client_name " +
            "FROM Document D " +
            "JOIN Client C ON D.client_id = C.client_id " +
            "ORDER BY D.document_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("document_id"),
                    formatOption(rs.getInt("client_id"), rs.getString("client_name")),
                    defaultString(rs.getString("document_name")),
                    PLACEHOLDER,
                    PLACEHOLDER,
                    PLACEHOLDER
                });
            }
        }
        return rows;
    }

    public static void insertDocument(Integer documentId,
                                      int clientId,
                                      String documentName) throws SQLException {

        final boolean useCustomId = documentId != null && documentId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Document (document_id, document_name, client_id) VALUES (?, ?, ?)"
            : "INSERT INTO Document (document_name, client_id) VALUES (?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, documentId);
            }
            ps.setString(idx++, documentName);
            ps.setInt(idx, clientId);
            ps.executeUpdate();
        }
    }

    public static void updateDocument(int documentId,
                                      int clientId,
                                      String documentName) throws SQLException {

        final String sql =
            "UPDATE Document SET document_name = ?, client_id = ? WHERE document_id = ?";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, documentName);
            ps.setInt(2, clientId);
            ps.setInt(3, documentId);
            ps.executeUpdate();
        }
    }

    public static void deleteDocument(int documentId) throws SQLException {
        final String sql = "DELETE FROM Document WHERE document_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, documentId);
            ps.executeUpdate();
        }
    }

    public static List<Object[]> loadEngagements() throws SQLException {
        final String sql =
            "SELECT E.engagement_id, " +
            "       C.client_id, CONCAT(C.first_name, ' ', C.last_name) AS client_name, " +
            "       S.service_id, S.service_name, " +
            "       Emp.employee_id, CONCAT(Emp.first_name, ' ', Emp.last_name) AS preparer_name, " +
            "       E.start_date, E.end_date, E.notes " +
            "FROM Engagement E " +
            "JOIN Client C ON E.client_id = C.client_id " +
            "JOIN Service S ON E.service_id = S.service_id " +
            "JOIN Employee Emp ON E.employee_id = Emp.employee_id " +
            "ORDER BY E.engagement_id ASC";

        List<Object[]> rows = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new Object[] {
                    rs.getInt("engagement_id"),
                    formatOption(rs.getInt("client_id"), rs.getString("client_name")),
                    formatOption(rs.getInt("service_id"), rs.getString("service_name")),
                    formatOption(rs.getInt("employee_id"), rs.getString("preparer_name")),
                    defaultString(rs.getString("start_date")),
                    defaultString(rs.getString("end_date")),
                    PLACEHOLDER,
                    defaultString(rs.getString("notes"))
                });
            }
        }
        return rows;
    }

    public static void insertEngagement(Integer engagementId,
                                        int clientId,
                                        int employeeId,
                                        int serviceId,
                                        LocalDate startDate,
                                        LocalDate expectedCompletion,
                                        String status) throws SQLException {

        final boolean useCustomId = engagementId != null && engagementId > 0;
        final String sql = useCustomId
            ? "INSERT INTO Engagement (engagement_id, client_id, employee_id, service_id, start_date, end_date, notes) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?)"
            : "INSERT INTO Engagement (client_id, employee_id, service_id, start_date, end_date, notes) "
              + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            if (useCustomId) {
                ps.setInt(idx++, engagementId);
            }
            ps.setInt(idx++, clientId);
            ps.setInt(idx++, employeeId);
            ps.setInt(idx++, serviceId);
            ps.setDate(idx++, Date.valueOf(startDate));
            ps.setDate(idx++, Date.valueOf(expectedCompletion));
            ps.setString(idx, nullIfBlank(status));
            ps.executeUpdate();
        }
    }

    public static void updateEngagement(int engagementId,
                                        int clientId,
                                        int employeeId,
                                        int serviceId,
                                        LocalDate startDate,
                                        LocalDate expectedCompletion,
                                        String status) throws SQLException {

        final String sql =
            "UPDATE Engagement SET client_id = ?, employee_id = ?, service_id = ?, " +
            "start_date = ?, end_date = ?, notes = ? WHERE engagement_id = ?";

        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, clientId);
            ps.setInt(2, employeeId);
            ps.setInt(3, serviceId);
            ps.setDate(4, Date.valueOf(startDate));
            ps.setDate(5, Date.valueOf(expectedCompletion));
            ps.setString(6, nullIfBlank(status));
            ps.setInt(7, engagementId);
            ps.executeUpdate();
        }
    }

    public static void deleteEngagement(int engagementId) throws SQLException {
        final String sql = "DELETE FROM Engagement WHERE engagement_id = ?";
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, engagementId);
            ps.executeUpdate();
        }
    }

    public static List<RecordOption> fetchClientOptions() throws SQLException {
        final String sql =
            "SELECT client_id, CONCAT(first_name, ' ', last_name) AS label " +
            "FROM Client ORDER BY first_name, last_name";
        return fetchOptions(sql, "client_id", "label");
    }

    public static List<RecordOption> fetchEmployeeOptions() throws SQLException {
        final String sql =
            "SELECT employee_id, CONCAT(first_name, ' ', last_name) AS label " +
            "FROM Employee ORDER BY first_name, last_name";
        return fetchOptions(sql, "employee_id", "label");
    }

    public static List<RecordOption> fetchServiceOptions() throws SQLException {
        final String sql =
            "SELECT service_id, service_name AS label " +
            "FROM Service ORDER BY service_name";
        return fetchOptions(sql, "service_id", "label");
    }

    public static List<RecordOption> fetchEngagementOptions() throws SQLException {
        final String sql =
            "SELECT E.engagement_id, " +
            "       CONCAT('Eng ', E.engagement_id, ' - ', C.first_name, ' ', C.last_name, ' / ', S.service_name) AS label " +
            "FROM Engagement E " +
            "JOIN Client C ON E.client_id = C.client_id " +
            "JOIN Service S ON E.service_id = S.service_id " +
            "ORDER BY E.engagement_id";
        return fetchOptions(sql, "engagement_id", "label");
    }

    private static List<RecordOption> fetchOptions(String sql,
                                                   String idColumn,
                                                   String labelColumn) throws SQLException {
        List<RecordOption> options = new ArrayList<>();
        try (Connection con = COSC578.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                options.add(new RecordOption(rs.getInt(idColumn), rs.getString(labelColumn)));
            }
        }
        return options;
    }

    private static String formatOption(int id, String label) {
        return id + " - " + defaultString(label);
    }

    private static String buildAddress(String street, String city, String state, String zip) {
        StringBuilder sb = new StringBuilder();
        if (street != null && !street.isBlank()) {
            sb.append(street.trim());
        }
        if (city != null && !city.isBlank()) {
            appendDelimited(sb, city);
        }
        if (state != null && !state.isBlank()) {
            appendDelimited(sb, state);
        }
        if (zip != null && !zip.isBlank()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(zip.trim());
        }
        return sb.length() == 0 ? PLACEHOLDER : sb.toString();
    }

    private static void appendDelimited(StringBuilder sb, String value) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(value.trim());
    }

    private static String buildDateTime(Date date, Time time) {
        if (date == null && time == null) {
            return PLACEHOLDER;
        }
        StringBuilder sb = new StringBuilder();
        if (date != null) {
            sb.append(date.toString());
        }
        if (time != null) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(time.toString());
        }
        return sb.toString();
    }

    private static String defaultString(String value) {
        return (value == null || value.isBlank()) ? PLACEHOLDER : value;
    }

    private static String nullIfBlank(String value) {
        return (value == null || value.isBlank()) ? null : value.trim();
    }
}
