package com.mysql.ample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.ample.mapper.DemoMapper;
import com.mysql.ample.model.Demo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlAmpleApplication.class)
public class MysqlAmpleApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(MysqlAmpleApplicationTests.class);

	@Autowired
	DemoMapper demoMapper;

	@Test
	public void ready() {
		long begin = System.currentTimeMillis();
		for(int i = 0; i < 10000; i ++){
			Demo demo = new Demo();
			demo.setFlag("true");
			demo.setIdOther(i+1);
			demoMapper.insert(demo);
		}
		logger.info("时间为:{}",System.currentTimeMillis() - begin);
	}
	
}
