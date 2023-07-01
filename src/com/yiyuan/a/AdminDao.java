package com.yiyuan.a;

import com.yiyuan.b.Admin;
import com.yiyuan.b.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends BaseDao{

    //查询所有管理员信息
    public List getAllAdmin() throws Exception{
        List adminList = new ArrayList();
        String sql= " select a_id,a_name" + " from administrative ";
        Connection connection = getConnection(); //获取数据库连接
        Statement statement = connection.createStatement(); //创建Statement对象，用来执行SQL语句
        ResultSet resultSet = statement.executeQuery(sql); //执行SQL语句，返回查询结果的结果集
        while (resultSet.next()){
            String a_id = resultSet.getString("a_id"); //获取管理员ID
            String a_name = resultSet.getString("a_name"); //获取管理员姓名
            Admin admin= new Admin(a_id,a_name); //创建Admin对象
            adminList.add(admin); //将Admin对象添加到List中
        }
        return adminList; //返回管理员信息的List

    }

    //添加管理员信息
    public boolean addAdmin(Admin admin) throws Exception{
        String sql = "insert into administrative(a_id,a_name)" + " VALUES(?,?) ";
        Connection connection = getConnection(); //获取数据库连接
        PreparedStatement preparedStatement = connection.prepareStatement(sql); //创建PreparedStatement对象，用来执行SQL语句
        preparedStatement .setString(1,admin.getA_id()); //设置占位符的值
        preparedStatement .setString(2,admin.getA_name()); //设置占位符的值
        int num = preparedStatement.executeUpdate(); //执行SQL语句，返回受影响的行数
        if (num==1){
            return true;
        }else {
            return false;
        }
    }

    //删除管理员信息
    public String deleteAdmin(Admin admin) throws Exception{
        String result=null;
        Connection connection = getConnection(); //获取数据库连接
        String sql = "delete from administrative where a_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql); //创建PreparedStatement对象，用来执行SQL语句
        preparedStatement .setString(1,admin.getA_id()); //设置占位符的值
        int num = preparedStatement.executeUpdate(); //执行删除SQL语句操作，返回受影响的行数
        if(num==1){
            result = "删除成功"; //删除成功
        }else {
            result = "删除失败"; //删除失败
        }
        return result; //返回删除结果
    }

    //修改管理员信息
    public boolean modifyAdmin(Admin admin){
        int i =0;
        try{
            Connection connection =getConnection(); //获取数据库连接
            String updatesql = "update administrative set a_name=?" + " where a_id=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(updatesql); //创建PreparedStatement对象，用来执行SQL语句
            preparedStatement.setString(1,admin.getA_name()); //设置占位符的值
            preparedStatement.setString(2,admin.getA_id()); //设置占位符的值
            i = preparedStatement.executeUpdate(); //执行修改SQL语句操作，返回受影响的行数
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1){ //修改成功
            return true;
        }else { //修改失败
            return false;
        }
    }

}

