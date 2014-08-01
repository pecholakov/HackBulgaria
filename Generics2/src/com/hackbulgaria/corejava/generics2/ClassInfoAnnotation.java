package com.hackbulgaria.corejava.generics2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfoAnnotation {
    
    String author();
    int revision() default 1;
    boolean checked() default false;
    Class<?>[] related();
}
