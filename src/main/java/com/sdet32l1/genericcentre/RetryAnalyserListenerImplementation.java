package com.sdet32l1.genericcentre;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryAnalyserListenerImplementation implements  IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.sdet32l1.genericcentre.RetryAnalyserImplementation.class);
		
	}
	
}
