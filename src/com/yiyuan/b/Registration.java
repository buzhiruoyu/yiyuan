// 定义package名称为com.yiyuan.b
package com.yiyuan.b;

// 定义Registration类
public class Registration {
    // 定义r_id变量，类型为String，表示注册ID
    String r_id;
    // 定义p_id变量，类型为String，表示产品ID
    String p_id;
    // 定义dd_id变量，类型为String，表示订单ID
    String dd_id;
    // 定义r_data变量，类型为String，表示注册日期
    String r_data;
    // 定义r_price_id变量，类型为String，表示价格ID
    String r_price_id;

    // 构造函数，包含r_id, p_id, dd_id, r_data, r_price_id变量
    public Registration(String r_id, String p_id, String dd_id, String r_data, String r_price_id) {
        // 给r_id赋值为输入的r_id变量值
        this.r_id = r_id;
        // 给p_id赋值为输入的p_id变量值
        this.p_id = p_id;
        // 给dd_id赋值为输入的dd_id变量值
        this.dd_id = dd_id;
        // 给r_data赋值为输入的r_data变量值
        this.r_data = r_data;
        // 给r_price_id赋值为输入的r_price_id变量值
        this.r_price_id = r_price_id;
    }

    // 空的构造函数
    public Registration() {

    }

    // 获取r_id变量的值
    public String getR_id() {
        return r_id;
    }

    // 设置r_id变量的值
    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    // 获取p_id变量的值
    public String getP_id() {
        return p_id;
    }

    // 设置p_id变量的值
    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    // 获取dd_id变量的值
    public String getDd_id() {
        return dd_id;
    }

    // 设置dd_id变量的值
    public void setDd_id(String dd_id) {
        this.dd_id = dd_id;
    }

    // 获取r_data变量的值
    public String getR_data() {
        return r_data;
    }

    // 设置r_data变量的值
    public void setR_data(String r_data) {
        this.r_data = r_data;
    }

    // 获取r_price_id变量的值
    public String getR_price_id() {
        return r_price_id;
    }

    // 设置r_price_id变量的值
    public void setR_price_id(String r_price_id) {
        this.r_price_id = r_price_id;
    }
}
