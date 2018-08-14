package io.icodetech.springloggerinjector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.icodetech.springloggerinjector.annotation.Log;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringLoggerInjectorApplicationTests {
	
	@Log
	private Logger slf4jLog;
	
	@Log
	private org.apache.logging.log4j.Logger apacheLog;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(slf4jLog);
		
		slf4jLog.info("Using a slf4j info log");
		
		Assert.assertNotNull(apacheLog);
		
		apacheLog.info("Using a log4j2 info log");
	}

}
