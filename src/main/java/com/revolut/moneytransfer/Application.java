package com.revolut.moneytransfer;

import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.revolut.moneytransfer.config.ResourceLoader;

import java.io.File;
import java.net.MalformedURLException;

public class Application {
	public static void main(String[] args) throws LifecycleException, MalformedURLException, ServletException, InterruptedException {
		new Application().start();
	}

	public void start() throws ServletException, LifecycleException, MalformedURLException, InterruptedException {
		String webappDirLocation = "src/main/webapp/";
		Tomcat tomcat = new Tomcat();
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8081";
		}
		tomcat.setPort(Integer.valueOf(webPort));
		Context context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
		File configFile = new File(webappDirLocation + "WEB-INF/web.xml");
		context.setConfigFile(configFile.toURI().toURL());
		
		tomcat.start();
		Thread tomcatThread=new Thread(() ->tomcat.getServer().await());
		tomcatThread.start();
		tomcatThread.join();

	}

	private ServletContainer resourceConfig() {
		return new ServletContainer(new ResourceConfig(new ResourceLoader().getClasses()));
	}

}