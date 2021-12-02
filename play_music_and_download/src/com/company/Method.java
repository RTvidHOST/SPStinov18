package com.company;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Method { // аннотация обозначения метода
}