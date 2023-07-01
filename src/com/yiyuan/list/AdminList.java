/*
 * Created by JFormDesigner on Wed Jun 21 18:53:08 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.a.AdminDao;
import com.yiyuan.a.DoctorDao;
import com.yiyuan.b.Admin;
import com.yiyuan.b.Doctor;
import com.yiyuan.c.MainFram;
import com.yiyuan.list.tablemodel.AdminTableModel;
import com.yiyuan.list.tablemodel.DoctorTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 吴佳俊
 */
public class AdminList extends JFrame {
    public AdminList() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setPreferredSize(new Dimension(555,400));
            table1.setModel(new AdminTableModel());
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 400, 120);

        //---- label1 ----
        label1.setText("\u79d1\u5ba4\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(15, 160), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u79d1\u5ba4\u540d\u79f0\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(215, 160), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(80, 155, 115, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(270, 155, 115, 24);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(35, 205), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String name = textField2.getText();
                Admin admin = new Admin(id,name);
                AdminDao adminDao = new AdminDao();
                boolean res = adminDao.modifyAdmin(admin);
                if(textField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请选择修改的科室编号");
                }else {
                    if(res){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        AdminTableModel adminTableModel = null;
                        try{
                            adminTableModel = new AdminTableModel();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        table1.setModel(adminTableModel);
                    }else {
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(160, 205), button2.getPreferredSize()));

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"你确定要删除该科室吗");
                if(res==0){
                    if(textField1.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"请先选择要删除的科室");
                    }else {
                        Admin admin = new Admin();
                        admin.setA_id(textField1.getText());
                        AdminDao adminDao= new AdminDao();
                        try{
                            String magSting = adminDao.deleteAdmin(admin);
                            JOptionPane.showMessageDialog(null,magSting);
                            AdminTableModel adminTableModel = new AdminTableModel();
                            table1.setModel(adminTableModel);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        //---- button3 ----
        button3.setText("\u53d6\u6d88");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(285, 205), button3.getPreferredSize()));

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFram mainFram = new MainFram("管理员","管理员");
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                int row = table1.getSelectedRow();//获取鼠标当前点击的行下标
                int col = table1.getSelectedColumn();//获取鼠标当前点击的列下标
                String a_idTemp = (String) table1.getValueAt(row,0);
                String a_nameTemp = (String) table1.getValueAt(row,1);

                textField1.setText(a_idTemp);
                textField2.setText(a_nameTemp);



            }
        });

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) throws Exception {
        AdminList adminList = new AdminList();
    }
}
