//声明一个包名为com.yiyuan.a的类BaseDao
package com.yiyuan.a;

//导入java.sql包下的Connection和DriverManager类
import java.sql.Connection;
import java.sql.DriverManager;

//定义BaseDao类
public class BaseDao {
    private Connection connection; //声明连接对象

    //定义getConnection()方法，返回一个Connection连接对象，抛出异常
    public Connection getConnection() throws Exception {
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名MyData
        String url = "jdbc:mysql://localhost:3306/yiyuan";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "12345";
        //加载驱动程序
        Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库
        connection = DriverManager.getConnection(url, user, password);
        //返回Connection连接对象
        return connection;
    }

    //定义Main方法
    public static void main(String[] args) throws Exception {
        BaseDao baseDao = new BaseDao(); //创建BaseDao对象
        Connection connection1 = baseDao.getConnection(); //获取连接对象
        System.out.println("ok"); //输出"ok"表明连接成功
    }

}
