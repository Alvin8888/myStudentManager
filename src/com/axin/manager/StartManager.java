package com.axin.manager;

import com.axin.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StartManager {

    public static void main(String[] args) {
        System.out.println("张三，王麻子");
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> listObj = new ArrayList<>();
        // 给无线循环指定一个名字结束循环
        lo:while (true){
            System.out.println("------------欢迎来到学生管理系统------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            int num = sc.nextInt();
                switch (num){
                    case 1:
                        // System.out.println("添加");
                        addStudent(listObj);
                        break;
                    case 2:
                        // System.out.println("删除");
                        deleteStudent(listObj);

                        break;
                    case 3:
                        // System.out.println("修改");

                         updateStudent(listObj);
                        break;
                    case 4:
                        // System.out.println("查看");
                        getStudent(listObj);
                        break;
                    case 5:
                        System.out.println("谢谢您的使用");
                        break lo;
                    default:
                        System.out.println("你输入有毒，已退出感谢你的使用..");
                        break lo;
                }


        }

    }

    //删除指定姓名集合中对象
    private static void deleteStudent(ArrayList<Student> listObj) {
        System.out.println("请输入你要删除的数据Id： ");
        Scanner sc =  new Scanner(System.in);
        String sid = sc.next();
        int index =  getIndex(listObj,sid);


        if(index == -1){
            System.out.println("你输入的名字有误，未找到你要删除的数据...");
        }else {
            listObj.remove(index);
            System.out.println("删除成功");
            // num 等于零表示未找到需要删除的数据
        }
    }


    
    
    //获取需要删除或者修改的索引
    private static int getIndex(ArrayList<Student> listObj,String sid) {


        int index = -1;

        for (int i = 0; i < listObj.size(); i++) {
            Student obj = listObj.get(i);
            String id = obj.getSid();
            if(id.equals(sid)){
                index = i;
                break;
            }
        }


        return index;

    }

    //修改学生录入集合
     private static void updateStudent(ArrayList<Student> listObj) {
        System.out.println("请输入你要更改学生的Id： ");
        Scanner sc = new Scanner(System.in);
        String sid = sc.next();
        int index =  getIndex(listObj,sid);

        //未查找到数据给提示
        if (index  ==  -1 ){
            System.out.println("未查到数据库中您需要改的数据..");
        }else {
            System.out.println("请输入你要修改的姓名： ");
            String updateName = sc.next();

            System.out.println("请输入你要修改的年龄： ");
            int updateAge = sc.nextInt();

            System.out.println("请输入你要修改的出生日期： ");
            String updateBirthday = sc.next();

            Student getStu = listObj.get(index);
            Student stu = new Student(getStu.getSid(),updateName,updateAge,updateBirthday);
            listObj.set(index,stu);

            System.out.println("修改成功");
        }

    }

    //查看学生录入

    private static void getStudent(ArrayList<Student> listObj) {
        if(listObj.size() == 0 ) {
            System.out.println("数据库中无数据，请新增学生数据");
            return;
        }
        System.out.println("学号    姓名    年龄    生日");
        //循环查看集合数据
        for (Student obj : listObj) {
            System.out.println(obj.getSid() + "    " + obj.getName() + "    " + obj.getAge() + "    " + obj.getBirthday());
        }
    }
    // 添加学生录入
    private static void addStudent( ArrayList<Student> listObj) {
        Scanner sc = new Scanner(System.in);
        //判断是否有重复的id学号
        String sid;
        System.out.println("请输入学号： ");
          while (true){
               // 1. 录入的提示信息
               sid = sc.next();
               int index = getIndex(listObj,sid);
               if(index == -1){
                   break;
               }else {
                   System.out.println("学号已被占用请重新输入学号： ");
               }
           }

       System.out.println("请输入姓名：");
       String name = sc.next();
       System.out.println("请输入年龄： ");
       int age = sc.nextInt();
       System.out.println("请输入生日： ");
       String birthday = sc.next();



       // 2. 将键盘录入的信息封装为学生对象
       Student stu = new Student(sid,name,age,birthday);

       // 3. 将封装好的学生对象，添加到集合容器当中
       listObj.add(stu);

       // 4. 给添加成功的提示信息
       System.out.println("恭喜你，学生添加成功");
    }

}
