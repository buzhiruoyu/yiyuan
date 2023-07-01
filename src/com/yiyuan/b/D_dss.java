/**
 * D_dss类用于定义药品信息的属性和方法。
 */
package com.yiyuan.b;

public class D_dss {
    /**
     * 药品名称
     */
    String 药品名称;
    /**
     * 药品类别
     */
    String 药品类别;
    /**
     * 库存
     */
    String 库存;
    /**
     * 货架编号
     */
    String 货架编号;
    /**
     * 单位
     */
    String 单位;
    /**
     * 规格
     */
    String 规格;
    /**
     * 单价
     */
    String 单价;
    /**
     * 用法
     */
    String 用法;

    /**
     * D_dss类的构造方法，用于实例化对象并初始化药品信息的属性
     * @param 药品名称
     * @param 药品类别
     * @param 库存
     * @param 货架编号
     * @param 单位
     * @param 规格
     * @param 单价
     * @param 用法
     */
    public D_dss(String 药品名称, String 药品类别, String 库存, String 货架编号, String 单位, String 规格, String 单价, String 用法) {
        this.药品名称 = 药品名称;
        this.药品类别 = 药品类别;
        this.库存 = 库存;
        this.货架编号 = 货架编号;
        this.单位 = 单位;
        this.规格 = 规格;
        this.单价 = 单价;
        this.用法 = 用法;
    }

    /**
     * 获取药品名称
     * @return 药品名称
     */
    public String get药品名称() {
        return 药品名称;
    }

    /**
     * 设置药品名称
     * @param 药品名称
     */
    public void set药品名称(String 药品名称) {
        this.药品名称 = 药品名称;
    }

    /**
     * 获取药品类别
     * @return 药品类别
     */
    public String get药品类别() {
        return 药品类别;
    }

    /**
     * 设置药品类别
     * @param 药品类别
     */
    public void set药品类别(String 药品类别) {
        this.药品类别 = 药品类别;
    }

    /**
     * 获取库存
     * @return 库存
     */
    public String get库存() {
        return 库存;
    }

    /**
     * 设置库存
     * @param 库存
     */
    public void set库存(String 库存) {
        this.库存 = 库存;
    }

    /**
     * 获取货架编号
     * @return 货架编号
     */
    public String get货架编号() {
        return 货架编号;
    }

    /**
     * 设置货架编号
     * @param 货架编号
     */
    public void set货架编号(String 货架编号) {
        this.货架编号 = 货架编号;
    }

    /**
     * 获取单位
     * @return 单位
     */
    public String get单位() {
        return 单位;
    }

    /**
     * 设置单位
     * @param 单位
     */
    public void set单位(String 单位) {
        this.单位 = 单位;
    }

    /**
     * 获取规格
     * @return 规格
     */
    public String get规格() {
        return 规格;
    }

    /**
     * 设置规格
     * @param 规格
     */
    public void set规格(String 规格) {
        this.规格 = 规格;
    }

    /**
     * 获取单价
     * @return 单价
     */
    public String get单价() {
        return 单价;
    }

    /**
     * 设置单价
     * @param 单价
     */
    public void set单价(String 单价) {
        this.单价 = 单价;
    }

    /**
     * 获取用法
     * @return 用法
     */
    public String get用法() {
        return 用法;
    }

    /**
     * 设置用法
     * @param 用法
     */
    public void set用法(String 用法) {
        this.用法 = 用法;
    }
}
