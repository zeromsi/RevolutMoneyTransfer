package com.revolut.moneytransfer;

import java.io.File;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import com.revolut.moneytransfer.config.ResourceLoader;
import com.revolut.moneytransfer.data.repository.DataStore;

public class Application {
	public static void main(String[] args)
			throws LifecycleException, MalformedURLException, ServletException, InterruptedException {
		new Application().start();
	}

	public void start() throws ServletException, LifecycleException, MalformedURLException, InterruptedException {
		String webappDirLocation = "src/main/webapp/";
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8081";
		}
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(Integer.valueOf(webPort));
		Context context = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
		File configFile = new File(webappDirLocation + "WEB-INF/web.xml");
		context.setConfigFile(configFile.toURI().toURL());
		init();
		tomcat.start();
		tomcat.getServer().await();
	}

	private ServletContainer resourceConfig() {
		return new ServletContainer(new ResourceConfig(new ResourceLoader().getClasses()));
	}

	public static void init() {
		DataStore.init();
	}

}