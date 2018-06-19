package com.study.px.spring.springtest.vo;

public class Son extends Father{

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

    public static void main(String[] args) {
        Father son = new Son();
        Son son1 = new Son();
        System.out.println("son===" + son.name + ",getname==" + son.getName()
        + "，age=="+son.age + ", getAge==" + son.getAge()
                + "，sex== Father son无法访问sex字段,但是能访问子类的方法" + ", getAge==" + son.getAge());
        System.out.println("son1===" + son1.name + ",getname==" + son1.getName()
                + "，age=="+son1.age+ ", getAge==" + son1.getAge()
                + "，sex=="+son1.sex+ ", getAge==" + son1.getSex());

    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
