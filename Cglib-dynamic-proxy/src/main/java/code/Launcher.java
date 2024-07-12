package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Launcher {
	/**
	 * Entry point of the application.
	 *
	 * @param args The command line arguments.
	 */
	@SneakyThrows
	public static void main(String[] args) {
		CglibDynamicProxyGenerator cglibDynamicProxyGenerator = new CglibDynamicProxyGenerator(new RealModule());
		RealModule proxy = (RealModule) cglibDynamicProxyGenerator.createProxy();
		String result = proxy.get("https://www.baidu.com");
		log.info("result: {}", result);
	}
}