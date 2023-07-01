/*
 * Created by JFormDesigner on Sat Jun 24 13:31:26 CST 2023
 */

package com.yiyuan.list;

import com.yiyuan.list.tablemodel.A_administrativeTableModel;
import com.yiyuan.list.tablemodel.D_dssTableModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 吴佳俊
 */
public class D_dssList extends JFrame {
    public D_dssList() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setPreferredSize(new Dimension(555,500));
            table1.setModel(new D_dssTableModel());
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 400, 135);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) throws Exception {
        D_dssList d_dssList = new D_dssList();
    }
}
