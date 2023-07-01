package com.yiyuan.list.tablemodel;

import com.yiyuan.a.AdminDao;
import com.yiyuan.a.MrescriptionDao;
import com.yiyuan.b.Admin;
import com.yiyuan.b.Mrescription;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MrescriptionTableModel extends DefaultTableModel {
    MrescriptionDao mrescriptionDao = new MrescriptionDao();
    String[] tableHeaders = new String[]{"收银号","就诊号","金额总计","时间","就诊结果"};
    List mrescriptionList = null;
    String[][] mrescriptionDate=null;
    public MrescriptionTableModel() throws Exception{
        mrescriptionList = mrescriptionDao.getAllMrescription();
        mrescriptionDate = new String[mrescriptionList.size()][tableHeaders.length];
        for (int i =0;i < mrescriptionList.size();i++){
            Mrescription mrescription =(Mrescription) mrescriptionList.get(i);
            mrescriptionDate[i][0] = mrescription.getM_id();
            mrescriptionDate[i][1] = mrescription.getR_id();
            mrescriptionDate[i][2] = mrescription.getM_number();
            mrescriptionDate[i][3] = mrescription.getM_data();
            mrescriptionDate[i][4] = mrescription.getM_result();
        }
        this.setDataVector(mrescriptionDate,tableHeaders);
    }
}
