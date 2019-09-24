package pl.bajda.szczesliwypesel.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pl.bajda.szczesliwypesel.services.EmailService;

@Component
public class DataSetUp implements CommandLineRunner {


    private EmailService emailService;

    @Autowired
    public DataSetUp( EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {


  }


}
