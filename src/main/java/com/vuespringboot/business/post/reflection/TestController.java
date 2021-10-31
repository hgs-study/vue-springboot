package com.vuespringboot.business.post.reflection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@RestController
public class TestController {
    //리플렉션을 이용한 어노테이션 검색
    @GetMapping("/reflection/test")
    public void test() throws NoSuchMethodException {
        Method method = TestClass.class.getMethod("TestMethod");
        Annotation[] annotations = method.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            if(annotation instanceof TestAnnotation){
                TestAnnotation testAnnotation = (TestAnnotation) annotation;
                System.out.println("testAnnotation.name() = " + testAnnotation.name());
                System.out.println("testAnnotation.value() = " + testAnnotation.value());
            }
        }
    }
}
