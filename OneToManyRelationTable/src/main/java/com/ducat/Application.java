package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.users.*;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(Application.class, args);
	//Requesting the TrainerSaver bean.
	TrainerSaver saver= (TrainerSaver)ctx.getBean("trainerSaver");
	//Saving the Trainer and related batches objects.
	saver.save();
	// Loading the trainers and their batches.
	Loader loader= (Loader)ctx.getBean("loader");
	loader.load();
	
	}

}
