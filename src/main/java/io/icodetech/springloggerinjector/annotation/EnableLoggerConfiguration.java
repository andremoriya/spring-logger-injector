package io.icodetech.springloggerinjector.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.icodetech.springloggerinjector.SpringLoggerInjectorApplication;

@Documented
@Configuration
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SpringLoggerInjectorApplication.class})
public @interface EnableLoggerConfiguration {
}
