package com.run.cbbmessage.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 消息实体类
 *
 * @author fanenjie
 */
@ApiModel
public class Message implements Serializable, Cloneable {


    private static final long serialVersionUID = -3626421563498382832L;

    /**
     * 统一消息头
     */
    private MessageHeader header;

    /**
     * JSON格式的消息体
     */
    private Object messageBody;


    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public Object getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "Message{" +
                "header=" + header +
                ", messageBody=" + messageBody +
                '}';
    }
}
