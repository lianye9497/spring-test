package com.study.px.spring.springtest.vo;




import com.alibaba.fastjson.JSON;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Son extends Father implements Cloneable{

    public String name = "son";

    public String sex = "man";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse("2018-08-27 12:33:44");
            if (date1.after(date)){
                System.out.println(1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BigDecimal bigDecimal = new BigDecimal(1);
        System.out.println(bigDecimal.toString());

        Integer s11 = 1;
        System.out.println(s11.equals("1"));

        Map aa = new HashMap<>();
        aa.put("1", 1);
        Map<String,String> bb = new HashMap<>();
        bb.putAll(aa);
        bb.put("2", "1");


        double i = Math.ceil((double) 0 / 2);

        List<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();

//        if (CollectionUtils.isNotEmpty(map)){
//            System.out.println(1);
//        }
        list = null;

        if (CollectionUtils.isEmpty(list)){
            System.out.println(1);
        }

        String s1 = new String("aaa");
        String s2 = "aaa";
        System.out.println(s1 == s2);    // false

        s2 = "bbb";
        s1 = new String("bbb").intern();
        System.out.println(s1 == s2);    // true

        s1 = "ccc";
        s2 = "ccc";
        System.out.println(s1 == s2);    // true

        s1 = new String("ddd").intern();
        s2 = new String("ddd").intern();
        System.out.println(s1 == s2);    // true

        s1 = "ab" + "cd";
        s2 = "abcd";
        System.out.println(s1 == s2);    // true

        String temp = "hh";
        s1 = "a" + temp;
// 如果调用s1.intern 则最终返回true
        s2 = "ahh";
        System.out.println(s1 == s2);    // false

        temp = "hh".intern();
        s1 = "a" + temp;
        s2 = "ahh";
        System.out.println(s1 == s2);    // false

        temp = "hh".intern();
        s1 = ("a" + temp).intern();
        s2 = "ahh";
        System.out.println(s1 == s2);    // true

        s1 = new String("1");    // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
        s1.intern();            // 常量池中的已经存在
        s2 = "1";
        System.out.println(s1 == s2);    // false

        String s3 = new String("1") + new String("1");    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
        s3.intern();    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
        String s4 = "11";    // jdk1.7之后，常量池中的地址其实就是s3的地址
        System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7之后true

        s3 = new String("2") + new String("2");
        s4 = "22";        // 常量池中不存在22，所以会新开辟一个存储22对象的常量池地址
        s3.intern();    // 常量池22的地址和s3的地址不同
        System.out.println(s3 == s4); // false

// 对于什么时候会在常量池存储字符串对象，我想我们可以基本得出结论: 1. 显示调用String的intern方法的时候; 2. 直接声明字符串字面常量的时候，例如: String a = "aaa";
// 3. 字符串直接常量相加的时候，例如: String c = "aa" + "bb";  其中的aa/bb只要有任何一个不是字符串字面常量形式，都不会在常量池生成"aabb". 且此时jvm做了优化，不//   会同时生成"aa"和"bb"在字符串常量池中

//
//        Father son = new Son();
//        Son son1 = new Son();
//        System.out.println("son===" + son.name + ",getname==" + son.getName()
//        + "，age=="+son.age + ", getAge==" + son.getAge()
//                + "，sex== Father son无法访问sex字段,但是能访问子类的方法" + ", getAge==" + son.getAge());
//        System.out.println("son1===" + son1.name + ",getname==" + son1.getName()
//                + "，age=="+son1.age+ ", getAge==" + son1.getAge()
//                + "，sex=="+son1.sex+ ", getAge==" + son1.getSex());

    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
