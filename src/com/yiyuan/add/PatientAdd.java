/*
 * Created by JFormDesigner on Sun Jun 18 21:04:27 CST 2023
 */

package com.yiyuan.add;

import com.yiyuan.a.PatientDao;
import com.yiyuan.b.Patient;
import com.yiyuan.c.MainFram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 患者信息添加界面
 */
public class PatientAdd extends JFrame {

    /**
     * 构造方法，用于初始化界面
     */
    public PatientAdd() {
        initComponents();
    }

    /**
     * 自动生成的方法，用于初始化界面元素
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        P_id = new JTextField();
        p_name = new JTextField();
        p_sex = new JTextField();
        p_age = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setPreferredSize(new Dimension(380, 370));

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u60a3\u8005\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(60, 20), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("身份证号：");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(60, 50), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("患者姓名：");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(60, 90), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u60a3\u8005\u6027\u522b\uff1a");
        contentPane.add(label4);
        label4.setBounds(60, 130, label4.getPreferredSize().width, 15);

        //---- label5 ----
        label5.setText("\u60a3\u8005\u5e74\u9f84\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(60, 170), label5.getPreferredSize()));
        contentPane.add(P_id);
        P_id.setBounds(120, 50, 190, P_id.getPreferredSize().height);
        contentPane.add(p_name);
        p_name.setBounds(120, 90, 195, p_name.getPreferredSize().height);
        contentPane.add(p_sex);
        p_sex.setBounds(120, 130, 190, p_sex.getPreferredSize().height);
        contentPane.add(p_age);
        p_age.setBounds(120, 170, 190, p_age.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(80, 210), button1.getPreferredSize()));

        //添加监听器，用于添加患者信息
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //获取输入框中的内容
                String p_idTemp = P_id.getText();
                String p_nameTemp = p_name.getText();
                String p_sexTemp= p_sex.getText();
                String p_ageTemp = String.valueOf(Integer.parseInt(p_age.getText()));

                //判断身份证号是否为空
                if(p_idTemp.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"患者身份证必填");
                    return;
                }

                //创建患者对象
                Patient patient = new Patient(p_idTemp,p_nameTemp,p_sexTemp,p_ageTemp);
                PatientDao patientDao = new PatientDao();
                boolean res =false;
                try{
                    //将患者信息添加到数据库
                    res=patientDao.addPatient(patient);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                //提示添加结果
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
        button2.setBounds(new Rectangle(new Point(215, 210), button2.getPreferredSize()));

        //添加监听器，用于关闭当前界面返回主界面
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField P_id;
    private JTextField p_name;
    private JTextField p_sex;
    private JTextField p_age;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * 主函数，用于启动界面
     */
    public static void main(String[] args) throws Exception{
        PatientAdd patientAdd=new PatientAdd();
    }
}

