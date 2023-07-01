//导包
package com.yiyuan.a;
import com.yiyuan.b.Dss;
import com.yiyuan.b.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//继承自BaseDao
public class DssDao extends BaseDao{

    //获取所有药品信息
    public List getAllDSS() throws Exception{
        List dssList = new ArrayList();
        String sql= " select D_id,D_name,D_type,D_number,D_id_id,D_unit,D_spec,D_price " +
                " from dss ";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String D_id = resultSet.getString("D_id");
            String D_name = resultSet.getString("D_name");
            String D_type = resultSet.getString("D_type");
            int D_number = resultSet.getInt("D_number");
            String D_id_id = resultSet.getString("D_id_id");
            String D_unit = resultSet.getString("D_unit");
            String D_spec = resultSet.getString("D_spec");
            String D_price = resultSet.getString("D_price");
            //创建对象
            Dss dss= new Dss(D_id,D_name,D_type,D_number,D_id_id,D_unit,D_spec,D_price);
            //将对象加入List
            dssList.add(dss);

        }
        //返回List
        return dssList;

    }

    //添加药品信息
    public boolean addDss(Dss dss) throws Exception{
        String sql = "insert into dss(D_id,D_name,D_type,D_number,D_id_id,D_unit,D_spec,D_price)" +
                " VALUES(?,?,?,?,?,?,?,?) ";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement .setString(1,dss.getD_id());
        preparedStatement .setString(2,dss.getD_name());
        preparedStatement .setString(3,dss.getD_type());
        preparedStatement .setInt(4,dss.getD_number());
        preparedStatement .setString(5,dss.getD_id_id());
        preparedStatement .setString(6,dss.getD_unit());
        preparedStatement .setString(7,dss.getD_spec());
        preparedStatement .setString(8,dss.getD_price());
        int num = preparedStatement.executeUpdate();//执行sql语句
        if (num==1)
        {
            return true;
        }else {
            return false;
        }

    }

    //删除药品信息
    public String deleteDss(Dss dss) throws Exception{
        String result=null;
        Connection connection = getConnection();
        String sql = "delete from dss where D_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement .setString(1,dss.getD_id());
        int num = preparedStatement.executeUpdate();//执行删除sql操作
        if(num==1){
            //删除成功
            result = "删除成功";
        }else {
            //删除失败
            result = "删除失败";
        }
        return result;
    }

    //修改药品信息
    public boolean modifyDss(Dss dss){
        int i =0;
        try{
            Connection connection =getConnection();
            String updatesql = "update dss set D_name=?,"
                    +"D_type=?,"
                    +"D_number=?"
                    +"D_id_id=?"
                    +"D_unit=?"
                    +"D_spec=?"
                    +"D_price=?"
                    +" where D_id=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(updatesql);
            preparedStatement.setString(1,dss.getD_name());
            preparedStatement.setString(2,dss.getD_type());
            preparedStatement.setInt(3,dss.getD_number());
            preparedStatement.setString(4,dss.getD_id_id());
            preparedStatement.setString(5,dss.getD_unit());
            preparedStatement.setString(6,dss.getD_spec());
            preparedStatement.setString(7,dss.getD_price());
            preparedStatement.setString(8,dss.getD_id());
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

}
