package test.junit5;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author JiaweiMao 2017.03.16
 * @since 1.0.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("remote") // 使用元注解标签提供了代码的可读性，避免了 tag 中可能的拼写错误导致的问题
public @interface Remote {
}
