package com.study.px.spring.springtest.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PageVO {

    private Integer pageSize;

    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;

    @NotNull(message = "name不能为空")
    private String name;

    public static void main(String[] args) {
        new PageVO().getName();
    }

}
