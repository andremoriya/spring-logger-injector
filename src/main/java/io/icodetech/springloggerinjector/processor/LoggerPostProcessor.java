package io.icodetech.springloggerinjector.processor;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import io.icodetech.springloggerinjector.annotation.Log;

@Component
class LoggerPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
			
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                if (field.isAnnotationPresent(Log.class)) {
                	String typeName = field.getType().getTypeName();
                	if("org.slf4j.Logger".equalsIgnoreCase(typeName)) {                		
                		final Logger log = LoggerFactory.getLogger(bean.getClass());
                		field.set(bean, log);
                	} else if("org.apache.logging.log4j.Logger".equalsIgnoreCase(typeName)) {
                		final org.apache.logging.log4j.Logger log = LogManager.getLogger(bean.getClass());
                		field.set(bean, log);
                	} else {
                		throw new IllegalArgumentException("@Log supports only org.slf4j.Logger and org.apache.logging.log4j.Logger implementations");
                	}
                }
            }
            
        });
        return bean;
	}
	
}
