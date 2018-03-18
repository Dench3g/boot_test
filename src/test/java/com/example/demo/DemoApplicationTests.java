package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Inject
	private MyService myService;

	@Test
	public void contextLoads() throws InterruptedException, MyException {

		String uuid = myService.getUUID("1");
		String uuid2 = myService.getUUID("1");
		Assert.assertEquals(uuid, uuid2);

		Thread.sleep(4000);
		String uuid3 = myService.getUUID("1");

		Assert.assertNotEquals(uuid, uuid3);

	}

}
