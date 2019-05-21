package com.revolut.moneytransfer;

import java.net.MalformedURLException;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;

import com.revolut.moneytransfer.data.repository.DataStore;

public class Application {
	public static void main(String[] args)
			throws LifecycleException, MalformedURLException, ServletException, InterruptedException {
		ServerConfig.start();
	}

}