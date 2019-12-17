package com.run.cbbmessage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "register")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
public class Register implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sysId;
    private String sysName;
    private String subscribeUrl;
    private String topic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSubscribeUrl() {
        return subscribeUrl;
    }

    public void setSubscribeUrl(String subscribeUrl) {
        this.subscribeUrl = subscribeUrl;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "register{" +
                "id=" + id +
                ", sysId='" + sysId + '\'' +
                ", sysName='" + sysName + '\'' +
                ", subscribeUrl='" + subscribeUrl + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
