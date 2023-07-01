//导入需要使用的类库
package com.yiyuan.a;

import com.yiyuan.b.Doctor;
import com.yiyuan.b.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//医生Dao
public class DoctorDao extends BaseDao{
    //获取所有医生信息
    public List getAllDoctor() throws Exception{
        //创建医生列表
        List doctorList = new ArrayList();
        //sql语句
        String sql= " select dd_id,doctor.a_id,dd_name,dd_sex,dd_age,dd_type,dd_price,dd_type1" +
                " from doctor inner join administrative on doctor.a_id = administrative.a_id";
        //获取数据库连接
        Connection connection = getConnection();
        //创建SQL执行对象
        Statement statement = connection.createStatement();
        //执行SQL语句获取结果集
        ResultSet resultSet = statement.executeQuery(sql);
        //遍历结果集
        while (resultSet.next()){
            //获取医生信息
            String dd_id = resultSet.getString("dd_id");
            String a_id = resultSet.getString("a_id");
            String dd_name = resultSet.getString("dd_name");
            String dd_sex = resultSet.getString("dd_sex");
            int dd_age = Integer.parseInt(String.valueOf(resultSet.getInt("dd_age")));
            String dd_type = resultSet.getString("dd_type");
            String dd_price = resultSet.getString("dd_price");
            String dd_type1 = resultSet.getString("dd_type1");
            //创建医生对象
            Doctor doctor= new Doctor(dd_id,a_id,dd_name,dd_sex,dd_age,dd_type,dd_price,dd_type1);
            //将医生对象添加到医生列表
            doctorList.add(doctor);

        }
        //返回医生列表
        return doctorList;

    }

    //添加医生
    public boolean addDoctor(Doctor doctor) throws Exception{
        //SQL语句
        String sql = "insert into doctor(dd_id,a_id,dd_name,dd_sex,dd_age,dd_type,dd_price,dd_type1)" +
                " VALUES(?,?,?,?,?,?,?,?) ";
        //获取数据库连接
        Connection connection = getConnection();
        //创建预编译SQL执行对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置医生信息
        preparedStatement .setString(1,doctor.getD_id());
        preparedStatement .setString(2,doctor.getA_id());
        preparedStatement .setString(3,doctor.getD_name());
        preparedStatement .setString(4,doctor.getD_sex());
        preparedStatement .setInt(5,doctor.getD_age());
        preparedStatement .setString(6,doctor.getD_type());
        preparedStatement .setString(7,doctor.getD_price());
        preparedStatement .setString(8,doctor.getD_type1());
        //执行SQL语句并获取影响行数
        int num = preparedStatement.executeUpdate();
        //根据影响行数判断是否添加成功
        if (num==1)
        {
            return true;
        }else {
            return false;
        }

    }

    //删除医生
    public String deleteDoctor(Doctor doctor) throws Exception{
        //定义删除结果
        String result=null;
        //获取数据库连接
        Connection connection = getConnection();
        //SQL语句
        String sql = "delete from doctor where dd_id=?";
        //创建预编译SQL执行对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置医生ID
        preparedStatement .setString(1,doctor.getD_id());
        //执行删除SQL操作并获取影响行数
        int num = preparedStatement.executeUpdate();
        //根据影响行数判断删除结果
        if(num==1){
            //删除成功
            result = "删除成功";
        }else {
            //删除失败
            result = "删除失败";
        }
        //返回删除结果
        return result;
    }

    //修改医生
    public boolean modifyDoctor(Doctor doctor){
        int i =0;
        try{
            //获取数据库连接
            Connection connection =getConnection();
            //SQL语句
            String updatesql = "update doctor set a_id=?,"
                    +"dd_name=?,"
                    +"dd_sex=?,"
                    +"dd_age=?,"
                    +"dd_type=?,"
                    +"dd_price=?,"
                    +"dd_type1=?"
                    +" where dd_id=? ";
            //创建预编译SQL执行对象
            PreparedStatement preparedStatement = connection.prepareStatement(updatesql);
            //设置医生信息
            preparedStatement.setString(1,doctor.getA_id());
            preparedStatement.setString(2,doctor.getD_name());
            preparedStatement.setString(3,doctor.getD_sex());
            preparedStatement.setInt(4,doctor.getD_age());
            preparedStatement.setString(5,doctor.getD_type());
            preparedStatement.setString(6,doctor.getD_price());
            preparedStatement.setString(7,doctor.getD_type1());
            preparedStatement.setString(8,doctor.getD_id());
            //执行SQL语句并获取影响行数
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //根据影响行数判断修改结果
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

}
