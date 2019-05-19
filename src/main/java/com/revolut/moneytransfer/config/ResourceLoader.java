package com.revolut.moneytransfer.config;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.revolut.moneytransfer.MyResource;
import com.revolut.moneytransfer.business.bean.implementation.TransferBeanImplementation;
 
public class ResourceLoader extends Application{
	
 
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        
        // register root resource
        classes.add(MyResource.class);
        classes.add(TransferBeanImplementation.class);
        return classes;
    }
}