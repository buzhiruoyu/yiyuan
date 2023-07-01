/*
 * Created by JFormDesigner on Fri Jun 23 12:06:53 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.a.AdminDao;
import com.yiyuan.a.MrescriptionDao;
import com.yiyuan.b.Admin;
import com.yiyuan.b.Mrescription;
import com.yiyuan.c.MainFram;
import com.yiyuan.list.tablemodel.AdminTableModel;
import com.yiyuan.list.tablemodel.MrescriptionTableModel;

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
public class MrescriptionList extends JFrame {
    public MrescriptionList() throws Exception {
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
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            table1.setPreferredSize(new Dimension(555,400));
            table1.setModel(new MrescriptionTableModel());
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 495, 130);

        //---- label1 ----
        label1.setText("\u6536\u94f6\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 155), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("时间");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 195), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("就诊结果");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(50, 235), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("就诊号");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(255, 155), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("金额总计");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(255, 200), label5.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(100, 150, 150, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(315, 145, 150, 30);
        contentPane.add(textField3);
        textField3.setBounds(315, 195, 150, 30);
        contentPane.add(textField4);
        textField4.setBounds(100, 195, 150, 30);
        contentPane.add(textField5);
        textField5.setBounds(100, 235, 150, 30);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 280), button1.getPreferredSize()));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String idid = textField2.getText();
                String number = textField3.getText();
                String data = textField4.getText();
                String result = textField5.getText();

                Mrescription mrescription = new Mrescription(id,idid,number,data,result);
                MrescriptionDao mrescriptionDao = new MrescriptionDao();
                boolean res = mrescriptionDao.modifyMrescpition(mrescription);
                if(textField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请选择修改的收银号");
                }else {
                    if(res){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        MrescriptionTableModel mrescriptionTableModel = null;
                        try{
                            mrescriptionTableModel = new MrescriptionTableModel();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        table1.setModel(mrescriptionTableModel);
                    }else {
                        JOptionPane.showMessageDialog(null,"修改失败");
                    }
                }
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(190, 280), button2.getPreferredSize()));

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"你确定要删除该处方吗");
                if(res==0){
                    if(textField1.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"请先选择要删除的处方");
                    }else {
                        Mrescription mrescription = new Mrescription();
                        mrescription.setM_id(textField1.getText());
                        MrescriptionDao mrescriptionDao= new MrescriptionDao();
                        try{
                            String magSting = mrescriptionDao.deleteMrescription(mrescription);
                            JOptionPane.showMessageDialog(null,magSting);
                            MrescriptionTableModel mrescriptionTableModel = new MrescriptionTableModel();
                            table1.setModel(mrescriptionTableModel);
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
        button3.setBounds(new Rectangle(new Point(345, 280), button3.getPreferredSize()));

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
                String m_idTemp = (String) table1.getValueAt(row,0);
                String r_idTemp = (String) table1.getValueAt(row,1);
                String m_numberTemp = (String) table1.getValueAt(row,2);
                String m_dataTemp = (String) table1.getValueAt(row,3);
                String m_resultTemp = (String) table1.getValueAt(row,4);

                textField1.setText(m_idTemp);
                textField2.setText(r_idTemp);
                textField3.setText(m_numberTemp);
                textField4.setText(m_dataTemp);
                textField5.setText(m_resultTemp);




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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) throws Exception {
        MrescriptionList mrescriptionList = new MrescriptionList();
    }
}
