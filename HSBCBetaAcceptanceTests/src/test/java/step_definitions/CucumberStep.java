package step_definitions;

import org.springframework.test.context.ContextConfiguration;
import support.ExecutionConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {ExecutionConfiguration.class})
public @interface CucumberStep {
}