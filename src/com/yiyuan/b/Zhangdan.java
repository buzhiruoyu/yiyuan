package com.yiyuan.b;

public class Zhangdan {
    // 就诊号
    String 就诊号;
    // 患者姓名
    String 患者姓名;
    // 药品名称
    String 药品名称;
    // 数量
    String 数量;
    // 单价
    String 单价;
    // 金额总计
    String 金额总计;
    // 收银员编号
    String 收银员编号;

    // 构造方法
    public Zhangdan(String 就诊号, String 患者姓名, String 药品名称, String 数量, String 单价, String 金额总计, String 收银员编号) {
        this.就诊号 = 就诊号;
        this.患者姓名 = 患者姓名;
        this.药品名称 = 药品名称;
        this.数量 = 数量;
        this.单价 = 单价;
        this.金额总计 = 金额总计;
        this.收银员编号 = 收银员编号;
    }

    // Getter 和 Setter 方法
    public String get就诊号() {
        return 就诊号;
    }

    public void set就诊号(String 就诊号) {
        this.就诊号 = 就诊号;
    }

    public String get患者姓名() {
        return 患者姓名;
    }

    public void set患者姓名(String 患者姓名) {
        this.患者姓名 = 患者姓名;
    }

    public String get药品名称() {
        return 药品名称;
    }

    public void set药品名称(String 药品名称) {
        this.药品名称 = 药品名称;
    }

    public String get数量() {
        return 数量;
    }

    public void set数量(String 数量) {
        this.数量 = 数量;
    }

    public String get单价() {
        return 单价;
    }

    public void set单价(String 单价) {
        this.单价 = 单价;
    }

    public String get金额总计() {
        return 金额总计;
    }

    public void set金额总计(String 金额总计) {
        this.金额总计 = 金额总计;
    }

    public String get收银员编号() {
        return 收银员编号;
    }

    public void set收银员编号(String 收银员编号) {
        this.收银员编号 = 收银员编号;
    }
}
