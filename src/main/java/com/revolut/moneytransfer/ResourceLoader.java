package com.revolut.moneytransfer;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.revolut.moneytransfer.business.bean.implementation.TransferBeanImplementation;

public class ResourceLoader extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(TransferBeanImplementation.class);
        return classes;
    }
}