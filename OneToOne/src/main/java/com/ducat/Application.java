package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.users.*;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(Application.class, args);
	/*//Requesting the countrySaver bean.
	CountrySaver saver= (CountrySaver)ctx.getBean("countrySaver");
	//Saving the Country and related HeadOfState objects.
	saver.save();
	//Requesting the countrySaver bean.
	CountryLoader loader= (CountryLoader)ctx.getBean("countryLoader");
	loader.load();*/
	HosLoader loader= (HosLoader)ctx.getBean("hosLoader");
	loader.load();
	}

}
