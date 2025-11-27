package nits_ui.data;

import cosc578.COSC578;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
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
}
