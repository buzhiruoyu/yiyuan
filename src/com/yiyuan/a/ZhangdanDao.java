//引入所需要的包
package com.yiyuan.a;
import com.yiyuan.b.D_dss;
import com.yiyuan.b.Zhangdan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//创建ZhangdanDao类并继承BaseDao类
public class ZhangdanDao extends BaseDao {

    //定义获取所有账单列表的方法
    public List getAllZhangdan() throws Exception {

        //创建账单列表
        List zhangdanList = new ArrayList();

        //定义SQL查询语句
        String sql = "select 就诊号,患者姓名,药品名称,数量,单价,金额总计,收银员编号 from jiezhangdan4";

        //获取数据库连接对象
        Connection connection = getConnection();

        //创建Statement对象
        Statement statement = connection.createStatement();

        //执行SQL查询语句并返回查询结果集
        ResultSet resultSet = statement.executeQuery(sql);

        //循环遍历查询结果集
        while (resultSet.next()) {
            //获取查询结果集中的各个字段值
            String 就诊号 = resultSet.getString("就诊号");
            String 患者姓名 = resultSet.getString("患者姓名");
            String 药品名称 = resultSet.getString("药品名称");
            String 数量 = resultSet.getString("数量");
            String 单价 = resultSet.getString("单价");
            String 金额总计 = resultSet.getString("金额总计");
            String 收银员编号 = resultSet.getString("收银员编号");

            //创建账单对象并添加到账单列表中
            Zhangdan zhangdan = new Zhangdan(就诊号, 患者姓名, 药品名称, 数量, 单价, 金额总计, 收银员编号);
            zhangdanList.add(zhangdan);
        }

        //返回账单列表
        return zhangdanList;
    }
}
