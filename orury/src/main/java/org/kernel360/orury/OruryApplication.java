package org.kernel360.orury;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class OruryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OruryApplication.class, args);
	}

}
