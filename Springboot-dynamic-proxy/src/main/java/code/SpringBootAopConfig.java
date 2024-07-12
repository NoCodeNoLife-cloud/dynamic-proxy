package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SpringBootAopConfig {
	/**
	 * facade
	 *
	 * @param proceedingJoinPoint proceedingJoinPoint
	 *
	 * @return Object
	 */
	@Around("execution(* code.RealModule.*(..))")
	@SneakyThrows
	public Object facade(ProceedingJoinPoint proceedingJoinPoint) {
		log.info("before proceed");
		Object proceed = proceedingJoinPoint.proceed();
		log.info("after proceed");
		return proceed;
	}
}