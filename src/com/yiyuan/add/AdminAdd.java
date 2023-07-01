/*
 * Created by JFormDesigner on Wed Jun 21 18:43:22 CST 2023
 */

package com.yiyuan.add;

import com.yiyuan.a.AdminDao;
import com.yiyuan.a.DoctorDao;
import com.yiyuan.b.Admin;
import com.yiyuan.b.Doctor;
import com.yiyuan.c.MainFram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 管理员添加科室的界面类
 * Author: 吴佳俊
 */
public class AdminAdd extends JFrame {
    public AdminAdd() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();   //输入科室编号的文本框
        textField2 = new JTextField();   //输入科室名称的文本框
        button1 = new JButton();         //添加按钮
        button2 = new JButton();         //取消按钮

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setPreferredSize(new Dimension(430,350));

        //---- label1 ---- 界面中的“请输入科室信息：”标签
        label1.setText("\u8bf7\u8f93\u5165\u79d1\u5ba4\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(55, 40), label1.getPreferredSize()));

        //---- label2 ---- 界面中的“科室编号：”标签
        label2.setText("\u79d1\u5ba4\u7f16\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(55, 75), label2.getPreferredSize()));

        //---- label3 ---- 界面中的“科室名称：”标签
        label3.setText("\u79d1\u5ba4\u540d\u79f0\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(55, 130), label3.getPreferredSize()));
        contentPane.add(textField1);    //添加输入科室编号的文本框
        textField1.setBounds(115, 75, 190, textField1.getPreferredSize().height);
        contentPane.add(textField2);    //添加输入科室名称的文本框
        textField2.setBounds(115, 125, 190, 24);

        //---- button1 ---- 添加按钮
        button1.setText("\u6dfb\u52a0");   //按钮上的文本
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(65, 190), button1.getPreferredSize()));

        //添加按钮的事件监听器
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String a_idTemp = textField1.getText();   //获取用户输入的科室编号
                String a_nameTemp = textField2.getText(); //获取用户输入的科室名称

                //判断用户是否输入了科室编号
                if(a_idTemp.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"科室编号必填");
                    return;
                }
                Admin admin = new Admin(a_idTemp,a_nameTemp);   //创建一个新的科室对象
                AdminDao adminDao = new AdminDao();             //创建一个新的科室数据库访问对象
                boolean res =false;
                try{
                    res=adminDao.addAdmin(admin);   //将新的科室对象添加到数据库中
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                if(res){
                    JOptionPane.showMessageDialog(null,"添加成功");

                }else {
                    JOptionPane.showMessageDialog(null,"添加失败");
                }
            }
        });

        //---- button2 ---- 取消按钮
        button2.setText("\u53d6\u6d88");   //按钮上的文本
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(225, 190), button2.getPreferredSize()));

        //取消按钮的事件监听器
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();                                //关闭当前界面
                MainFram mainFram = new MainFram("管理员","admin");   //打开上一级界面（管理员主界面）
            }
        });

        //设置界面的最小大小和首选大小
        {
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
        this.setVisible(true);    //设置界面可见性
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) throws Exception{
        AdminAdd adminAdd=new AdminAdd();   //创建一个新的管理员添加科室的界面对象

    }
}
