package com.mysql.ample;

import com.mysql.ample.mapper.DemoMapper;
import com.mysql.ample.model.Demo;
import com.mysql.ample.service.TransactionTestOne;
import com.mysql.ample.service.TransactionTestTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlAmpleApplication.class)
public class MysqlAmpleApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(MysqlAmpleApplicationTests.class);

	@Autowired
	DemoMapper demoMapper;

	@Autowired
	TransactionTestOne transactionTestOne;

	@Autowired
	TransactionTestTwo transactionTestTwo;

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

	@Test
	public void test01 () {
		List<Demo> list = demoMapper.selectAll();
		for (Demo bean : list) {
			System.out.println(bean.getId());
		}
	}

	@Test
	public void test02 () {
		transactionTestOne.testOne();
	}

	@Test
	public void test03 () {
		transactionTestOne.testThree();
	}

	@Test
	public void test04 () {
		transactionTestOne.testFive();
	}

	@Test
	public void test05 () {
		transactionTestTwo.testOne();
	}

	@Test
	public void test06 () {
		transactionTestTwo.testTwo();
	}
	
}
