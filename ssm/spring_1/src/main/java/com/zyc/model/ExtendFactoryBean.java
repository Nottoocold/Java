package com.zyc.model;

import com.zyc.pojo.Tea;
import org.springframework.beans.factory.FactoryBean;

public class ExtendFactoryBean implements FactoryBean<Tea> {
    @Override
    public Tea getObject() throws Exception {
        return new Tea();
    }

    @Override
    public Class<?> getObjectType() {
        return Tea.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
