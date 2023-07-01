package com.yiyuan.b;

// 医生类
public class A_administrative {
    // 医生编号
    String 医生编号;
    // 医生姓名
    String 医生姓名;
    // 性别
    String 性别;
    // 年龄
    String 年龄;
    // 职称
    String 职称;
    // 类型
    String 类型;
    // 科室
    String 科室;

    // 构造方法
    public A_administrative(String 医生编号, String 医生姓名, String 性别, String 年龄, String 职称, String 类型, String 科室) {
        this.医生编号 = 医生编号;
        this.医生姓名 = 医生姓名;
        this.性别 = 性别;
        this.年龄 = 年龄;
        this.职称 = 职称;
        this.类型 = 类型;
        this.科室 = 科室;
    }

    // 医生编号的getter方法
    public String get医生编号() {
        return 医生编号;
    }

    // 医生编号的setter方法
    public void set医生编号(String 医生编号) {
        this.医生编号 = 医生编号;
    }

    // 医生姓名的getter方法
    public String get医生姓名() {
        return 医生姓名;
    }

    // 医生姓名的setter方法
    public void set医生姓名(String 医生姓名) {
        this.医生姓名 = 医生姓名;
    }

    // 性别的getter方法
    public String get性别() {
        return 性别;
    }

    // 性别的setter方法
    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    // 年龄的getter方法
    public String get年龄() {
        return 年龄;
    }

    // 年龄的setter方法
    public void set年龄(String 年龄) {
        this.年龄 = 年龄;
    }

    // 职称的getter方法
    public String get职称() {
        return 职称;
    }

    // 职称的setter方法
    public void set职称(String 职称) {
        this.职称 = 职称;
    }

    // 类型的getter方法
    public String get类型() {
        return 类型;
    }

    // 类型的setter方法
    public void set类型(String 类型) {
        this.类型 = 类型;
    }

    // 科室的getter方法
    public String get科室() {
        return 科室;
    }

    // 科室的setter方法
    public void set科室(String 科室) {
        this.科室 = 科室;
    }
}
