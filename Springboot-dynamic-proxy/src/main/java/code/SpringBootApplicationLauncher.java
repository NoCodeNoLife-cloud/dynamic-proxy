package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
// @EnableEurekaServer
// @EnableDiscoveryClient
// @EnableFeignClients
// @EnableDubbo
@SpringBootApplication
public class SpringBootApplicationLauncher {
	/**
	 * Entry point of the application.
	 *
	 * @param args The command line arguments.
	 */
	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationLauncher.class, args);
	}

	/**
	 * This method creates and returns an ApplicationRunner bean.
	 * The ApplicationRunner bean is used to execute code when the application starts.
	 *
	 * @return an ApplicationRunner bean
	 */
	@Bean
	public ApplicationRunner applicationRunner(@Autowired RealModule realModule) {
		return args -> {
			System.out.println("realModule.get(\"127.0.0.1\") = " + realModule.get("127.0.0.1"));
		};
	}
}