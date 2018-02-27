package search;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface SearcherValues {
    String searcherName() default "yandex";
    String nameForFindResults() default "//input[@name='text']";
    String tagName() default "//.[@href='http://www.performance-lab.ru/']";
}
