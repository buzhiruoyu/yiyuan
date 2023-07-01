package com.yiyuan.list.tablemodel;

import com.yiyuan.a.AdminDao;
import com.yiyuan.a.DoctorDao;
import com.yiyuan.b.Admin;
import com.yiyuan.b.Doctor;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AdminTableModel extends DefaultTableModel {
    AdminDao adminDao = new AdminDao();
    String[] tableHeaders = new String[]{"科室编号","科室名称"};
    List adminList = null;
    String[][] adminDate=null;
    public AdminTableModel() throws Exception{
        adminList = adminDao.getAllAdmin();
        adminDate = new String[adminList.size()][tableHeaders.length];
        for (int i =0;i < adminList.size();i++){
            Admin admin =(Admin) adminList.get(i);
            adminDate[i][0] = admin.getA_id();
            adminDate[i][1] = admin.getA_name();
        }
        this.setDataVector(adminDate,tableHeaders);
    }
}
