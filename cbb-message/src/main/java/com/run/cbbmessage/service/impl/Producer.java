package com.run.cbbmessage.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;


@EnableBinding(Source.class)
public class Producer {

    private Source source;

    public Producer(Source source) {

        this.source = source;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
