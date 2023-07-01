/*
 * Created by JFormDesigner on Tue Jun 20 20:49:09 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.a.DssDao;
import com.yiyuan.b.Dss;
import com.yiyuan.c.MainFram;
import com.yiyuan.list.tablemodel.DssTableModel;
//import jdk.nashorn.internal.scripts.JO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 吴佳俊
 */
public class DssList extends JFrame {
    public DssList() throws Exception {
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
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setPreferredSize(new Dimension(555,400));
            table1.setModel(new DssTableModel());
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 475, 150);

        //---- label1 ----
        label1.setText("\u836f\u54c1\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 175), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u836f\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 205), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u836f\u54c1\u7c7b\u578b\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 240), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u836f\u54c1\u6570\u91cf\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 275), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u8d27\u67b6\u7f16\u53f7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(260, 175), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u5355\u4f4d\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(260, 205), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u89c4\u683c\uff1a");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(260, 240), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u4ef7\u683c\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(260, 275), label8.getPreferredSize()));
        contentPane.add(d_id);
        d_id.setBounds(90, 175, 140, d_id.getPreferredSize().height);
        contentPane.add(d_name);
        d_name.setBounds(90, 205, 140, 24);
        contentPane.add(d_type);
        d_type.setBounds(90, 235, 140, 24);
        contentPane.add(d_number);
        d_number.setBounds(90, 270, 140, 24);
        contentPane.add(d_id_id);
        d_id_id.setBounds(325, 170, 140, 24);
        contentPane.add(d_unit);
        d_unit.setBounds(325, 205, 140, 24);
        contentPane.add(d_spec);
        d_spec.setBounds(325, 240, 140, 24);
        contentPane.add(d_price);
        d_price.setBounds(325, 275, 140, 24);


        //修改
        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(50, 310), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = d_id.getText();
                String name= d_name.getText();
                String type = d_type.getText();
                int number = Integer.parseInt(d_number.getText());
                String id_id= d_id_id.getText();
                String unit = d_unit.getText();
                String spec = d_spec.getText();
                String price = d_price.getText();
                Dss dss = new Dss(id,name,type,number,id_id,unit,spec,price);
                DssDao dssDao = new DssDao();
                boolean res = dssDao.modifyDss(dss);
                if(d_id.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请先选择修改的药品编号");
                }else {
                    if(res){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        DssTableModel dssTableModel = null;
                        try{
                            dssTableModel = new DssTableModel();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        table1.setModel(dssTableModel);
                    }else {
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(195, 310), button2.getPreferredSize()));

        //删除
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"你确定要删除改药品吗？");
                if(res==0){
                    if(d_id.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"请先选择要删除的药品");
                    }else {
                        Dss dss = new Dss();
                        dss.setD_id(d_id.getText());
                        DssDao dssDao = new DssDao();
                        try{
                            String msgSting = dssDao.deleteDss(dss);
                            JOptionPane.showMessageDialog(null,msgSting);
                            DssTableModel dssTableModel = new DssTableModel();
                            table1.setModel(dssTableModel);
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
        button3.setBounds(new Rectangle(new Point(340, 310), button3.getPreferredSize()));

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFram mainFram = new MainFram("管理员","管理员");
            }
        });

        //给鼠标添加鼠标点击事件
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                int row = table1.getSelectedRow();//获取鼠标当前点击的行下标
                int col = table1.getSelectedColumn();//获取鼠标当前点击的列下标
                String d_idTemp = (String) table1.getValueAt(row,0);
                String d_nameTemp = (String) table1.getValueAt(row,1);
                String d_typeTemp = (String) table1.getValueAt(row,2);
                String d_numberTemp = (String) table1.getValueAt(row,3);
                String d_id_idTemp = (String) table1.getValueAt(row,4);
                String d_unitTemp = (String) table1.getValueAt(row,5);
                String d_specTemp = (String) table1.getValueAt(row,6);
                String d_priceTemp = (String) table1.getValueAt(row,7);
                d_id.setText(d_idTemp);
                d_name.setText(d_nameTemp);
                d_type.setText(d_typeTemp);
                d_number.setText(String.valueOf(d_numberTemp));
                d_id_id.setText(d_id_idTemp);
                d_unit.setText(d_unitTemp);
                d_spec.setText(d_specTemp);
                d_price.setText(d_priceTemp);
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
        DssList dssList = new DssList();
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
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
