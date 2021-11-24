package dev.chalmers.photoshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PhotoShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoShareApplication.class, args);
	}
}
