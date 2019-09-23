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

        Pesel pesel = new Pesel();
        User user = new User();


        Document doc = Jsoup.connect("https://www.rmf.fm/r/pesel-2019.html").get();


        Elements links = doc.select("div#xpesele-contents");
        for (Element link : links) {


            pesel.setData(link.select("h3").text());
            pesel.setPesel(link.select(".xbig").select(".xlit").text().replace(" ", ""));
        }
        peselRepository.save(pesel);

//        if(user.getMojPesel().equals(pesel.getPesel())){
//            emailService.sendMail(user, pesel);
//        }
    }


}
