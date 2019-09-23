package pl.bajda.szczesliwypesel.services;


import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.repository.PeselRepository;

import java.io.IOException;
import java.util.List;

@Service
public class PeselService {

    @Autowired
    private PeselRepository peselRepository;
    private UserService userService;

    public PeselService(UserService userService) {
        this.userService = userService;
    }

    public List<Pesel> getAllUser() {
        return Lists.newArrayList(peselRepository.findAll());
    }

    public Pesel addPesel(Pesel pesel) throws IOException {


        // need http protocol
        Document doc = Jsoup.connect("https://www.rmf.fm/r/pesel-2019.html").get();

        // get page title
        String title = doc.title();
        System.out.println(title);


        Elements links = doc.select("div#xpesele-contents");
        for (Element link : links) {


            String data = link.select("h3").text();
            pesel.setPesel(link.select(".xbig").select(".xlit").text().replace(" ", ""));


        }
        return peselRepository.save(pesel);
    }
}
