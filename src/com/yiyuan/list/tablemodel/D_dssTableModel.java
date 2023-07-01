package com.yiyuan.list.tablemodel;

import com.yiyuan.a.A_administrativeDao;
import com.yiyuan.a.D_dssDao;
import com.yiyuan.b.A_administrative;
import com.yiyuan.b.D_dss;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class D_dssTableModel extends DefaultTableModel {
    D_dssDao d_dssDao = new D_dssDao();
    String[] tableHeaders = new String[]{"药品名称","药品类别","库存","货架编号","单位","规格","单价","用法"};
    List d_dssList = null;
    String[][] d_dssDate=null;
    public D_dssTableModel() throws Exception{
        d_dssList = d_dssDao.getAllD_dss();
        d_dssDate = new String[d_dssList.size()][tableHeaders.length];
        for (int i =0;i < d_dssList.size();i++){
            D_dss d_dss =(D_dss) d_dssList.get(i);
            d_dssDate[i][0] = d_dss.get药品名称();
            d_dssDate[i][1] = d_dss.get药品类别();
            d_dssDate[i][2] = d_dss.get库存();
            d_dssDate[i][3] = d_dss.get货架编号();
            d_dssDate[i][4] = d_dss.get单位();
            d_dssDate[i][5] = d_dss.get规格();
            d_dssDate[i][6] = d_dss.get单价();
            d_dssDate[i][7] = d_dss.get用法();
        }
        this.setDataVector(d_dssDate,tableHeaders);
    }
}
