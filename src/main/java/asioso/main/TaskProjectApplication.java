package asioso.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import asioso.main.client.ProductClient;

@SpringBootApplication
public class TaskProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskProjectApplication.class, args);
	}

	 @Bean
	    public ProductClient productClient() {
	        return new ProductClient();
	    }
}
