import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class SearchPanel extends JPanel {
private EggrafesFrame frame_ref;
private JButton back_button;
private JButton insert_button;
private JTextField last_name_field;
private JButton search_button;
public SearchPanel(EggrafesFrame frame) {
frame_ref = frame;
initComponents();
}
private void initComponents() {
last_name_field = new JTextField();
search_button = new JButton();
insert_button = new JButton();
back_button = new JButton();
setBackground(new Color(231, 255, 255));
search_button.setText("Αναζήτηση Υπαλλήλου");
search_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
ArrayList<Employee> employees =
frame_ref.select_employees_from_db(last_name_field.getText());
// for(int i = 0; i < employees.length; i++) {
// System.out.printf("%s %s\n",
employees[i].getName(), employees[i].getTitlos());
// }
if(employees.size() > 0)
frame_ref.set_view(employees);
}
});
insert_button.setText("Εισαγωγή");
insert_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
frame_ref.set_view("insert");
}
});
back_button.setText("<-");
back_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
frame_ref.set_view("main");
}
});
[20]
GroupLayout layout = new GroupLayout(this);
this.setLayout(layout);
layout.setHorizontalGroup(layout.createParallelGroup(GroupLayou
t.Alignment.LEADING).addGroup(layout
.createSequentialGroup()
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEAD
ING).addGroup(layout
.createSequentialGroup()
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEAD
ING)
.addGroup(layout.createSequentialGroup().addGap(253, 253,
253).addComponent(
last_name_field, GroupLayout.PREFERRED_SIZE, 186,
GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup().addGap(264, 264,
264).addComponent(
search_button, GroupLayout.PREFERRED_SIZE, 166,
GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup().addGap(302, 302,
302).addComponent(
insert_button, GroupLayout.PREFERRED_SIZE, 97,
GroupLayout.PREFERRED_SIZE)))
.addGap(0, 255,
Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup().addGap(0, 0,
Short.MAX_VALUE).addComponent(back_button)))
.addContainerGap()));
layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.
Alignment.LEADING)
.addGroup(layout.createSequentialGroup().addContainerGap().addC
omponent(back_button).addGap(56, 56, 56)
.addComponent(last_name_field,
GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(search_button,
GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(insert_button,
GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
.addContainerGap(125,
Short.MAX_VALUE)));
}// </editor-fold>
}