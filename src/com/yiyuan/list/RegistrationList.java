/*
 * Created by JFormDesigner on Fri Jun 23 14:11:33 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.a.AdminDao;
import com.yiyuan.a.MrescriptionDao;
import com.yiyuan.a.RegistrationDao;
import com.yiyuan.b.Admin;
import com.yiyuan.b.Mrescription;
import com.yiyuan.b.Registration;
import com.yiyuan.c.MainFram;
import com.yiyuan.list.tablemodel.AdminTableModel;
import com.yiyuan.list.tablemodel.MrescriptionTableModel;
import com.yiyuan.list.tablemodel.RegistrationTableModel;

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
public class RegistrationList extends JFrame {
    public RegistrationList() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            table1.setPreferredSize(new Dimension(555,400));
            table1.setModel(new RegistrationTableModel());
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 525, 150);
        scrollPane1.setViewportView(table1);

        //---- label1 ----
        label1.setText("\u5c31\u8bca\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 175), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u60a3\u8005\u8eab\u4efd\u8bc1\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 215), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u533b\u751f\u7f16\u53f7\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 250), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u65f6\u95f4\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(300, 175), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u6536\u94f6\u5458\u7f16\u53f7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(300, 215), label5.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(95, 170, 155, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(110, 210, 155, 30);
        contentPane.add(textField3);
        textField3.setBounds(110, 245, 155, 30);
        contentPane.add(textField4);
        textField4.setBounds(355, 165, 155, 30);
        contentPane.add(textField5);
        textField5.setBounds(370, 205, 155, 30);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 290), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String p_id = textField2.getText();
                String dd_id = textField3.getText();
                String data = textField4.getText();
                String price = textField5.getText();
                Registration registration = new Registration(id,p_id,dd_id,data,price);
                RegistrationDao registrationDao = new RegistrationDao();
                boolean res = registrationDao.modifyRegistration(registration);
                if(textField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请选择修改的就诊号");
                }else {
                    if(res){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        RegistrationTableModel registrationTableModel = null;
                        try{
                            registrationTableModel = new RegistrationTableModel();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        table1.setModel(registrationTableModel);
                    }else {
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(225, 290), button2.getPreferredSize()));

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"你确定要删除该挂号吗");
                if(res==0){
                    if(textField1.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"请先选择要删除的挂号");
                    }else {
                        Registration registration = new Registration();
                        registration.setR_id(textField1.getText());
                        RegistrationDao registrationDao= new RegistrationDao();
                        try{
                            String magSting = registrationDao.deleteRegistration(registration);
                            JOptionPane.showMessageDialog(null,magSting);
                            RegistrationTableModel registrationTableModel = new RegistrationTableModel();
                            table1.setModel(registrationTableModel);
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
        button3.setBounds(new Rectangle(new Point(395, 290), button3.getPreferredSize()));

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
                String r_idTemp = (String) table1.getValueAt(row,0);
                String p_idTemp = (String) table1.getValueAt(row,1);
                String dd_idTemp = (String) table1.getValueAt(row,2);
                String r_dataTemp = (String) table1.getValueAt(row,3);
                String r_price_idTemp = (String) table1.getValueAt(row,4);

                textField1.setText(r_idTemp);
                textField2.setText(p_idTemp);
                textField3.setText(dd_idTemp);
                textField4.setText(r_dataTemp);
                textField5.setText(r_price_idTemp);



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
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main (String[] args) throws Exception{
        RegistrationList registrationList = new RegistrationList();
    }
}
