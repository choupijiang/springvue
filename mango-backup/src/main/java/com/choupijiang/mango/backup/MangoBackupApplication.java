package com.choupijiang.mango.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages={"com.choupijiang.mango"})
public class MangoBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoBackupApplication.class, args);
	}

}
