package com.yiyuan.c;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JLabel nameLabel = new JLabel("用户姓名：");//标签
    private JTextField nameText = new JTextField();//用户名输入框
    private JLabel passLabel = new JLabel("用户密码：");//密码标签
    private JPasswordField passwordField = new JPasswordField();//密码输入框
    private JRadioButton adminRadionButton = new JRadioButton("管理员");//管理员选项
//    private JRadioButton teacherRadionButton = new JRadioButton("用户");//教师选项

    private JButton loginButton = new JButton("登录");//登录按钮
    private JButton cancelButton = new JButton("取消");//取消按钮
//    private ButtonGroup buttonGroup = new ButtonGroup();//设置唯一选项

    public Login() throws Exception {
        this.setTitle("医院系统管理系统登陆页面");
        this.setBounds(100, 100, 450, 350);//设置窗口的x,y,宽,高
        this.setVisible(true);//让窗口可见
        this.setLocation(550, 200);//设置窗口位置
        this.setLayout(null);//设置窗口采用绝对布局

        nameLabel.setBounds(73, 61, 82, 36);//设置用户名标签
        this.getContentPane().add(nameLabel);
        nameText.setBounds(170, 61, 171, 36);//设置用户名输入框
        this.getContentPane().add(nameText);

        passLabel.setBounds(73, 120, 82, 36);//设置密码标签
        this.getContentPane().add(passLabel);
        passwordField.setBounds(170, 120, 171, 36);//设置密码输入框
        this.getContentPane().add(passwordField);

        adminRadionButton.setBounds(73, 176, 75, 36);//设置管理员选项
        this.getContentPane().add(adminRadionButton);
//        teacherRadionButton.setBounds(160, 176, 75, 36);//设置老师选项
//        this.getContentPane().add(teacherRadionButton);

//        buttonGroup.add(adminRadionButton);//设置选项唯一
//        buttonGroup.add(teacherRadionButton);//设置选项唯一

        loginButton.setBounds(103, 236, 65, 30);//设置登录按钮
        this.getContentPane().add(loginButton);

        cancelButton.setBounds(275, 236, 65, 30);//设置取消按钮
        this.getContentPane().add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("登录按钮被点击");
                String name = nameText.getText();
                char[] passArr = passwordField.getPassword();
                String pass = new String(passArr);
                System.out.println("name:" + name + " pass:" + new String(passArr));
                if (adminRadionButton.isSelected()){
                    if(name.equals("wujiajun") && pass.equals("123456")){
                        JOptionPane.showMessageDialog(null,"登录成功");

                        MainFram mainFram =new MainFram("管理员","admin");

                    }else {
                        JOptionPane.showMessageDialog(null,"用户名或密码错误");
                        nameText.setText("");
                        passwordField.setText("");
                    }
                }
            }
        });
    }
    public static void main(String[] args) throws Exception {
        Login loginFrame = new Login();
    }
}
