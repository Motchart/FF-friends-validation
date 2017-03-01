package core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class override {
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Override {int id() default 0;}
}
