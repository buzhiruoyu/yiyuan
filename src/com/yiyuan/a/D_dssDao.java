// 声明com.yiyuan.a包
package com.yiyuan.a;

// 引入com.yiyuan.b.A_administrative和com.yiyuan.b.D_dss包
import com.yiyuan.b.A_administrative;
import com.yiyuan.b.D_dss;

// 引入所需的java.sql包
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// D_dssDao类继承BaseDao类
public class D_dssDao extends BaseDao {

    // 获取所有D_dss记录，并将其封装在List中返回
    public List getAllD_dss() throws Exception {
        List d_dssList = new ArrayList(); // 创建一个ArrayList用于存储D_dss记录
        String sql = " select 药品名称,药品类别,库存,货架编号,单位,规格,单价,用法" + // 查询语句
                " from d_dss ";
        Connection connection = getConnection(); // 获取连接对象
        Statement statement = connection.createStatement(); // 获取Statement对象
        ResultSet resultSet = statement.executeQuery(sql); // 执行查询，返回ResultSet结果集
        while (resultSet.next()) { // 循环遍历结果集
            String 药品名称 = resultSet.getString("药品名称");
            String 药品类别 = resultSet.getString("药品类别");
            String 库存 = resultSet.getString("库存");
            String 货架编号 = resultSet.getString("货架编号");
            String 单位 = resultSet.getString("单位");
            String 规格 = resultSet.getString("规格");
            String 单价 = resultSet.getString("单价");
            String 用法 = resultSet.getString("用法");
            // 使用D_dss类的构造方法，创建一个新的D_dss对象，并将其添加到d_dssList中
            D_dss d_dss = new D_dss(药品名称, 药品类别, 库存, 货架编号, 单位, 规格, 单价, 用法);
            d_dssList.add(d_dss);
        }
        return d_dssList; // 返回d_dssList
    }
}
