/*
 * Created by JFormDesigner on Tue Jun 20 21:14:10 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.a.DoctorDao;
import com.yiyuan.b.Doctor;
import com.yiyuan.c.MainFram;
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
public class DoctorList extends JFrame {
    public DoctorList() throws Exception {
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
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        dd_id = new JTextField();
        a_id = new JTextField();
        dd_name = new JTextField();
        dd_type = new JTextField();
        dd_sex = new JTextField();
        dd_age = new JTextField();
        dd_type1 = new JTextField();
        dd_price = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            table1.setPreferredSize(new Dimension(555,400));
            table1.setModel(new DoctorTableModel());
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 480, 125);

        //---- label1 ----
        label1.setText("\u533b\u751f\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 145), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u79d1\u5ba4\u7f16\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(35, 175), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u533b\u751f\u59d3\u540d\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(35, 205), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("职称");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(35, 235), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u6027\u522b\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(250, 145), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u5e74\u9f84\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(250, 175), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("挂号类型");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(250, 205), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u6302\u53f7\u8d39\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(250, 235), label8.getPreferredSize()));
        contentPane.add(dd_id);
        dd_id.setBounds(90, 140, 145, dd_id.getPreferredSize().height);
        contentPane.add(a_id);
        a_id.setBounds(90, 175, 145, 24);
        contentPane.add(dd_name);
        dd_name.setBounds(90, 205, 145, 24);
        contentPane.add(dd_type);
        dd_type.setBounds(90, 235, 145, 24);
        contentPane.add(dd_sex);
        dd_sex.setBounds(285, 140, 145, 24);
        contentPane.add(dd_age);
        dd_age.setBounds(285, 170, 145, 24);
        contentPane.add(dd_type1);
        dd_type1.setBounds(285, 200, 145, 24);
        contentPane.add(dd_price);
        dd_price.setBounds(295, 230, 145, 24);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 275), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = dd_id.getText();
                String idid = a_id.getText();
                String name = dd_name.getText();
                String sex = dd_sex.getText();
                int age = Integer.parseInt(dd_age.getText());
                String type = dd_type.getText();
                String price = dd_price.getText();
                String type1 = dd_type1.getText();
                Doctor doctor = new Doctor(id,idid,name,sex,age,type,price,type1);
                DoctorDao doctorDao = new DoctorDao();
                boolean res = doctorDao.modifyDoctor(doctor);
                if(dd_id.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请选择修改的医生编号");
                }else {
                    if(res){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        DoctorTableModel doctorTableModel = null;
                        try{
                            doctorTableModel = new DoctorTableModel();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        table1.setModel(doctorTableModel);
                    }else {
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }
            }
        });



        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(190, 275), button2.getPreferredSize()));

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"你确定要删除该医生吗");
                if(res==0){
                    if(dd_id.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"请先选择要删除的医生");
                    }else {
                        Doctor doctor = new Doctor();
                        doctor.setD_id(dd_id.getText());
                        DoctorDao doctorDao= new DoctorDao();
                        try{
                            String magSting = doctorDao.deleteDoctor(doctor);
                            JOptionPane.showMessageDialog(null,magSting);
                            DoctorTableModel doctorTableModel = new DoctorTableModel();
                            table1.setModel(doctorTableModel);
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
        button3.setBounds(new Rectangle(new Point(310, 275), button3.getPreferredSize()));

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
                String dd_IdTemp = (String) table1.getValueAt(row,0);
                String a_idTemp = (String) table1.getValueAt(row,1);
                String dd_nameTemp = (String) table1.getValueAt(row,2);

                String dd_sexTemp = (String) table1.getValueAt(row,3);
                String dd_ageTemp = (String) table1.getValueAt(row,4);
                String dd_typeTemp = (String) table1.getValueAt(row,5);
                String dd_priceTemp = (String) table1.getValueAt(row,6);
                String dd_type1Temp = (String) table1.getValueAt(row,7);



                dd_id.setText(dd_IdTemp);
                a_id.setText(a_idTemp);
                dd_name.setText(dd_nameTemp);
                dd_type.setText(dd_typeTemp);
                dd_sex.setText(dd_sexTemp);
                dd_age.setText(dd_ageTemp);
                dd_type1.setText(dd_type1Temp);
                dd_price.setText(dd_priceTemp);


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
    public static void main(String[] args) throws Exception {
        DoctorList doctorList = new DoctorList();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField dd_id;
    private JTextField a_id;
    private JTextField dd_name;
    private JTextField dd_type;
    private JTextField dd_sex;
    private JTextField dd_age;
    private JTextField dd_type1;
    private JTextField dd_price;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
