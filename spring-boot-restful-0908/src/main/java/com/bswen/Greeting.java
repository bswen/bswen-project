package com.bswen;

/**
 * Created with IntelliJ IDEA.
 * User: zhaocw
 * Date: 15-9-8
 * Time: 下午4:30
 * To change this template use File | Settings | File Templates.
 */
public class Greeting {
    private long id;
    private String content;

    public Greeting(long l, String format) {
        this.id = l;
        this.content = format;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
