package pl.bajda.szczesliwypesel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SzczesliwypeselApplication {

    public static void main(String[] args) {
        SpringApplication.run(SzczesliwypeselApplication.class, args);
    }



}
