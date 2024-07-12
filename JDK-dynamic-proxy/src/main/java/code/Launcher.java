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
		JDKDynamicProxyGenerator<HttpApi> handler = new JDKDynamicProxyGenerator<>(new RealModule());
		HttpApi httpApi = handler.newProxyInstance(Launcher.class.getClassLoader(), new Class[]{HttpApi.class});
		System.out.println("realModule.get(\"127.0.0.1\") = " + httpApi.get("127.0.0.1"));
	}
}
