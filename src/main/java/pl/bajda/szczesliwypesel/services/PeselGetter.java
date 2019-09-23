package pl.bajda.szczesliwypesel.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.repository.PeselRepository;
import pl.bajda.szczesliwypesel.repository.UserRepository;

@Component
@EnableAsync
public class PeselGetter {

    private final String url = "https://www.rmf.fm/r/pesel-2019.html";
    private final String mainDiv = "div#xpesele-contents";
    private final String date = "h3";
    private final String divWithPesel = ".xbig";
    private final String divWithNumber = ".xlit";
    private PeselRepository peselRepository;
    private UserRepository userRepository;
    private EmailService emailService;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public PeselGetter(PeselRepository peselRepository, UserRepository userRepository, EmailService emailService) {
        this.peselRepository = peselRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }


    public Pesel getHappyPesel() throws Exception {
        Pesel pesel = new Pesel();
        for (Element link : Jsoup.connect(url).get().select(mainDiv)) {
            pesel.setData(link.select(date).text());
            pesel.setPesel(link.select(divWithPesel).select(divWithNumber).text().replace(" ", ""));
        }
        return peselRepository.save(pesel);
    }


    @Async
    @Scheduled(cron = "0 17 23 * * ?")
    public void checkPesel() throws Exception {
        logger.info("Checking pesel...");
        Pesel happyPesel = getHappyPesel();
        for (User user : userRepository.findAll()) {
            if (user.getMojPesel().equals(happyPesel)) {
                emailService.sendMail(user, happyPesel);
            } else {
                logger.info("Not this time...");
            }
        }
    }
}
