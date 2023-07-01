package com.yiyuan.list.tablemodel;

import com.yiyuan.a.PatientDao;
import com.yiyuan.a.RegistrationDao;
import com.yiyuan.b.Patient;
import com.yiyuan.b.Registration;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class RegistrationTableModel extends DefaultTableModel {
    RegistrationDao registrationDao = new RegistrationDao();
    String[] tableHeaders = new String[]{"就诊号","患者身份证号","性医生编号","时间","收银员编号"};
    List registrationList = null;
    String[][] registrationData=null;
    public RegistrationTableModel() throws Exception{
        registrationList = registrationDao.getAllRegistration();
        registrationData = new String[registrationList.size()][tableHeaders.length];
        for (int i =0;i < registrationList.size();i++){
            Registration registration =(Registration) registrationList.get(i);
            registrationData[i][0] = registration.getR_id();
            registrationData[i][1] = registration.getP_id();
            registrationData[i][2] = registration.getDd_id();
            registrationData[i][3] = registration.getR_data();
            registrationData[i][4] = registration.getR_price_id();
        }
        this.setDataVector(registrationData,tableHeaders);
    }
}
