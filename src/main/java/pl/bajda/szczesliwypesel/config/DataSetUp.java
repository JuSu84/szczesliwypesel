package pl.bajda.szczesliwypesel.config;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.repository.PeselRepository;
import pl.bajda.szczesliwypesel.services.EmailService;

@Component
public class DataSetUp implements CommandLineRunner {

    private PeselRepository peselRepository;
    private EmailService emailService;

    @Autowired
    public DataSetUp(PeselRepository peselRepository, EmailService emailService) {
        this.peselRepository = peselRepository;
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {



//        if(user.getMojPesel().equals(pesel.getPesel())){
//            emailService.sendMail(user, pesel);
//        }
    }


}
