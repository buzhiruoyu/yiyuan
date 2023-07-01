package com.yiyuan.list.tablemodel;

import com.yiyuan.a.DoctorDao;
import com.yiyuan.b.Doctor;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DoctorTableModel extends DefaultTableModel {
    DoctorDao doctorDao = new DoctorDao();
    String[] tableHeaders = new String[]{"医生编号","科室编号","医生姓名","性别","年龄","职称","挂号费","类型"};
    List doctorList = null;
    String[][] doctorDate=null;
    public DoctorTableModel() throws Exception{
        doctorList = doctorDao.getAllDoctor();
        doctorDate = new String[doctorList.size()][tableHeaders.length];
        for (int i =0;i < doctorList.size();i++){
            Doctor doctor =(Doctor) doctorList.get(i);
            doctorDate[i][0] = doctor.getD_id();
            doctorDate[i][1] = doctor.getA_id();
            doctorDate[i][2] = doctor.getD_name();
            doctorDate[i][3] = doctor.getD_sex();
            doctorDate[i][4] = String.valueOf(doctor.getD_age());
            doctorDate[i][5] = doctor.getD_type();
            doctorDate[i][6] = doctor.getD_price();
            doctorDate[i][7] = doctor.getD_type1();


        }
        this.setDataVector(doctorDate,tableHeaders);
    }
}
