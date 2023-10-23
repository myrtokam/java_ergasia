import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InsertPanel extends JPanel {
private EggrafesFrame frame_ref;
private JButton back_button;
private JTextField fname_field;
private JLabel fname_label;
private JTextField id_field;
private JLabel id_label;
private JButton insert_button;
private JTextField lname_field;
private JLabel lname_label;
private JComboBox<String> pos_combobox;
private JLabel pos_label;
public InsertPanel(EggrafesFrame frame) {
frame_ref = frame;
initComponents();
}
private void initComponents() {
back_button = new JButton();
id_field = new JTextField();
fname_field = new JTextField();
lname_field = new JTextField();
id_label = new JLabel();
fname_label = new JLabel();
lname_label = new JLabel();
pos_label = new JLabel();
pos_combobox = new JComboBox<>();
insert_button = new JButton();
setBackground(new Color(231, 255, 255));
back_button.setText("<-");
back_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
frame_ref.set_view("search");
}
});
insert_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
System.out.println("click!");
int sel_index =
pos_combobox.getSelectedIndex();
Position pos;
[12]
if(sel_index == 0) {
pos = Position.MANAGER;
} else if(sel_index == 1) {
pos = Position.DEVELOPER;
}
else {
pos = Position.TESTER;
}
frame_ref.insert_employee_to_db(Integer.parseInt(id_field.getTe
xt()), fname_field.getText(), lname_field.getText(), pos);
}
});
id_label.setText("ID:");
fname_label.setText("Όνομα:");
lname_label.setText("Επίθετο:");
pos_label.setText("Θέση:");
pos_combobox.setModel(new DefaultComboBoxModel<>(new String[]
{ "Manager", "Developer", "Tester" }));
insert_button.setText("Εισαγωγή");
GroupLayout layout = new GroupLayout(this);
this.setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup()
.addContainerGap(GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)
.addComponent(back_button))
.addGroup(layout.createSequentialGroup()
.addGap(220, 220, 220)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
.addGroup(layout.createSequentialGroup()
.addComponent(id_label,
GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
.addComponent(id_field,
GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup()
.addComponent(fname_label,
GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
.addComponent(fname_field,
GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
[13]
.addComponent(pos_label,
GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
.addComponent(lname_label,
GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING,
false)
.addComponent(lname_field)
.addComponent(pos_combobox,
GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
.addGap(0, 222, Short.MAX_VALUE)))
.addContainerGap())
.addGroup(layout.createSequentialGroup()
.addGap(256, 256, 256)
.addComponent(insert_button,
GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
.addContainerGap(GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(back_button)
.addGap(43, 43, 43)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
.addComponent(id_field,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
.addComponent(id_label,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
.addComponent(fname_field,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
.addComponent(fname_label,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
.addComponent(lname_field,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
.addComponent(lname_label,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING,
false)
.addComponent(pos_combobox)
.addComponent(pos_label,
GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addComponent(insert_button,
GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
.addContainerGap(22, Short.MAX_VALUE))
);
}
[14]