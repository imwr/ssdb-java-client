package org.nutz.ssdb4j.impl;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;
import org.nutz.ssdb4j.SSDBClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SSDBClientTest extends JUnit4Builder {

	SSDBClient ssdbClient;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-test-config.xml");
		ssdbClient = (SSDBClient) ctx.getBean("ssdbClient");
	}

	@Test
	public void testTest() {
		System.out.println(ssdbClient.set("ssdbClient-test", "ssdbClient-test"));
		System.out.println(ssdbClient.get("ssdbClient-test"));
	}

	@After
	public void after() throws IOException {
		ssdbClient.close();
	}
}