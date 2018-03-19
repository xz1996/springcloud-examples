package com.springcloud.microservice.cloudstreama;

import com.springcloud.microservice.cloudstreama.service.MsgHandler;
import com.springcloud.microservice.cloudstreama.utility.SpringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudstreamAApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("this is : " + SpringUtil.getBean(MsgHandler.class));
	}

}
