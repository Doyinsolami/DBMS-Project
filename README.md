# DBMS-Project

NetBeans-based UI for the NITS (tax services) system plus the COSC578 backend.

## Repository Layout
- `src/` – COSC578 backend logic (database helpers, console smoke tests).
- `DBMS-Project/NITS_UI/` – NetBeans Swing UI project
  - `src/nits_ui/Home.java` → dashboard frame with navigation + data tables.
  - `src/nits_ui/*Form.java` → individual CRUD dialogs (Add/Edit Client, etc.).
  - `src/nits_ui/icons/` → PNG assets used by the buttons.

## Prerequisites
1. JDK 17+ (Project is configured for Java 25 bytecode, so use the latest JDK that NetBeans supports).
2. Apache NetBeans 17+ (simplest way to open/run the forms).
3. Ant 1.10+ if you prefer a CLI workflow.
4. MySQL JDBC driver is already included as `mysql-connector-java-8.0.16.jar`.

## Prepare the Backend Dependency
The UI now reuses the COSC578 backend classes for database access. Build the backend once before launching the UI so the compiled classes exist in `build/classes`:
1. From the repo root (`COSC578/`), run `ant clean compile` (or `ant clean jar`), or simply build the COSC578 project inside NetBeans.
2. Ensure the MySQL connector jar stays at `mysql-connector-java-8.0.16.jar` in the repo root so the UI classpath can resolve it.

## Running the UI in NetBeans
1. Open NetBeans → **File → Open Project…** → select `DBMS-Project/NITS_UI`.
2. NetBeans will detect all forms. Double-click `Home.java` and press **Shift+F6** (Run File) to launch the dashboard, or right-click the project and choose **Run** after setting `Home` as the Main Class (Project Properties → Run → Main Class → `nits_ui.Home`).
3. The Home frame shows the left navigation (Clients, Reports, Payments, Documents, Invoices, Appointments, Employees, Engagements, Services) and swaps panels on the right. Buttons such as “Add Client” or “Create Invoice” open their respective forms.
4. Every `*Form.java` file also has its own generated `main` method, so you can preview an individual dialog by opening it and hitting **Shift+F6**.

### Data entry notes
- **Add Client**: provide at least First/Last Name, Phone, and Email. Client ID is optional; leave it blank to let MySQL auto-increment. The extra UI fields (Sex, SSN, DOB) are not persisted yet.
- **Create Appointment**: enter Client ID, Employee ID, Date (`YYYY-MM-DD`), and Time (`HH:MM` or `HH:MM:SS`). Appointment ID is optional/auto-generated. Status is currently a UI-only column.
- **Add Service**: supply a unique name and fee (ID optional/auto-generated). The description field is UI-only because the current schema doesn’t include a description column.
- **Create Engagement**: requires at least one client, employee, and service already in the database. The dropdowns are populated automatically and store the underlying IDs. Start Date and Expected Completion map to the engagement’s start/end dates; “Status” is saved to the `notes` column and “Actual Completion” is display-only for now.
- **Create Invoice**: select an engagement (auto-populated list), enter the invoice date, and final fee (mapped to the `amount` column). Invoice ID is optional. Due Date and Status remain UI-only placeholders until matching DB fields exist.
- **Add Payment**: provide an invoice ID, amount, and payment date. Payment ID is optional. Method/Client inputs are for display/validation only because the `Payment` table currently stores invoice, amount, and date; the client column in the grid is derived from the invoice’s engagement.
- **Add Document**: supply at least a client ID and document type (the type text maps to `document_name`). Document ID is optional. Date/Notes/Status are placeholders until the schema is expanded.

## Running the UI from the Command Line
```bash
cd DBMS-Project/NITS_UI
ant clean jar
# Launch the dashboard instead of the empty default main:
ant run -Dmain.class=nits_ui.Home
```

To preview a different form, replace `nits_ui.Home` with the desired class (e.g., `nits_ui.AddClientForm`). The Ant run target uses the NetBeans classpath, so the Swing resources and the JDBC driver are already available.

## Connecting to the Backend
- The dashboard now reads from the shared backend. To see live data (and to persist new clients/appointments):
  1. Ensure the COSC578 backend (`src/cosc578/COSC578.java`) can reach your MySQL instance.
  2. Build the COSC578 project so its classes are available to the UI.
  3. Launch the UI and use the forms—each panel reloads from MySQL whenever it becomes visible, so changes remain after refresh.

Following the steps above lets you run the UI with real data today while continuing to expand CRUD coverage to the remaining panels.
