package com.study.px.spring.springtest;

/**
 * 自定义异常类(继承运行时异常)
 * @author AlanLee
 * @version 2016/11/26
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误编码
     */
    private String errorCode;


    /**
     * 构造一个基本异常.
     *
     * @param message
     *            信息描述
     */
    public MyException(String message)
    {
        super(message);
    }



    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     *            消息是否为属性文件中的Key
     */
    public MyException(String errorCode, String message)
    {
        super(message);
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public MyException(String errorCode, String message, Throwable cause, boolean propertiesKey)
    {
        super(message, cause);
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     *
     * @param message
     *            信息描述
     * @param cause
     *            根异常类（可以存入任何异常）
     */
    public MyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }



}
