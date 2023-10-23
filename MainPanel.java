import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainPanel extends JPanel {
private JButton enter_button;
private JLabel title_label;
private JButton version_button;
private EggrafesFrame frame_ref;
public MainPanel(EggrafesFrame frame) {
frame_ref = frame;
initComponents();
}
private void initComponents() {
title_label = new JLabel();
enter_button = new JButton();
version_button = new JButton();
setBackground(new Color(231, 255, 255));
title_label.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
title_label.setText("Εφαρμογή Διαχείρισης Εγγραφών
Υπαλλήλων");
enter_button.setText("Είσοδος στην εφαρμογή");
enter_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
frame_ref.set_view("search");
}
});
version_button.setText("Έκδοση");
version_button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JOptionPane.showMessageDialog(frame_ref,
"Έκδοση 0.1!");
}
[17]
});
GroupLayout layout = new GroupLayout(this);
this.setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(96, 96, 96)
.addComponent(title_label))
.addGroup(layout.createSequentialGroup()
.addGap(261, 261, 261)
.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING,
false)
.addComponent(enter_button,
GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
.addComponent(version_button,
GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE))))
.addContainerGap(107, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(38, 38, 38)
.addComponent(title_label)
.addGap(49, 49, 49)
.addComponent(enter_button,
GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(version_button,
GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
.addContainerGap(117, Short.MAX_VALUE))
);
}
}