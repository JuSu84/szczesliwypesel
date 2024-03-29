package pl.bajda.szczesliwypesel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(User user, Pesel pesel) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(user.getEmail());
        mail.setFrom("carsfleetapp@gmail.com");
        mail.setSubject("Twój szczęśliwy pesel");
        mail.setText("Wygrałęś " + pesel.getData() + pesel.getPesel());

        javaMailSender.send(mail);
    }
}
