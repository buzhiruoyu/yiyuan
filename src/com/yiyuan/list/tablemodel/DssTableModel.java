package com.yiyuan.list.tablemodel;

import com.yiyuan.a.DssDao;
import com.yiyuan.a.PatientDao;
import com.yiyuan.b.Dss;
import com.yiyuan.b.Patient;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DssTableModel extends DefaultTableModel {
    DssDao dssDao = new DssDao();
    String[] tableHeaders = new String[]{"药品编号","药品名称","药品类型","数量","货架编号","规格","单位","价格"};
    List dssList = null;
    String[][] dssDate=null;
    public DssTableModel() throws Exception{
        dssList = dssDao.getAllDSS();
        dssDate = new String[dssList.size()][tableHeaders.length];
        for (int i =0;i < dssList.size();i++){
            Dss dss =(Dss) dssList.get(i);
            dssDate[i][0] = dss.getD_id();
            dssDate[i][1] = dss.getD_name();
            dssDate[i][2] = dss.getD_type();
            dssDate[i][3] = String.valueOf(dss.getD_number());
            dssDate[i][4] = dss.getD_id_id();
            dssDate[i][5] = dss.getD_unit();
            dssDate[i][6] = dss.getD_spec();
            dssDate[i][7] = dss.getD_price();

        }
        this.setDataVector(dssDate,tableHeaders);
    }
}
