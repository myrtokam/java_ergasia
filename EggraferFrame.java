import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
public class EggrafesFrame extends JFrame {
private Connection conn;
public EggrafesFrame() {
String url = "jdbc:mysql://localhost:3307/persons";
String username="appuser";
String password = "Xontroula12345@";
try {
conn = DriverManager.getConnection(url, username, password);
System.out.println("Syndethika me thn vash!");
} catch (SQLException e1) {
System.out.println(e1.toString());
}
setSize(700, 350);
[5]
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
set_view("main");
}
// kapoy edw tha syndethw sthn vash
// kai edw tha grapsw synarthseis gia na epikoinwnw me thn vash
public void set_view(String view) {
getContentPane().removeAll(); // diagrafw ta periexomena toy pane toy
frame
if(view.equals("main")) {
getContentPane().add(new MainPanel(this));
}
else if(view.equals("search")) {
getContentPane().add(new SearchPanel(this));
}
else if(view.equals("insert")) {
getContentPane().add(new InsertPanel(this));
}
pack();
}
public void set_view(ArrayList<Employee> empl) {
getContentPane().removeAll(); // diagrafw ta periexomena toy pane toy
frame
getContentPane().add(new ViewPanel(this, empl));
[6]
pack();
}
//public void insert_employee_to_db(int id, String name, String last_name, Position
pos) {
//PreparedStatement ps = conn.prepareStatement("INSERT INTO persons
(id, name, surname, position) ", ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
//}
public void insert_employee_to_db(int id, String name, String last_name, Position
pos) {
try {
String query = "INSERT INTO persons (id, name, surname, position) VALUES (?, ?,
?, ?)";
PreparedStatement ps = conn.prepareStatement(query);
ps.setInt(1, id);
ps.setString(2, name);
ps.setString(3, last_name);
ps.setInt(4, pos.ordinal());
ps.executeUpdate();
System.out.println("Ο εργαζόμενος εισήχθη με επιτυχία στη βάση
δεδομένων.");
} catch (SQLException e) {
System.out.println("Σφάλμα κατά την εισαγωγή του εργαζομένου στη βάση
δεδομένων: " + e.getMessage());
}
}
public ArrayList<Employee> select_employees_from_db(String lname) {
ArrayList<Employee> employee_list = new ArrayList<>();
[7]
try {
// 2. Create a statement
Statement statement = conn.createStatement();
// 3. Execute SQL query
ResultSet resultSet = statement.executeQuery("SELECT * FROM persons WHERE
surname = \"" + lname + "\"");
// 4. Process the result set
while (resultSet.next()) {
int id = resultSet.getInt("id");
String name = resultSet.getString("name");
String surname = resultSet.getString("surname");
int pos_int = resultSet.getInt("position");
Position pos;
if(pos_int == 0) {
pos = Position.DEVELOPER;
} else if(pos_int == 1) {
pos = Position.TESTER;
}
else {
pos = Position.MANAGER;
}
Employee new_employee = new Employee(id, name, surname, pos);
employee_list.add(new_employee);
}
}catch (Exception e){
System.out.println("Σφάλμα κατά την φόρτωση των εργαζομένων
απ' τη βάση δεδομένων: " + e.getMessage());
return null;
}
[8]
return employee_list;
}
public boolean delete_employee_from_db(int id) {
int rowsAffected = 0;
try {
Statement statement = conn.createStatement();
rowsAffected = statement.executeUpdate("DELETE FROM persons WHERE
id = " + id);
System.out.println("Deleted " + rowsAffected + " row(s).");
} catch (SQLException e) {
e.printStackTrace();
}
if(rowsAffected > 0) {
return true;
}
return false;
}
public void update_employee_on_db(int id, String name, String last_name, Position
pos) {
if(delete_employee_from_db(id)) {
insert_employee_to_db(id, name, last_name, pos);
System.out.println("Succesfully updated " + id);
}
else {
System.out.println("Non existent id");
}
[9]
}
// ti thelw apthn vash dedomenwn:
// 1. insert (otan pataw to koympi "Eisagwgh" sto insert panel)
// 2. select (otan pataw to koympi "Anazhthsh Ypallhloy" sto search
panel) kai tha ta deixnei sto view panel
// 3. delete (otan pataw to koympi "Diagrafh" sto view panel - tha to
diagrafei apthn vash dedomenwn (dld aplws tha diagrafw mia grammh) kai apthn efarmogh
// 4. enhmerwsh (otan pataw to koympi "enhmerwsh" sto view
panel)
}