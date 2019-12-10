package com.run.cbbmessage.entity;

import java.io.Serializable;

/**
 * 消息头
 *
 * @author fanenjie
 */
public class MessageHeader implements Serializable ,Cloneable{
    private static final long serialVersionUID = -362384753498698092L;

    /**
     * 消息唯一标识
     */
    private String serialNo;

    /**
     * 系统编号
     */
    private String systemId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 消息所在主题
     */
    private String topic;


    /**
     * 存储策略，发布略
     */




    public MessageHeader(){

    }

    public MessageHeader(String systemId, Long createTime, String messageType, String topic) {
        this.systemId = systemId;
        this.createTime = createTime;
        this.messageType = messageType;
        this.topic = topic;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    @Override
    public String toString() {
        return "MessageHeader{" +
                "systemId='" + systemId + '\'' +
                ", createTime=" + createTime +
                ", messageType='" + messageType + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
