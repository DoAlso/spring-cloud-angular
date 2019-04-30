package com.cloud.configservice.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName PropertyChangeEvent
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/4/10 10:31
 */
public class PropertyChangeEvent extends ApplicationEvent {

    private String profile;

    public PropertyChangeEvent(Object source,String profile) {
        super(source);
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }
}
