/*
 * Created by JFormDesigner on Fri Jun 23 13:53:18 CST 2023
 */

package com.yiyuan.add;

import com.yiyuan.a.PatientDao;
import com.yiyuan.a.RegistrationDao;
import com.yiyuan.b.Patient;
import com.yiyuan.b.Registration;
import com.yiyuan.c.MainFram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 添加就诊信息的界面类
 * 包括就诊号、身份证号、医生编号、时间、收银员编号
 */
public class RegistrationAdd extends JFrame {
    public RegistrationAdd() {
        initComponents();
    }

    //组件初始化
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setPreferredSize(new Dimension(400,370));

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u6302\u53f7\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(45, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5c31\u8bca\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(45, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u60a3\u8005\u8eab\u4efd\u8bc1\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(45, 105), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u533b\u751f\u7f16\u53f7\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(45, 145), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u65f6\u95f4\uff1a");
        contentPane.add(label5);
        label5.setBounds(45, 185, label5.getPreferredSize().width, 15);

        //---- label6 ----
        label6.setText("\u6536\u94f6\u5458\u7f16\u53f7\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(45, 220), label6.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(145, 60, 220, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(145, 100, 220, 30);
        contentPane.add(textField3);
        textField3.setBounds(145, 140, 220, 30);
        contentPane.add(textField4);
        textField4.setBounds(145, 175, 220, 30);
        contentPane.add(textField5);
        textField5.setBounds(145, 215, 220, 30);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(55, 265), button1.getPreferredSize()));

        //为添加按钮添加监听事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //获取输入框中的值
                String r_idTemp = textField1.getText();
                String p_idTemp = textField2.getText();
                String dd_idTemp= textField3.getText();
                String r_dataTemp= textField4.getText();
                String r_price_idTemp= textField5.getText();

                //判断就诊号是否填写
                if(r_idTemp.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"就诊号必填");
                    return;
                }
                //创建Registration对象
                Registration registration = new Registration(r_idTemp,p_idTemp,dd_idTemp,r_dataTemp,r_price_idTemp);
                //创建RegistrationDao对象
                RegistrationDao registrationDao = new RegistrationDao();
                boolean res =false;
                try{
                    //调用添加就诊信息的方法
                    res=registrationDao.addRegistration(registration);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                //添加成功提示信息
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
        button2.setBounds(new Rectangle(new Point(235, 265), button2.getPreferredSize()));

        //为“取消”按钮添加监听事件
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭添加就诊信息的界面，打开管理员界面
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

    //组件声明
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) throws Exception{
        //测试
        RegistrationAdd registrationAdd=new RegistrationAdd();

    }
}

