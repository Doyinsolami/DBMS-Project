package nits_ui;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;






public class Home extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Home.class.getName());

    JButton[] menuButtons;
    public Home() {
        initComponents();
        setupMenuButtons();
        styleTable(jTable1);
        
        clients_panel.setVisible(false);
        invoice_panel.setVisible(false);
        appointment_panel.setVisible(false);
        services_panel.setVisible(false);
        engagement_panel.setVisible(false);
        invoice_panel.setVisible(false);
        employee_panel.setVisible(false);
        payments_panel.setVisible(false);
        document_panel.setVisible(false);

    }

private void styleTable(javax.swing.JTable table) {

    // Row height
    table.setRowHeight(35);

    // Cell spacing
    table.setIntercellSpacing(new java.awt.Dimension(10, 10));

    // Remove grid lines
    table.setShowGrid(false);

    // Header styling
    table.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    table.getTableHeader().setBackground(new java.awt.Color(245, 245, 245));
    table.getTableHeader().setForeground(java.awt.Color.BLACK);
    table.getTableHeader().setOpaque(true);

    // Single-color rows (no stripes)
    table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            java.awt.Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            // Padding
            setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));

            // Single-row background
            if (!isSelected) {
                c.setBackground(java.awt.Color.WHITE); // EVERY row white
            } else {
                c.setBackground(new java.awt.Color(220, 235, 255)); // selected color
            }

            return c;
        }
    });
}


private void setupMenuButtons() {

    menuButtons = new JButton[] {
        client, report, payments, documents, 
        invoices, appointments, employees, engagements, services
    };

    for (JButton b : menuButtons) {
    final JButton bFinal = b; // make a final copy

    bFinal.setFocusPainted(false);
    bFinal.setBorderPainted(false);
    bFinal.setContentAreaFilled(false);
    bFinal.setOpaque(true);
    bFinal.setBackground(Color.WHITE);

    bFinal.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            bFinal.setBackground(new Color(240, 240, 240));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            bFinal.setBackground(Color.WHITE);
        }
    });

    bFinal.addActionListener(e -> highlightButton(bFinal));
}

}

private void highlightButton(JButton selected) {
    for (JButton b : menuButtons) {
        b.setBackground(Color.WHITE);
    }
    selected.setBackground(new Color(220, 235, 255));
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboard_left_panel = new javax.swing.JPanel();
        client = new javax.swing.JButton();
        report = new javax.swing.JButton();
        payments = new javax.swing.JButton();
        documents = new javax.swing.JButton();
        invoices = new javax.swing.JButton();
        appointments = new javax.swing.JButton();
        employees = new javax.swing.JButton();
        engagements = new javax.swing.JButton();
        services = new javax.swing.JButton();
        dashboard_right_panel = new javax.swing.JPanel();
        invoice_panel = new javax.swing.JPanel();
        invoice_page_header = new javax.swing.JLabel();
        create_invoice = new javax.swing.JButton();
        delete_invoice = new javax.swing.JButton();
        edit_invoice = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        clients_panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        client_page_header1 = new javax.swing.JLabel();
        add_client1 = new javax.swing.JButton();
        client3 = new javax.swing.JButton();
        client4 = new javax.swing.JButton();
        appointment_panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        appointmentsTable = new javax.swing.JTable();
        client_page_header2 = new javax.swing.JLabel();
        create_appointment = new javax.swing.JButton();
        delete_appointment = new javax.swing.JButton();
        edit_appointment = new javax.swing.JButton();
        services_panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        serviceTable = new javax.swing.JTable();
        client_page_header3 = new javax.swing.JLabel();
        add_service = new javax.swing.JButton();
        delete_service = new javax.swing.JButton();
        edit_service = new javax.swing.JButton();
        engagement_panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        engagementsTable = new javax.swing.JTable();
        client_page_header5 = new javax.swing.JLabel();
        create_engagement = new javax.swing.JButton();
        delete_engagement = new javax.swing.JButton();
        edit_engagement = new javax.swing.JButton();
        employee_panel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        employee_page_header = new javax.swing.JLabel();
        add_employee = new javax.swing.JButton();
        delete_employee = new javax.swing.JButton();
        edit_employee = new javax.swing.JButton();
        payments_panel = new javax.swing.JPanel();
        payment_page_header1 = new javax.swing.JLabel();
        add_payment = new javax.swing.JButton();
        delete_payment = new javax.swing.JButton();
        edit_payment = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        paymentsTable = new javax.swing.JTable();
        document_panel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        documentsTable = new javax.swing.JTable();
        document_page_header = new javax.swing.JLabel();
        add_document = new javax.swing.JButton();
        delete_document = new javax.swing.JButton();
        edit_document = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard_left_panel.setBackground(new java.awt.Color(255, 255, 255));
        dashboard_left_panel.setToolTipText("");

        client.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/users.png"))); // NOI18N
        client.setBorderPainted(false);
        client.setContentAreaFilled(false);
        client.setFocusPainted(false);
        client.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        client.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        client.setIconTextGap(12);
        client.setLabel("Clients");
        client.setOpaque(true);
        client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Home.this.mouseEntered(evt);
            }
        });
        client.addActionListener(this::clientActionPerformed);

        report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/chart-pie.png"))); // NOI18N
        report.setBorderPainted(false);
        report.setContentAreaFilled(false);
        report.setFocusPainted(false);
        report.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        report.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        report.setIconTextGap(12);
        report.setLabel("Reports");
        report.setOpaque(true);
        report.addActionListener(this::reportActionPerformed);

        payments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/credit-card.png"))); // NOI18N
        payments.setBorderPainted(false);
        payments.setContentAreaFilled(false);
        payments.setFocusPainted(false);
        payments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        payments.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        payments.setIconTextGap(12);
        payments.setLabel("Payments");
        payments.setOpaque(true);
        payments.addActionListener(this::paymentsActionPerformed);

        documents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/folder-open.png"))); // NOI18N
        documents.setBorderPainted(false);
        documents.setContentAreaFilled(false);
        documents.setFocusPainted(false);
        documents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        documents.setIconTextGap(12);
        documents.setLabel("Documents");
        documents.setOpaque(true);
        documents.addActionListener(this::documentsActionPerformed);

        invoices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/receipt-text.png"))); // NOI18N
        invoices.setBorderPainted(false);
        invoices.setContentAreaFilled(false);
        invoices.setFocusPainted(false);
        invoices.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoices.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        invoices.setIconTextGap(12);
        invoices.setLabel("Invoices");
        invoices.setOpaque(true);
        invoices.addActionListener(this::invoicesActionPerformed);

        appointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/calendar.png"))); // NOI18N
        appointments.setText("Appointments");
        appointments.setBorderPainted(false);
        appointments.setContentAreaFilled(false);
        appointments.setFocusPainted(false);
        appointments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        appointments.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        appointments.setIconTextGap(12);
        appointments.setOpaque(true);
        appointments.addActionListener(this::appointmentsActionPerformed);

        employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/id-card.png"))); // NOI18N
        employees.setText("Employees");
        employees.setBorderPainted(false);
        employees.setContentAreaFilled(false);
        employees.setFocusPainted(false);
        employees.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        employees.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        employees.setIconTextGap(12);
        employees.setOpaque(true);
        employees.addActionListener(this::employeesActionPerformed);

        engagements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/file-check.png"))); // NOI18N
        engagements.setText("Engagements");
        engagements.setBorderPainted(false);
        engagements.setContentAreaFilled(false);
        engagements.setFocusPainted(false);
        engagements.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        engagements.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        engagements.setIconTextGap(12);
        engagements.setOpaque(true);
        engagements.addActionListener(this::engagementsActionPerformed);

        services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/layers-2.png"))); // NOI18N
        services.setBorderPainted(false);
        services.setContentAreaFilled(false);
        services.setFocusPainted(false);
        services.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        services.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        services.setIconTextGap(12);
        services.setLabel("Services");
        services.setOpaque(true);
        services.addActionListener(this::servicesActionPerformed);

        javax.swing.GroupLayout dashboard_left_panelLayout = new javax.swing.GroupLayout(dashboard_left_panel);
        dashboard_left_panel.setLayout(dashboard_left_panelLayout);
        dashboard_left_panelLayout.setHorizontalGroup(
            dashboard_left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_left_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashboard_left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(documents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(engagements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(services, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        dashboard_left_panelLayout.setVerticalGroup(
            dashboard_left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_left_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(payments, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(documents, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(invoices, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(appointments, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(employees, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(engagements, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(services, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        getContentPane().add(dashboard_left_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, 560));

        dashboard_right_panel.setBackground(new java.awt.Color(255, 255, 255));
        dashboard_right_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invoice_panel.setBackground(new java.awt.Color(255, 255, 255));
        invoice_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invoice_page_header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        invoice_page_header.setText("Invoices");
        invoice_panel.add(invoice_page_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        create_invoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        create_invoice.setText("Create New Invoice");
        create_invoice.setBorderPainted(false);
        create_invoice.setContentAreaFilled(false);
        create_invoice.setFocusPainted(false);
        create_invoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        create_invoice.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        create_invoice.setIconTextGap(12);
        create_invoice.setOpaque(true);
        create_invoice.addActionListener(this::create_invoiceActionPerformed);
        invoice_panel.add(create_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_invoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_invoice.setText("Delete Invoice");
        delete_invoice.setBorderPainted(false);
        delete_invoice.setContentAreaFilled(false);
        delete_invoice.setFocusPainted(false);
        delete_invoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_invoice.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_invoice.setIconTextGap(12);
        delete_invoice.setOpaque(true);
        delete_invoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_invoicemouseEntered(evt);
            }
        });
        delete_invoice.addActionListener(this::delete_invoiceActionPerformed);
        invoice_panel.add(delete_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        edit_invoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_invoice.setText("Edit Invoice");
        edit_invoice.setBorderPainted(false);
        edit_invoice.setContentAreaFilled(false);
        edit_invoice.setFocusPainted(false);
        edit_invoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_invoice.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_invoice.setIconTextGap(12);
        edit_invoice.setOpaque(true);
        edit_invoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_invoicemouseEntered(evt);
            }
        });
        edit_invoice.addActionListener(this::edit_invoiceActionPerformed);
        invoice_panel.add(edit_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Invoice ID", "Engagement ID", "Invoice Date", "Due Date", "Status", "Fee"
            }
        ));
        jScrollPane3.setViewportView(invoicesTable);

        invoice_panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        dashboard_right_panel.add(invoice_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        clients_panel.setBackground(new java.awt.Color(255, 255, 255));
        clients_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ClientID", "First Name", "Last Name", "Phone", "Email", "Address", "Sex", "SSN", "DOB"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Date");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Service ");
            jTable1.getColumnModel().getColumn(7).setHeaderValue("SSN");
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setHeaderValue("DOB");
        }

        clients_panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        client_page_header1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        client_page_header1.setText("Clients");
        clients_panel.add(client_page_header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add_client1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        add_client1.setText("Add Client");
        add_client1.setBorderPainted(false);
        add_client1.setContentAreaFilled(false);
        add_client1.setFocusPainted(false);
        add_client1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_client1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_client1.setIconTextGap(12);
        add_client1.setOpaque(true);
        add_client1.addActionListener(this::add_client1ActionPerformed);
        clients_panel.add(add_client1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        client3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        client3.setText("Delete Client");
        client3.setBorderPainted(false);
        client3.setContentAreaFilled(false);
        client3.setFocusPainted(false);
        client3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        client3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        client3.setIconTextGap(12);
        client3.setOpaque(true);
        client3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                client3mouseEntered(evt);
            }
        });
        client3.addActionListener(this::client3ActionPerformed);
        clients_panel.add(client3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        client4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        client4.setText("Edit Clients");
        client4.setBorderPainted(false);
        client4.setContentAreaFilled(false);
        client4.setFocusPainted(false);
        client4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        client4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        client4.setIconTextGap(12);
        client4.setOpaque(true);
        client4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                client4mouseEntered(evt);
            }
        });
        client4.addActionListener(this::client4ActionPerformed);
        clients_panel.add(client4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        dashboard_right_panel.add(clients_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        appointment_panel.setBackground(new java.awt.Color(255, 255, 255));
        appointment_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Client ", "Employee", "Date", "Service ", "Status"
            }
        ));
        jScrollPane4.setViewportView(appointmentsTable);
        if (appointmentsTable.getColumnModel().getColumnCount() > 0) {
            appointmentsTable.getColumnModel().getColumn(3).setHeaderValue("Date");
            appointmentsTable.getColumnModel().getColumn(4).setHeaderValue("Service ");
            appointmentsTable.getColumnModel().getColumn(5).setResizable(false);
            appointmentsTable.getColumnModel().getColumn(5).setHeaderValue("Status");
        }

        appointment_panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        client_page_header2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        client_page_header2.setText("Appointments");
        appointment_panel.add(client_page_header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        create_appointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        create_appointment.setText("Create Appointment");
        create_appointment.setBorderPainted(false);
        create_appointment.setContentAreaFilled(false);
        create_appointment.setFocusPainted(false);
        create_appointment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        create_appointment.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        create_appointment.setIconTextGap(12);
        create_appointment.setOpaque(true);
        create_appointment.addActionListener(this::create_appointmentActionPerformed);
        appointment_panel.add(create_appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_appointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_appointment.setText("Delete Appointment");
        delete_appointment.setBorderPainted(false);
        delete_appointment.setContentAreaFilled(false);
        delete_appointment.setFocusPainted(false);
        delete_appointment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_appointment.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_appointment.setIconTextGap(12);
        delete_appointment.setOpaque(true);
        delete_appointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_appointmentmouseEntered(evt);
            }
        });
        delete_appointment.addActionListener(this::delete_appointmentActionPerformed);
        appointment_panel.add(delete_appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        edit_appointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_appointment.setText("Edit Appointment");
        edit_appointment.setBorderPainted(false);
        edit_appointment.setContentAreaFilled(false);
        edit_appointment.setFocusPainted(false);
        edit_appointment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_appointment.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_appointment.setIconTextGap(12);
        edit_appointment.setOpaque(true);
        edit_appointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_appointmentmouseEntered(evt);
            }
        });
        edit_appointment.addActionListener(this::edit_appointmentActionPerformed);
        appointment_panel.add(edit_appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        dashboard_right_panel.add(appointment_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        services_panel.setBackground(new java.awt.Color(255, 255, 255));
        services_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Service ID", "Name", "Description", "Fee"
            }
        ));
        jScrollPane5.setViewportView(serviceTable);
        if (serviceTable.getColumnModel().getColumnCount() > 0) {
            serviceTable.getColumnModel().getColumn(3).setHeaderValue("Date");
        }

        services_panel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        client_page_header3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        client_page_header3.setText("Services");
        services_panel.add(client_page_header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        add_service.setText("Add Service");
        add_service.setBorderPainted(false);
        add_service.setContentAreaFilled(false);
        add_service.setFocusPainted(false);
        add_service.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_service.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_service.setIconTextGap(12);
        add_service.setOpaque(true);
        add_service.addActionListener(this::add_serviceActionPerformed);
        services_panel.add(add_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_service.setText("Delete Service");
        delete_service.setActionCommand("Delete Service");
        delete_service.setBorderPainted(false);
        delete_service.setContentAreaFilled(false);
        delete_service.setFocusPainted(false);
        delete_service.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_service.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_service.setIconTextGap(12);
        delete_service.setOpaque(true);
        delete_service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_servicemouseEntered(evt);
            }
        });
        delete_service.addActionListener(this::delete_serviceActionPerformed);
        services_panel.add(delete_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        edit_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_service.setText("Edit Service");
        edit_service.setActionCommand("Edit Service");
        edit_service.setBorderPainted(false);
        edit_service.setContentAreaFilled(false);
        edit_service.setFocusPainted(false);
        edit_service.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_service.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_service.setIconTextGap(12);
        edit_service.setOpaque(true);
        edit_service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_servicemouseEntered(evt);
            }
        });
        edit_service.addActionListener(this::edit_serviceActionPerformed);
        services_panel.add(edit_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        dashboard_right_panel.add(services_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        engagement_panel.setBackground(new java.awt.Color(255, 255, 255));
        engagement_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        engagementsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Engagement ID", "Client ", "Service ", "Preparer", "Start Date", "Expected Completion", "Actual Completion", "Status"
            }
        ));
        jScrollPane7.setViewportView(engagementsTable);
        if (engagementsTable.getColumnModel().getColumnCount() > 0) {
            engagementsTable.getColumnModel().getColumn(2).setHeaderValue("Service ");
            engagementsTable.getColumnModel().getColumn(4).setHeaderValue("Date");
            engagementsTable.getColumnModel().getColumn(6).setResizable(false);
            engagementsTable.getColumnModel().getColumn(7).setResizable(false);
            engagementsTable.getColumnModel().getColumn(7).setHeaderValue("Status");
        }

        engagement_panel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 980, 330));

        client_page_header5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        client_page_header5.setText("Engagements");
        engagement_panel.add(client_page_header5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        create_engagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        create_engagement.setText("Create Engagement");
        create_engagement.setBorderPainted(false);
        create_engagement.setContentAreaFilled(false);
        create_engagement.setFocusPainted(false);
        create_engagement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        create_engagement.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        create_engagement.setIconTextGap(12);
        create_engagement.setOpaque(true);
        create_engagement.addActionListener(this::create_engagementActionPerformed);
        engagement_panel.add(create_engagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_engagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_engagement.setText("Delete Engagement");
        delete_engagement.setBorderPainted(false);
        delete_engagement.setContentAreaFilled(false);
        delete_engagement.setFocusPainted(false);
        delete_engagement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_engagement.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_engagement.setIconTextGap(12);
        delete_engagement.setOpaque(true);
        delete_engagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_engagementmouseEntered(evt);
            }
        });
        delete_engagement.addActionListener(this::delete_engagementActionPerformed);
        engagement_panel.add(delete_engagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        edit_engagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_engagement.setText("Edit Engagement");
        edit_engagement.setBorderPainted(false);
        edit_engagement.setContentAreaFilled(false);
        edit_engagement.setFocusPainted(false);
        edit_engagement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_engagement.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_engagement.setIconTextGap(12);
        edit_engagement.setOpaque(true);
        edit_engagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_engagementmouseEntered(evt);
            }
        });
        edit_engagement.addActionListener(this::edit_engagementActionPerformed);
        engagement_panel.add(edit_engagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        dashboard_right_panel.add(engagement_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        employee_panel.setBackground(new java.awt.Color(255, 255, 255));
        employee_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Phone", "Email", "Role", "Start Date"
            }
        ));
        jScrollPane8.setViewportView(employeesTable);
        if (employeesTable.getColumnModel().getColumnCount() > 0) {
            employeesTable.getColumnModel().getColumn(5).setHeaderValue("Service ");
            employeesTable.getColumnModel().getColumn(6).setHeaderValue("Date");
        }

        employee_panel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        employee_page_header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        employee_page_header.setText("Employees");
        employee_panel.add(employee_page_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add_employee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        add_employee.setText("Add Employee");
        add_employee.setBorderPainted(false);
        add_employee.setContentAreaFilled(false);
        add_employee.setFocusPainted(false);
        add_employee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_employee.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_employee.setIconTextGap(12);
        add_employee.setOpaque(true);
        add_employee.addActionListener(this::add_employeeActionPerformed);
        employee_panel.add(add_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_employee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_employee.setText("Delete Employee");
        delete_employee.setBorderPainted(false);
        delete_employee.setContentAreaFilled(false);
        delete_employee.setFocusPainted(false);
        delete_employee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_employee.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_employee.setIconTextGap(12);
        delete_employee.setOpaque(true);
        delete_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_employeemouseEntered(evt);
            }
        });
        delete_employee.addActionListener(this::delete_employeeActionPerformed);
        employee_panel.add(delete_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        edit_employee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_employee.setText("Edit Employee");
        edit_employee.setBorderPainted(false);
        edit_employee.setContentAreaFilled(false);
        edit_employee.setFocusPainted(false);
        edit_employee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_employee.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_employee.setIconTextGap(12);
        edit_employee.setOpaque(true);
        edit_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_employeemouseEntered(evt);
            }
        });
        edit_employee.addActionListener(this::edit_employeeActionPerformed);
        employee_panel.add(edit_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        dashboard_right_panel.add(employee_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        payments_panel.setBackground(new java.awt.Color(255, 255, 255));
        payments_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        payment_page_header1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        payment_page_header1.setText("Payments");
        payments_panel.add(payment_page_header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add_payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        add_payment.setText("Add Payment");
        add_payment.setBorderPainted(false);
        add_payment.setContentAreaFilled(false);
        add_payment.setFocusPainted(false);
        add_payment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_payment.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_payment.setIconTextGap(12);
        add_payment.setOpaque(true);
        add_payment.addActionListener(this::add_paymentActionPerformed);
        payments_panel.add(add_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_payment.setText("Delete Payment");
        delete_payment.setBorderPainted(false);
        delete_payment.setContentAreaFilled(false);
        delete_payment.setFocusPainted(false);
        delete_payment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_payment.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_payment.setIconTextGap(12);
        delete_payment.setOpaque(true);
        delete_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_paymentmouseEntered(evt);
            }
        });
        delete_payment.addActionListener(this::delete_paymentActionPerformed);
        payments_panel.add(delete_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        edit_payment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_payment.setText("Edit Payment");
        edit_payment.setBorderPainted(false);
        edit_payment.setContentAreaFilled(false);
        edit_payment.setFocusPainted(false);
        edit_payment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_payment.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_payment.setIconTextGap(12);
        edit_payment.setOpaque(true);
        edit_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_paymentmouseEntered(evt);
            }
        });
        edit_payment.addActionListener(this::edit_paymentActionPerformed);
        payments_panel.add(edit_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        paymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Invoice ID", "Client ID", "Amount", "Method", "Date"
            }
        ));
        jScrollPane6.setViewportView(paymentsTable);

        payments_panel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        dashboard_right_panel.add(payments_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        document_panel.setBackground(new java.awt.Color(255, 255, 255));
        document_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        documentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Document ID", "Client ID", "Document Type", "Date", "Notes", "Status"
            }
        ));
        jScrollPane9.setViewportView(documentsTable);

        document_panel.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 870, 330));

        document_page_header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        document_page_header.setText("Documents");
        document_panel.add(document_page_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add_document.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/circle-plus.png"))); // NOI18N
        add_document.setText("Add Document");
        add_document.setBorderPainted(false);
        add_document.setContentAreaFilled(false);
        add_document.setFocusPainted(false);
        add_document.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_document.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_document.setIconTextGap(12);
        add_document.setOpaque(true);
        add_document.addActionListener(this::add_documentActionPerformed);
        document_panel.add(add_document, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        delete_document.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-x.png"))); // NOI18N
        delete_document.setText("Delete Document");
        delete_document.setBorderPainted(false);
        delete_document.setContentAreaFilled(false);
        delete_document.setFocusPainted(false);
        delete_document.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete_document.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete_document.setIconTextGap(12);
        delete_document.setOpaque(true);
        delete_document.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_documentmouseEntered(evt);
            }
        });
        delete_document.addActionListener(this::delete_documentActionPerformed);
        document_panel.add(delete_document, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        edit_document.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nits_ui/icons/user-pen.png"))); // NOI18N
        edit_document.setText("Edit Document");
        edit_document.setBorderPainted(false);
        edit_document.setContentAreaFilled(false);
        edit_document.setFocusPainted(false);
        edit_document.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_document.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit_document.setIconTextGap(12);
        edit_document.setOpaque(true);
        edit_document.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_documentmouseEntered(evt);
            }
        });
        edit_document.addActionListener(this::edit_documentActionPerformed);
        document_panel.add(edit_document, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        dashboard_right_panel.add(document_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        getContentPane().add(dashboard_right_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 940, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientActionPerformed
        // TODO add your handling code here:
        showPanel(clients_panel);
        clients_panel.setVisible(true);
    }//GEN-LAST:event_clientActionPerformed

    private void mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_mouseEntered

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportActionPerformed

    private void create_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_invoiceActionPerformed
        // TODO add your handling code here:
        CreateInvoiceForm form = new CreateInvoiceForm(this, true);
form.setLocationRelativeTo(this);
form.setVisible(true);

String[] data = form.getInvoiceData();

javax.swing.table.DefaultTableModel model =
    (javax.swing.table.DefaultTableModel) invoicesTable.getModel();

model.addRow(data);

    }//GEN-LAST:event_create_invoiceActionPerformed

    private void delete_invoicemouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_invoicemouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_invoicemouseEntered

    private void delete_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_invoiceActionPerformed
        // TODO add your handling code here:
       int row = invoicesTable.getSelectedRow();

if (row == -1) {
    javax.swing.JOptionPane.showMessageDialog(this,
        "Select an invoice to delete");
    return;
}

int confirm = javax.swing.JOptionPane.showConfirmDialog(
    this, "Delete this invoice?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirm == javax.swing.JOptionPane.YES_OPTION) {
    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) invoicesTable.getModel();
    model.removeRow(row);
}

    }//GEN-LAST:event_delete_invoiceActionPerformed

    private void edit_invoicemouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_invoicemouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_invoicemouseEntered

    private void edit_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_invoiceActionPerformed
        // TODO add your handling code here:
        int row = invoicesTable.getSelectedRow();

if (row == -1) {
    javax.swing.JOptionPane.showMessageDialog(this,
        "Select an invoice to edit");
    return;
}

String id      = safeValue(invoicesTable.getValueAt(row, 0));
String engID   = safeValue(invoicesTable.getValueAt(row, 1));
String invDate = safeValue(invoicesTable.getValueAt(row, 2));
String dueDate = safeValue(invoicesTable.getValueAt(row, 3));
String status  = safeValue(invoicesTable.getValueAt(row, 4));
String finalFee= safeValue(invoicesTable.getValueAt(row, 5));

EditInvoiceForm form = new EditInvoiceForm(
    this, true, row, id, engID, invDate, dueDate, status, finalFee
);

form.setLocationRelativeTo(this);
form.setVisible(true);

String[] updated = form.getUpdatedData();

javax.swing.table.DefaultTableModel model =
    (javax.swing.table.DefaultTableModel) invoicesTable.getModel();

for (int i = 0; i < updated.length; i++) {
    model.setValueAt(updated[i], row, i);
}

    }//GEN-LAST:event_edit_invoiceActionPerformed

    private void add_client1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_client1ActionPerformed
        // TODO add your handling code here:
        EditClientForm form = new EditClientForm(this, true);
    form.setLocationRelativeTo(this); 
    form.setVisible(true);

    String[] data = form.getUpdatedData();

    // jTable1 = clients table
    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) jTable1.getModel();

    model.addRow(data);
    }//GEN-LAST:event_add_client1ActionPerformed

    private void client3mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client3mouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_client3mouseEntered

    private void client3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client3ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select a client to delete");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Delete this client?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.removeRow(row);
    }
    }//GEN-LAST:event_client3ActionPerformed

    private void client4mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client4mouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_client4mouseEntered

    private void client4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client4ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select a client to edit");
        return;
    }

    String id = jTable1.getValueAt(row, 0).toString();
    String fn = jTable1.getValueAt(row, 1).toString();
    String ln = jTable1.getValueAt(row, 2).toString();
    String phone = jTable1.getValueAt(row, 3).toString();
    String email = jTable1.getValueAt(row, 4).toString();
    String address = jTable1.getValueAt(row, 5).toString();
    String sex = jTable1.getValueAt(row, 6).toString();   
    String ssn = jTable1.getValueAt(row, 7).toString();  
    String dob = jTable1.getValueAt(row, 8).toString();

    EditClientForm form = new EditClientForm(this, true, row, id, fn, ln, phone, email, address, sex, ssn, dob);
    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] updated = form.getUpdatedData();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) jTable1.getModel();

    for (int i = 0; i < updated.length; i++) {
        model.setValueAt(updated[i], row, i);
    }
    }//GEN-LAST:event_client4ActionPerformed

    private void employeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesActionPerformed
        // TODO add your handling code here:
        showPanel(employee_panel);

    }//GEN-LAST:event_employeesActionPerformed

    private void create_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_appointmentActionPerformed
        // TODO add your handling code here:
        CreateAppointmentForm form = new CreateAppointmentForm(this, true);
    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] data = form.getAppointmentData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) appointmentsTable.getModel();

    model.addRow(data);
    }//GEN-LAST:event_create_appointmentActionPerformed

    private void delete_appointmentmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_appointmentmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_appointmentmouseEntered

    private void delete_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_appointmentActionPerformed
        // TODO add your handling code here:
        int row = appointmentsTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select an appointment to delete");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Delete this appointment?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) appointmentsTable.getModel();
        model.removeRow(row);
    }
    }//GEN-LAST:event_delete_appointmentActionPerformed

    private void edit_appointmentmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_appointmentmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_appointmentmouseEntered

    private void edit_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_appointmentActionPerformed
        // TODO add your handling code here:
        int row = appointmentsTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select an appointment to edit");
        return;
    }

    // Read values safely
    String id      = safeValue(appointmentsTable.getValueAt(row, 0));
    String client  = safeValue(appointmentsTable.getValueAt(row, 1));
    String emp     = safeValue(appointmentsTable.getValueAt(row, 2));
    String date    = safeValue(appointmentsTable.getValueAt(row, 3));
    String service = safeValue(appointmentsTable.getValueAt(row, 4));
    String status  = safeValue(appointmentsTable.getValueAt(row, 5));

    EditAppointmentForm form = new EditAppointmentForm(
        this, true, row, id, client, emp, date, service, status
    );

    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] updated = form.getUpdatedData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) appointmentsTable.getModel();

    for (int i = 0; i < updated.length; i++) {
        model.setValueAt(updated[i], row, i);
    }
    }//GEN-LAST:event_edit_appointmentActionPerformed

    private void appointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentsActionPerformed
        // TODO add your handling code here:
        showPanel(appointment_panel);
    }//GEN-LAST:event_appointmentsActionPerformed


    private void add_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_serviceActionPerformed
        // TODO add your handling code here:
        AddServiceForm form = new AddServiceForm(this, true);
    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] data = form.getServiceData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) serviceTable.getModel();

    model.addRow(data);
    }//GEN-LAST:event_add_serviceActionPerformed

    private void delete_servicemouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_servicemouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_servicemouseEntered

    private void delete_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_serviceActionPerformed
        // TODO add your handling code here:
         int row = serviceTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select a service to delete");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Delete this service?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) serviceTable.getModel();
        model.removeRow(row);
    }
    }//GEN-LAST:event_delete_serviceActionPerformed

    private void edit_servicemouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_servicemouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_servicemouseEntered

    private void edit_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_serviceActionPerformed
        // TODO add your handling code here:
        
    int row = serviceTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select a service to edit");
        return;
    }

    String id = safeValue(serviceTable.getValueAt(row, 0));
    String name = safeValue(serviceTable.getValueAt(row, 1));
    String desc = safeValue(serviceTable.getValueAt(row, 2));
    String fee = safeValue(serviceTable.getValueAt(row, 3));

    EditServiceForm form = new EditServiceForm(
        this, true, row, id, name, desc, fee
    );

    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] updated = form.getUpdatedData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) serviceTable.getModel();

    for (int i = 0; i < updated.length; i++) {
        model.setValueAt(updated[i], row, i);
    }
    }//GEN-LAST:event_edit_serviceActionPerformed

    private void servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesActionPerformed
        // TODO add your handling code here:
        showPanel(services_panel);
    }//GEN-LAST:event_servicesActionPerformed

    private void create_engagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_engagementActionPerformed
        // TODO add your handling code here:
        CreateEngagementForm form = new CreateEngagementForm(this, true);
        form.setLocationRelativeTo(this);
        form.setVisible(true);

        String[] data = form.getEngagementData();

        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) engagementsTable.getModel();

        model.addRow(data);
    }//GEN-LAST:event_create_engagementActionPerformed

    private void delete_engagementmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_engagementmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_engagementmouseEntered

    private void delete_engagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_engagementActionPerformed
        // TODO add your handling code here:
          int row = engagementsTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select an engagement to delete");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Delete this engagement?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) engagementsTable.getModel();
        model.removeRow(row);
    }
    }//GEN-LAST:event_delete_engagementActionPerformed

    private void edit_engagementmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_engagementmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_engagementmouseEntered

    private void edit_engagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_engagementActionPerformed
        // TODO add your handling code here:
         int row = engagementsTable.getSelectedRow();

        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Select an engagement to edit");
            return;
        }

        // Get values
        String id      = safeValue(engagementsTable.getValueAt(row, 0));
        String client  = safeValue(engagementsTable.getValueAt(row, 1));
        String service = safeValue(engagementsTable.getValueAt(row, 2));
        String prep    = safeValue(engagementsTable.getValueAt(row, 3));
        String start   = safeValue(engagementsTable.getValueAt(row, 4));
        String expect  = safeValue(engagementsTable.getValueAt(row, 5));
        String actual  = safeValue(engagementsTable.getValueAt(row, 6));
        String status  = safeValue(engagementsTable.getValueAt(row, 7));

        EditEngagementForm form = new EditEngagementForm(
            this, true, row, id, client, service, prep, start, expect, actual, status
        );

        form.setLocationRelativeTo(this);
        form.setVisible(true);

        String[] updated = form.getUpdatedData();

        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) engagementsTable.getModel();

        for (int i = 0; i < updated.length; i++) {
            model.setValueAt(updated[i], row, i);
        }
    }//GEN-LAST:event_edit_engagementActionPerformed

    private void engagementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engagementsActionPerformed
        // TODO add your handling code here:
        showPanel(engagement_panel);
    }//GEN-LAST:event_engagementsActionPerformed

    private void invoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesActionPerformed
        // TODO add your handling code here:
        showPanel(invoice_panel);
    }//GEN-LAST:event_invoicesActionPerformed

    private void add_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_employeeActionPerformed
        // TODO add your handling code here:
        AddEmployeeForm form = new AddEmployeeForm(this, true);
    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] data = form.getEmployeeData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) employeesTable.getModel();

    model.addRow(data);
        
    }//GEN-LAST:event_add_employeeActionPerformed

    private void delete_employeemouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_employeemouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_employeemouseEntered

    private void delete_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_employeeActionPerformed
        // TODO add your handling code here:
         int row = employeesTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select an employee to delete");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Delete this employee?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) employeesTable.getModel();
        model.removeRow(row);
    }
    }//GEN-LAST:event_delete_employeeActionPerformed

    private void edit_employeemouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_employeemouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_employeemouseEntered

    private void edit_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_employeeActionPerformed
        // TODO add your handling code here:
        int row = employeesTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Select an employee to edit");
        return;
    }

    // Safely get all values
    String id        = safeValue(employeesTable.getValueAt(row, 0));
    String fn        = safeValue(employeesTable.getValueAt(row, 1));
    String ln        = safeValue(employeesTable.getValueAt(row, 2));
    String phone     = safeValue(employeesTable.getValueAt(row, 3));
    String email     = safeValue(employeesTable.getValueAt(row, 4));
    String role      = safeValue(employeesTable.getValueAt(row, 5));
    String startDate = safeValue(employeesTable.getValueAt(row, 6));

    // Open the EditEmployee dialog
    EditEmployee form = new EditEmployee(
        this, true, row, id, fn, ln, phone, email, role, startDate
    );

    form.setLocationRelativeTo(this);
    form.setVisible(true);

    // Get the updated data
    String[] updated = form.getUpdatedData();

    // Update the table row
    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) employeesTable.getModel();

    for (int i = 0; i < updated.length; i++) {
        model.setValueAt(updated[i], row, i);
    }
    }//GEN-LAST:event_edit_employeeActionPerformed

    private void add_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_paymentActionPerformed
        // TODO add your handling code here:
        AddPaymentForm form = new AddPaymentForm(this, true);
    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] data = form.getPaymentData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) paymentsTable.getModel();

    model.addRow(data);
    }//GEN-LAST:event_add_paymentActionPerformed

    private void delete_paymentmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_paymentmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_paymentmouseEntered

    private void delete_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_paymentActionPerformed
        // TODO add your handling code here:
        int row = paymentsTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select a payment to delete");
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this, "Delete this payment?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) paymentsTable.getModel();
        model.removeRow(row);
    }
    }//GEN-LAST:event_delete_paymentActionPerformed

    private void edit_paymentmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_paymentmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_paymentmouseEntered

    private void edit_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_paymentActionPerformed
        // TODO add your handling code here:
          int row = paymentsTable.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Select a payment to edit");
        return;
    }

    // Correct column reading
    String id      = safeValue(paymentsTable.getValueAt(row, 0));
    String invoice = safeValue(paymentsTable.getValueAt(row, 1));
    String client  = safeValue(paymentsTable.getValueAt(row, 2));
    String amount  = safeValue(paymentsTable.getValueAt(row, 3));
    String method  = safeValue(paymentsTable.getValueAt(row, 4));
    String date    = safeValue(paymentsTable.getValueAt(row, 5));

    // Open Edit Form
    EditPaymentForm form = new EditPaymentForm(
        this, true, row, id, invoice, client, amount, method, date
    );

    form.setLocationRelativeTo(this);
    form.setVisible(true);

    // Replace row
    String[] updated = form.getUpdatedData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) paymentsTable.getModel();

    for (int i = 0; i < updated.length; i++) {
        model.setValueAt(updated[i], row, i);
    }
    }//GEN-LAST:event_edit_paymentActionPerformed

    private void paymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentsActionPerformed
        // TODO add your handling code here:
        showPanel(payments_panel);
    }//GEN-LAST:event_paymentsActionPerformed

    private void add_documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_documentActionPerformed
        // TODO add your handling code here:
        AddDocumentForm form = new AddDocumentForm(this, true);
    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] data = form.getDocumentData();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) documentsTable.getModel();

    model.addRow(data);
    }//GEN-LAST:event_add_documentActionPerformed

    private void delete_documentmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_documentmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_documentmouseEntered

    private void delete_documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_documentActionPerformed
        // TODO add your handling code here:
        int row = documentsTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a document to delete");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this, "Delete this document?", "Confirm", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model =
                    (DefaultTableModel) documentsTable.getModel();
            model.removeRow(row);
        }

    }//GEN-LAST:event_delete_documentActionPerformed

    private void edit_documentmouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_documentmouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_documentmouseEntered

    private void edit_documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_documentActionPerformed
        // TODO add your handling code here:
         int row = documentsTable.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Select a document to edit");
        return;
    }

    String id      = safeValue(documentsTable.getValueAt(row, 0));
    String client  = safeValue(documentsTable.getValueAt(row, 1));
    String type    = safeValue(documentsTable.getValueAt(row, 2));
    String date    = safeValue(documentsTable.getValueAt(row, 3));
    String notes   = safeValue(documentsTable.getValueAt(row, 4));
    String status  = safeValue(documentsTable.getValueAt(row, 5));

    EditDocumentForm form = new EditDocumentForm(
        this, true, row, id, client, type, date, notes, status
    );

    form.setLocationRelativeTo(this);
    form.setVisible(true);

    String[] updated = form.getUpdatedData();

    DefaultTableModel model =
        (DefaultTableModel) documentsTable.getModel();

    for (int i = 0; i < updated.length; i++) {
        model.setValueAt(updated[i], row, i);
    }
    }//GEN-LAST:event_edit_documentActionPerformed

    private void documentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentsActionPerformed
        // TODO add your handling code here:
        showPanel(document_panel); 
    }//GEN-LAST:event_documentsActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
    }
    
    private void showPanel(javax.swing.JPanel panel) {
    dashboard_right_panel.removeAll();
    dashboard_right_panel.add(panel, 
        new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    panel.setVisible(true);
    dashboard_right_panel.revalidate();
    dashboard_right_panel.repaint();
}
    private String safeValue(Object obj) {
    return obj == null ? "" : obj.toString();
}
    public javax.swing.JTable getEngagementsTable() {
    return engagementsTable;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_client1;
    private javax.swing.JButton add_document;
    private javax.swing.JButton add_employee;
    private javax.swing.JButton add_payment;
    private javax.swing.JButton add_service;
    private javax.swing.JPanel appointment_panel;
    private javax.swing.JButton appointments;
    private javax.swing.JTable appointmentsTable;
    private javax.swing.JButton client;
    private javax.swing.JButton client3;
    private javax.swing.JButton client4;
    private javax.swing.JLabel client_page_header1;
    private javax.swing.JLabel client_page_header2;
    private javax.swing.JLabel client_page_header3;
    private javax.swing.JLabel client_page_header5;
    private javax.swing.JPanel clients_panel;
    private javax.swing.JButton create_appointment;
    private javax.swing.JButton create_engagement;
    private javax.swing.JButton create_invoice;
    private javax.swing.JPanel dashboard_left_panel;
    private javax.swing.JPanel dashboard_right_panel;
    private javax.swing.JButton delete_appointment;
    private javax.swing.JButton delete_document;
    private javax.swing.JButton delete_employee;
    private javax.swing.JButton delete_engagement;
    private javax.swing.JButton delete_invoice;
    private javax.swing.JButton delete_payment;
    private javax.swing.JButton delete_service;
    private javax.swing.JLabel document_page_header;
    private javax.swing.JPanel document_panel;
    private javax.swing.JButton documents;
    private javax.swing.JTable documentsTable;
    private javax.swing.JButton edit_appointment;
    private javax.swing.JButton edit_document;
    private javax.swing.JButton edit_employee;
    private javax.swing.JButton edit_engagement;
    private javax.swing.JButton edit_invoice;
    private javax.swing.JButton edit_payment;
    private javax.swing.JButton edit_service;
    private javax.swing.JLabel employee_page_header;
    private javax.swing.JPanel employee_panel;
    private javax.swing.JButton employees;
    private javax.swing.JTable employeesTable;
    private javax.swing.JPanel engagement_panel;
    private javax.swing.JButton engagements;
    private javax.swing.JTable engagementsTable;
    private javax.swing.JLabel invoice_page_header;
    private javax.swing.JPanel invoice_panel;
    private javax.swing.JButton invoices;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel payment_page_header1;
    private javax.swing.JButton payments;
    private javax.swing.JTable paymentsTable;
    private javax.swing.JPanel payments_panel;
    private javax.swing.JButton report;
    private javax.swing.JTable serviceTable;
    private javax.swing.JButton services;
    private javax.swing.JPanel services_panel;
    // End of variables declaration//GEN-END:variables
}


