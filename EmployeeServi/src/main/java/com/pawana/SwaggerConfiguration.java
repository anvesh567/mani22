package com.pawana;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration { 
	public static final Contact DEFAULT_CONTACT = new Contact("HR", "www.pawana.com", "hr@pawana.com");
	  public static final ApiInfo DEFAULT = new ApiInfo("Pawana Employee Service documentation", "Pawana Documentation", "1.0", "urn:tos",
	          (springfox.documentation.service.Contact) DEFAULT_CONTACT, "pawana 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT);
}
	
}
