package io.icodetech.springloggerinjector.annotation;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)
public @interface Log {

}
