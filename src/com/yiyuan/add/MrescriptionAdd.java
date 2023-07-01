/*
 * Created by JFormDesigner on Fri Jun 23 12:26:58 CST 2023
 */

package com.yiyuan.add;

import com.yiyuan.a.DoctorDao;
import com.yiyuan.a.MrescriptionDao;
import com.yiyuan.b.Doctor;
import com.yiyuan.b.Mrescription;
import com.yiyuan.c.MainFram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MrescriptionAdd extends JFrame {
    public MrescriptionAdd() {
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

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u5904\u65b9\u8868\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 20), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u6536\u94f6\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 55), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5c31\u8bca\u53f7\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(50, 85), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u91d1\u989d\u603b\u8ba1\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(50, 120), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u65f6\u95f4\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(50, 155), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u5c31\u8bca\u7ed3\u679c\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(50, 195), label6.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(125, 55, 225, 25);
        contentPane.add(textField2);
        textField2.setBounds(125, 90, 225, 25);
        contentPane.add(textField3);
        textField3.setBounds(125, 125, 225, 25);
        contentPane.add(textField4);
        textField4.setBounds(125, 160, 225, 25);
        contentPane.add(textField5);
        textField5.setBounds(125, 195, 225, 25);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0"); // 添加按钮
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 235), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取文本框输入内容
                String m_idTemp = textField1.getText();
                String r_idTemp = textField2.getText();
                String m_numberTemp= textField3.getText();
                String m_dataTemp= textField4.getText();
                String m_resultTemp= textField5.getText();

                // 如果收银号为空，弹出提示框并返回
                if(m_idTemp.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"收银号必填");
                    return;
                }

                // 创建处方对象
                Mrescription mrescription = new Mrescription(m_idTemp,r_idTemp,m_numberTemp,m_dataTemp,m_resultTemp);
                // 创建处方数据访问对象
                MrescriptionDao mrescriptionDao = new MrescriptionDao();
                boolean res =false;
                try{
                    // 调用添加处方方法
                    res=mrescriptionDao.addMrescription(mrescription);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                // 根据返回结果弹出相应提示框
                if(res){
                    JOptionPane.showMessageDialog(null,"添加成功");

                }else {
                    JOptionPane.showMessageDialog(null,"添加失败");
                }

            }
        });

        //---- button2 ----
        button2.setText("\u53d6\u6d88"); // 取消按钮
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(240, 235), button2.getPreferredSize()));

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前窗口并返回主界面
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
        this.setVisible(true); // 界面可见
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

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
        MrescriptionAdd mrescriptionAdd=new MrescriptionAdd();
    }
}
