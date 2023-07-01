// 声明一个名为com.yiyuan.b的包
package com.yiyuan.b;

// 定义一个名为Admin的类
public class Admin {

    // 声明Admin类的成员变量a_id，类型为String
    String a_id;

    // 声明Admin类的成员变量a_name，类型为String
    String a_name;

    // 声明一个带有两个参数（a_id和a_name）的构造函数
    public Admin(String a_id, String a_name) {
        // 使用this关键字引用当前类中的成员变量并分别赋值
        this.a_id = a_id;
        this.a_name = a_name;
    }

    // 声明一个不带参数的构造函数
    public Admin() { }

    // 声明一个返回a_id的方法
    public String getA_id() {
        return a_id;
    }

    // 声明一个设置a_id的方法
    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    // 声明一个返回a_name的方法
    public String getA_name() {
        return a_name;
    }

    // 声明一个设置a_name的方法
    public void setA_name(String a_name) {
        this.a_name = a_name;
    }
}
