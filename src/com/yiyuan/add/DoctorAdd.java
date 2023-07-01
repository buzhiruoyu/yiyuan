/*
 * Created by JFormDesigner on Wed Jun 21 17:01:03 CST 2023
 */

package com.yiyuan.add;

import com.yiyuan.a.DoctorDao;
import com.yiyuan.b.Doctor;
import com.yiyuan.c.MainFram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 医生添加界面
 */
public class DoctorAdd extends JFrame {
    public DoctorAdd() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setPreferredSize(new Dimension(460,390));

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u533b\u751f\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 25), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u533b\u751f\u7f16\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 55), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u79d1\u5ba4\u7f16\u53f7\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(50, 85), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u533b\u751f\u59d3\u540d\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(50, 120), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u533b\u751f\u6027\u522b\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(50, 150), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u533b\u751f\u5e74\u9f84\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(50, 180), label6.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u6302\u53f7\u8d39\u7528\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(50, 240), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u6302\u53f7\u7c7b\u578b\uff1a");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(50, 265), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("\u533b\u751f\u804c\u79f0\uff1a");
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(50, 210), label10.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(115, 55, 240, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(115, 85, 240, 24);
        contentPane.add(textField3);
        textField3.setBounds(115, 115, 240, 24);
        contentPane.add(textField4);
        textField4.setBounds(115, 145, 240, 24);
        contentPane.add(textField5);
        textField5.setBounds(115, 175, 240, 24);
        contentPane.add(textField6);
        textField6.setBounds(115, 205, 240, 24);
        contentPane.add(textField7);
        textField7.setBounds(115, 235, 240, 24);
        contentPane.add(textField8);
        textField8.setBounds(115, 260, 240, 24);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(75, 300), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取医生信息
                String dd_idTemp = textField1.getText();
                String a_idTemp = textField2.getText();
                String dd_nameTemp= textField3.getText();
                String dd_sexTemp= textField4.getText();
                int dd_ageTemp = Integer.parseInt(String.valueOf(Integer.parseInt(textField5.getText())));
                String dd_typeTemp= textField6.getText();
                String dd_priceTemp= textField7.getText();
                String dd_type1Temp= textField8.getText();

                // 判断医生编号是否为空
                if(dd_idTemp.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"医生编号必填");
                    return;
                }

                // 创建Doctor对象
                Doctor doctor = new Doctor(dd_idTemp,a_idTemp,dd_nameTemp,dd_sexTemp,dd_ageTemp,dd_typeTemp,dd_priceTemp,dd_type1Temp);

                // 创建DoctorDao对象
                DoctorDao doctorDao = new DoctorDao();
                boolean res =false;
                try{
                    res=doctorDao.addDoctor(doctor);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                // 添加医生成功
                if(res){
                    JOptionPane.showMessageDialog(null,"添加成功");
                }else {
                    JOptionPane.showMessageDialog(null,"添加失败");
                }
            }
        });

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(260, 300), button2.getPreferredSize()));

        // 取消按钮
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFram mainFram = new MainFram("管理员","admin");
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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) throws Exception{
        DoctorAdd doctorAdd=new DoctorAdd();
    }
}
