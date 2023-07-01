/*
 * Created by JFormDesigner on Tue Jun 20 19:07:37 CST 2023
 */

package com.yiyuan.add;

import com.yiyuan.a.DssDao;
import com.yiyuan.b.Dss;
import com.yiyuan.c.MainFram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 药品信息添加界面
 * 继承JFrame类
 */
public class DssAdd extends JFrame {
    public DssAdd() {
        initComponents();
    }

    /**
     * 初始化窗体组件
     * 自动生成的代码（用JFormDesigner设计界面时自动生成的）
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        d_id = new JTextField();
        d_name = new JTextField();
        d_type = new JTextField();
        d_number = new JTextField();
        d_id_id = new JTextField();
        d_unit = new JTextField();
        d_spec = new JTextField();
        d_price = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        setPreferredSize(new Dimension(480,450));

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u836f\u54c1\u4fe1\u606f\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(65, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u836f\u54c1\u7f16\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(65, 60), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u836f\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label3);
        label3.setBounds(65, 95, 60, 17);

        //---- label4 ----
        label4.setText("\u836f\u54c1\u7c7b\u578b\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(65, 130), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u836f\u54c1\u6570\u91cf\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(65, 170), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u8d27\u67b6\u7f16\u53f7\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(65, 200), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u836f\u54c1\u5355\u4f4d\uff1a");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(65, 235), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u836f\u54c1\u89c4\u683c\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(65, 270), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u836f\u54c1\u5355\u4ef7\uff1a");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(65, 300), label9.getPreferredSize()));
        contentPane.add(d_id);
        d_id.setBounds(135, 60, 255, d_id.getPreferredSize().height);
        contentPane.add(d_name);
        d_name.setBounds(135, 95, 255, 24);
        contentPane.add(d_type);
        d_type.setBounds(135, 130, 255, 24);
        contentPane.add(d_number);
        d_number.setBounds(135, 170, 255, 24);
        contentPane.add(d_id_id);
        d_id_id.setBounds(135, 200, 255, 24);
        contentPane.add(d_unit);
        d_unit.setBounds(135, 230, 255, 24);
        contentPane.add(d_spec);
        d_spec.setBounds(135, 265, 255, 24);
        contentPane.add(d_price);
        d_price.setBounds(135, 295, 255, 24);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 340), button1.getPreferredSize()));

        //添加按钮点击事件，插入药品数据
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String d_idTemp =d_id.getText();
                String d_nameTemp = d_name.getText();
                String d_typeTemp= d_type.getText();
                int d_numberTemp = Integer.parseInt(d_number.getText());
                String d_id_idTemp= d_id_id.getText();
                String d_unitTemp= d_unit.getText();
                String d_specTemp= d_spec.getText();
                String d_priceTemp= d_price.getText();

                //药品编号必填
                if(d_idTemp.trim().equals("")){
                    JOptionPane.showMessageDialog(null,"药品编号必填");
                    return;
                }

                Dss dss = new Dss(d_idTemp,d_nameTemp,d_typeTemp,d_numberTemp,d_id_idTemp,d_unitTemp,d_specTemp,d_priceTemp);
                DssDao dssDao = new DssDao();
                boolean res =false;
                try{
                    res=dssDao.addDss(dss);
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

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(280, 345), button2.getPreferredSize()));

        //返回按钮点击事件，关闭当前界面，返回上一界面
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

    //程序入口
    public static void main(String[] args) throws Exception{
        DssAdd dssAdd=new DssAdd();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField d_id;
    private JTextField d_name;
    private JTextField d_type;
    private JTextField d_number;
    private JTextField d_id_id;
    private JTextField d_unit;
    private JTextField d_spec;
    private JTextField d_price;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
