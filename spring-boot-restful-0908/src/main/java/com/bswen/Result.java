package com.bswen;

/**
 * Created with IntelliJ IDEA.
 * User: zhaocw
 * Date: 15-9-15
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class Result {
    private String message;

    public Result(String result) {
        this.message = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
