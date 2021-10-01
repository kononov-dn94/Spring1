package com.example.demo;

import com.example.demo.entity.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Task task = new Task();
		Date dNow = new Date();
//		System.out.println(task.getStatus());
//		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//		SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println("Current Date: " + ft.format(dNow));
//		System.out.println("Current Date: " + dNow);
//		System.out.println("Current Date: " + ft1.format(dNow));
//		task.setName("Ivan");
//		task.setDescription("guarantor");
//		task.setPriority(1);
//		task.setDate(dNow);
//		task.setStatus(Status.CLOSE);
//		System.out.println(task.toString());
	}

}
