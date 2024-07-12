package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CglibDynamicProxyGenerator implements MethodInterceptor {
	private final Object target;

	public CglibDynamicProxyGenerator(Object target) {
		this.target = target;
	}

	/**
	 * Creates a proxy object using CGLIB Enhancer.
	 *
	 * @return the created proxy object
	 */
	public Object createProxy() {
		Enhancer enhancer = new Enhancer();// Create a new Enhancer instance
		enhancer.setSuperclass(target.getClass());// Set the superclass of the enhancer to the target class
		enhancer.setCallback(this);// Set the callback for the enhancer to this MethodInterceptor
		return enhancer.create();// Create and return the proxy object
	}

	/**
	 * Intercepts the method invocation.
	 *
	 * @param o           the proxy object
	 * @param method      the method being invoked
	 * @param objects     the method arguments
	 * @param methodProxy the method proxy
	 *
	 * @return the result of the method invocation
	 *
	 * @throws Throwable if an error occurs during invocation
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		doBefore();// Perform actions before method invocation
		Object result = method.invoke(target, objects);// Invoke the target method
		doAfter();// Perform actions after method invocation
		return result;
	}

	public void doBefore() {
		log.info("do before");
	}

	public void doAfter() {
		log.info("do after");
	}
}