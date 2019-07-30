package com.study.px.spring.springtest.vo;

import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-02-12 17:41
 **/
public class CloneTestVO implements Cloneable{

    private String name;

    private Son son;

    public CloneTestVO() {}

    public CloneTestVO(String name, Son son) {
        this.name = name;
        this.son = son;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "CloneTestVO{" +
                "name='" + name + '\'' +
                ", son=" + son +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Son son = new Son();
        son.setName("1号son");
        son.setSex("1");
        CloneTestVO cloneTestVO = new CloneTestVO("1号", son);
        Object clone = cloneTestVO.clone();
        System.out.println(cloneTestVO.toString());
        System.out.println(clone.toString());
        System.out.println("------------准备修改数据----------");
        son.setSex("2号");
        cloneTestVO.setName("2号");
        System.out.println(cloneTestVO.toString());
        System.out.println(clone.toString());
        System.out.println("------------BeanUtils copy----------");
        CloneTestVO cloneTestVO1 = new CloneTestVO();
        BeanUtils.copyProperties(cloneTestVO, cloneTestVO1);
        System.out.println(cloneTestVO.toString());
        System.out.println(cloneTestVO1.toString());
        System.out.println("------------准备修改数据----------");
        cloneTestVO.getSon().setSex("3号");
        cloneTestVO.setName("3号");
        System.out.println(cloneTestVO.toString());
        System.out.println(cloneTestVO1.toString());
        System.out.println("------------结论----------");
        System.out.println("------------Cloneable和BeanUtils都是浅拷贝----------");

    }

}
