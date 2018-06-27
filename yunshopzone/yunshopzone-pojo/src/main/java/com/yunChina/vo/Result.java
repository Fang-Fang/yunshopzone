package com.yunChina.vo;

/**
 * Date:2018/6/26
 * Author: Fong.x
 * Desc:
 */
public class Result {
    private boolean success;
    private String msg;

    public Result() {
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static Result ok(String ok){
        return new Result(true,ok);
    }

    public static Result fail(String fail){
        return new Result(false,fail);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
