package com.nate.automation.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.ITestNGMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer  implements IAnnotationTransformer {

    public void transform(ITestNGMethod method, Class testClass, Constructor testConstructor, Method testMethod) {
        // You can modify the test method here if needed
        // For example, you can set the retry analyzer for the test method
        method.setRetryAnalyzerClass(Retry.class);

    }
}
