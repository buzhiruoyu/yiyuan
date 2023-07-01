package com.yiyuan.c;

import com.yiyuan.add.*;
import com.yiyuan.img.ImageEg;
import com.yiyuan.list.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFram extends JFrame {
    private JMenuBar menuBar;//菜单栏
    private JMenu patientMenu;//患者管理
    private JMenuItem addPatientMenuItem;//添加患者菜单项
    private JMenuItem managePatientMenuItem;//添加患者管理菜单项

    private JMenu doctorMenu;//医生管理
    private JMenuItem addDoctorMenuItem;//添加医生菜单项
    private JMenuItem manageDoctorMenuItem;//添加管理菜单项

    private JMenu administrativeMenu;//科室管理
    private JMenuItem addAdministrativeMenuItem;//添加科室菜单项
    private JMenuItem manageAdministrativeMenuItem;//添加科室管理菜单项

    private JMenu dssMenu;//药品管理
    private JMenuItem addDssMenuItem;//添加药品菜单项
    private JMenuItem manageDssMenuItem;//添加药品管理菜单项

    private JMenu mrescriptionMenu;//处方管理
    private JMenuItem addMrescriptionMenuItem;//添加处方菜单项
    private JMenuItem manageMrescriptionMenuItem;//添加处方管理菜单项

    private JMenu registrationMenu;//挂号管理
    private JMenuItem addRegistrationMenuItem;//添加处方菜单项
    private JMenuItem manageRegistrationMenuItem;//添加处方管理菜单项

    private JMenu shitunMenu;//视图查看
    private JMenuItem a_administrativeMenuItem;//医生菜单项
    private JMenuItem d_dssMenuItem;//药品菜单项
    private JMenuItem zhangdanMenuItem;//账单菜单项

    public MainFram(String role,String name){
        this.setTitle("欢迎"+role+name);//设置窗口标题
        this.setSize(1080,640);//设置窗口大小
        this.setVisible(true);//设置窗口可见
        this.setLocation(250,110);//设置窗口位置

        menuBar=new JMenuBar();//
        this.setJMenuBar(menuBar);

        patientMenu=new JMenu("患者管理");//创建患者管理菜单栏
        menuBar.add(patientMenu);//把患者菜单栏放入菜单栏
        addPatientMenuItem=new JMenuItem("添加患者");
        patientMenu.add(addPatientMenuItem);
        managePatientMenuItem=new JMenuItem("管理患者");
        patientMenu.add(managePatientMenuItem);

        doctorMenu=new JMenu("医生管理");//创建医生管理菜单栏
        menuBar.add(doctorMenu);//把医生菜单栏放入菜单栏
        addDoctorMenuItem=new JMenuItem("添加医生");
        doctorMenu.add(addDoctorMenuItem);
        manageDoctorMenuItem=new JMenuItem("管理医生");
        doctorMenu.add(manageDoctorMenuItem);

        administrativeMenu=new JMenu("科室管理");//创建科室管理菜单栏
        menuBar.add(administrativeMenu);//把科室菜单栏放入菜单栏
        addAdministrativeMenuItem=new JMenuItem("添加科室");
        administrativeMenu.add(addAdministrativeMenuItem);
        manageAdministrativeMenuItem=new JMenuItem("管理科室");
        administrativeMenu.add(manageAdministrativeMenuItem);

        dssMenu=new JMenu("药品管理");//创建药品管理菜单栏
        menuBar.add(dssMenu);//把药品菜单栏放入菜单栏
        addDssMenuItem=new JMenuItem("添加药品");
        dssMenu.add(addDssMenuItem);
        manageDssMenuItem=new JMenuItem("管理药品");
        dssMenu.add(manageDssMenuItem);

        mrescriptionMenu=new JMenu("处方管理");//创建处方管理菜单栏
        menuBar.add(mrescriptionMenu);//把处方菜单栏放入菜单栏
        addMrescriptionMenuItem=new JMenuItem("添加处方");
        mrescriptionMenu.add(addMrescriptionMenuItem);
        manageMrescriptionMenuItem=new JMenuItem("管理处方");
        mrescriptionMenu.add(manageMrescriptionMenuItem);

        registrationMenu=new JMenu("挂号管理");//创建挂号管理菜单栏
        menuBar.add(registrationMenu);//把挂号菜单栏放入菜单栏
        addRegistrationMenuItem=new JMenuItem("添加挂号");
        registrationMenu.add(addRegistrationMenuItem);
        manageRegistrationMenuItem=new JMenuItem("管理挂号");
        registrationMenu.add(manageRegistrationMenuItem);

        shitunMenu=new JMenu("查看视图");//创建挂号管理菜单栏
        menuBar.add(shitunMenu);//把挂号菜单栏放入菜单栏
        a_administrativeMenuItem=new JMenuItem("医生信息");
        shitunMenu.add(a_administrativeMenuItem);
        d_dssMenuItem=new JMenuItem("药品信息");
        shitunMenu.add(d_dssMenuItem);
        zhangdanMenuItem = new JMenuItem("账单信息");
        shitunMenu.add(zhangdanMenuItem);

        addPatientMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PatientAdd patientAdd=new PatientAdd();

            }
        });

        addDoctorMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DoctorAdd doctorAdd=new DoctorAdd();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        addAdministrativeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    AdminAdd administrativeAdd=new AdminAdd();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        addDssMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DssAdd dssAdd=new DssAdd();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        addMrescriptionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    MrescriptionAdd mrescriptionAdd=new MrescriptionAdd();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        addRegistrationMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    RegistrationAdd registrationAdd=new RegistrationAdd();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        managePatientMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try{
                    PatientList patientList=new PatientList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }

            }
        });

        manageDoctorMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DoctorList doctorList=new DoctorList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        manageDssMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DssList dssList=new DssList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        manageMrescriptionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    MrescriptionList mrescriptionList=new MrescriptionList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        manageRegistrationMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    RegistrationList registrationList=new RegistrationList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        manageAdministrativeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    AdminList administrativeList=new AdminList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        a_administrativeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    A_administrativeList administrativeList=new A_administrativeList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        d_dssMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    D_dssList d_dssList=new D_dssList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        zhangdanMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ZhangdanList zhangdanList=new ZhangdanList();
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

//        manageAdministrativeMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try{
//                    AdminList administrativeList=new AdminList();
//                } catch (Exception ex){
//                    throw new RuntimeException(ex);
//                }
//            }
//        });
        ImageEg imageEg = new ImageEg();
        this.add(imageEg);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setBounds(311,124,920,600);

    }


    public static void main(String[] args){
        new MainFram("管理员","admin");
    }
}
