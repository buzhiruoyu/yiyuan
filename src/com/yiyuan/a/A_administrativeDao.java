package com.yiyuan.a;

import com.yiyuan.b.A_administrative;
import com.yiyuan.b.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class A_administrativeDao extends BaseDao{
    public List getAllA_administrative() throws Exception{
        List a_administrativeList = new ArrayList();
        String sql= " select 医生编号,医生姓名,性别,年龄,职称,类型,科室" +
                " from a_administrative ";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String 医生编号 = resultSet.getString("医生编号");
            String 医生姓名 = resultSet.getString("医生姓名");
            String 性别 = resultSet.getString("性别");
            String 年龄 = resultSet.getString("年龄");
            String 职称 = resultSet.getString("职称");
            String 类型 = resultSet.getString("类型");
            String 科室 = resultSet.getString("科室");
            A_administrative a_administrative= new A_administrative(医生编号,医生姓名,性别,年龄,职称,类型,科室);
            a_administrativeList.add(a_administrative);

        }
        return a_administrativeList;

    }
}
