package com.yiyuan.list.tablemodel;

import com.yiyuan.a.A_administrativeDao;
import com.yiyuan.a.AdminDao;
import com.yiyuan.b.A_administrative;
import com.yiyuan.b.Admin;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class A_administrativeTableModel extends DefaultTableModel {
    A_administrativeDao a_administrativeDao = new A_administrativeDao();
    String[] tableHeaders = new String[]{"医生编号","医生姓名","性别","年龄","职称","类型","科室"};
    List a_aministrativeList = null;
    String[][] a_aministrativeDate=null;
    public A_administrativeTableModel() throws Exception{
        a_aministrativeList = a_administrativeDao.getAllA_administrative();
        a_aministrativeDate = new String[a_aministrativeList.size()][tableHeaders.length];
        for (int i =0;i < a_aministrativeList.size();i++){
            A_administrative a_administrative =(A_administrative) a_aministrativeList.get(i);
            a_aministrativeDate[i][0] = a_administrative.get医生编号();
            a_aministrativeDate[i][1] = a_administrative.get医生姓名();
            a_aministrativeDate[i][2] = a_administrative.get性别();
            a_aministrativeDate[i][3] = a_administrative.get年龄();
            a_aministrativeDate[i][4] = a_administrative.get职称();
            a_aministrativeDate[i][5] = a_administrative.get类型();
            a_aministrativeDate[i][6] = a_administrative.get科室();
        }
        this.setDataVector(a_aministrativeDate,tableHeaders);
    }
}
