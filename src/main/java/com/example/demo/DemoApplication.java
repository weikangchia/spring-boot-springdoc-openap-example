package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	@RequestMapping(value = "hello")
	class HelloController {

		@GetMapping
		public ResponseEntity<HelloDto> getHello(@RequestParam String message) {
			return ResponseEntity.ok().body(new HelloDto(message));
		}

		@PostMapping
		public ResponseEntity<HelloDto> sayHello(@RequestBody HelloDto helloDto) {
			return ResponseEntity.ok().body(helloDto);
		}
	}

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	static class HelloDto {
		private String message;
	}

}
