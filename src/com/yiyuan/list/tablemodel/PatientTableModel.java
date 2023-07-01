package com.yiyuan.list.tablemodel;

import com.yiyuan.a.PatientDao;
import com.yiyuan.b.Patient;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PatientTableModel  extends DefaultTableModel {
    PatientDao patientDao = new PatientDao();
    String[] tableHeaders = new String[]{"患者身份证号","姓名","性别","年龄"};
    List patientList = null;
    String[][] patientData=null;
    public PatientTableModel() throws Exception{
        patientList = patientDao.getAllPatient();
        patientData = new String[patientList.size()][tableHeaders.length];
        for (int i =0;i < patientList.size();i++){
            Patient patient =(Patient) patientList.get(i);
            patientData[i][0] = patient.getP_id();
            patientData[i][1] = patient.getP_name();
            patientData[i][2] = patient.getP_sex();
            patientData[i][3] = String.valueOf(patient.getP_age());
        }
        this.setDataVector(patientData,tableHeaders);
    }
}
