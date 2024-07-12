package code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RealModule {
	public String get(String url) {
		log.info("processing...");
		return "result";
	}
}