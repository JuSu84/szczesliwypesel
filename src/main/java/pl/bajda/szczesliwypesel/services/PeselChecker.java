package pl.bajda.szczesliwypesel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;

import pl.bajda.szczesliwypesel.repository.UserRepository;


@Component
@EnableAsync
public class PeselChecker {

    private PeselGetter peselGetter;

    private UserRepository userRepository;
    private EmailService emailService;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public PeselChecker(UserRepository userRepository, EmailService emailService, PeselGetter peselGetter) {

        this.userRepository = userRepository;
        this.emailService = emailService;
        this.peselGetter = peselGetter;
    }

    @Async
    @Scheduled(cron = "0 24 08 * * ?")
    public void checkPesel() throws Exception {

        Pesel happyPesel = peselGetter.getHappyPesel();
        for (User user : userRepository.findAll()) {
            logger.info("Checking pesel for: " + user.getName());
            if (user.getMojPesel().equals(happyPesel.getPesel())) {
                emailService.sendMail(user, happyPesel);
            } else {
                logger.info("Not this time...");
            }
        }
    }
}
