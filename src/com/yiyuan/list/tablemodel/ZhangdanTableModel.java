package com.yiyuan.list.tablemodel;

import com.yiyuan.a.D_dssDao;
import com.yiyuan.a.ZhangdanDao;
import com.yiyuan.b.D_dss;
import com.yiyuan.b.Zhangdan;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ZhangdanTableModel extends DefaultTableModel {
    ZhangdanDao zhangdanDao = new ZhangdanDao();
    String[] tableHeaders = new String[]{"就诊号","患者姓名","药品名称","数量","单价","金额总计","收银员编号"};
    List zhangdanList = null;
    String[][] zhangdanDate=null;
    public ZhangdanTableModel() throws Exception{
        zhangdanList = zhangdanDao.getAllZhangdan();
        zhangdanDate = new String[zhangdanList.size()][tableHeaders.length];
        for (int i =0;i < zhangdanList.size();i++){
            Zhangdan zhangdan =(Zhangdan) zhangdanList.get(i);
            zhangdanDate[i][0] = zhangdan.get就诊号();
            zhangdanDate[i][1] = zhangdan.get患者姓名();
            zhangdanDate[i][2] = zhangdan.get药品名称();
            zhangdanDate[i][3] = zhangdan.get数量();
            zhangdanDate[i][4] = zhangdan.get单价();
            zhangdanDate[i][5] = zhangdan.get金额总计();
            zhangdanDate[i][6] = zhangdan.get收银员编号();
        }
        this.setDataVector(zhangdanDate,tableHeaders);
    }
}
