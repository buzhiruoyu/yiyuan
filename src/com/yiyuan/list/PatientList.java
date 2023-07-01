/*
 * Created by JFormDesigner on Mon Jun 19 14:32:42 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.a.PatientDao;
import com.yiyuan.b.Patient;
import com.yiyuan.c.MainFram;
import com.yiyuan.list.tablemodel.PatientTableModel;

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
public class PatientList extends JFrame {
    public PatientList() throws Exception {
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
        p_sex = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        p_id = new JTextField();
        p_name = new JTextField();
        p_age = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
           table1.setPreferredSize(new Dimension(555,400));
           table1.setModel(new PatientTableModel());
           scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 450, 150);

        //---- label1 ----
        label1.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 170), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(255, 175), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u60a3\u8005\u6027\u522b\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 220), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u5e74\u9f84\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(250, 220), label4.getPreferredSize()));
        contentPane.add(p_sex);
        p_sex.setBounds(100, 215, 135, p_sex.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(45, 270), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = p_id.getText();
                String name = p_name.getText();
                String sex = p_sex.getText();
                String age = String.valueOf(Integer.parseInt(p_age.getText()));
                Patient patient = new Patient(id,name,sex,age);
                PatientDao patientDao = new PatientDao();
                boolean res = patientDao.modifyPatient(patient);
                if(p_sex.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请选择修改的身份找号");
                }else {
                    if(res){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        PatientTableModel patientTableModel = null;
                        try{
                            patientTableModel = new PatientTableModel();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        table1.setModel(patientTableModel);
                    }else {
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(180, 270), button2.getPreferredSize()));

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"你确定要删除该患者吗");
                if(res==0){
                    if(p_id.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"请先选择要删除患者");
                    }else {
                        Patient patient = new Patient();
                        patient.setP_id(p_id.getText());
                        PatientDao patientDao= new PatientDao();
                        try{
                            String magSting = patientDao.deletePatient(patient);
                            JOptionPane.showMessageDialog(null,magSting);
                            PatientTableModel patientTableModel = new PatientTableModel();
                            table1.setModel(patientTableModel);
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
        button3.setBounds(new Rectangle(new Point(325, 270), button3.getPreferredSize()));
        contentPane.add(p_id);
        p_id.setBounds(100, 170, 135, 24);
        contentPane.add(p_name);
        p_name.setBounds(295, 170, 135, 24);
        contentPane.add(p_age);
        p_age.setBounds(295, 215, 135, 24);

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
                String p_IdTemp = (String) table1.getValueAt(row,0);
                String p_NameTemp = (String) table1.getValueAt(row,1);
                String p_sexTemp = (String) table1.getValueAt(row,2);
                String p_ageTemp = (String) table1.getValueAt(row,3);
                p_id.setText(p_IdTemp);
                p_name.setText(p_NameTemp);
                p_sex.setText(p_sexTemp);
                p_age.setText(String.valueOf(p_ageTemp));
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
        PatientList patientList = new PatientList();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField p_sex;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField p_id;
    private JTextField p_name;
    private JTextField p_age;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
