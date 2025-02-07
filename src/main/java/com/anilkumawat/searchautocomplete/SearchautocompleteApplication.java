package com.anilkumawat.searchautocomplete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SearchautocompleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchautocompleteApplication.class, args);
	}

}
