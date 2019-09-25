package pl.bajda.szczesliwypesel.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import pl.bajda.szczesliwypesel.model.Pesel;


@Component
@EnableAsync
public class PeselGetter {

    private final String url = "https://www.rmf.fm/r/pesel-2019.html";
    private final String mainDiv = "div#xpesele-contents";
    private final String date = "h3";
    private final String divWithPesel = ".xbig";
    private final String divWithNumber = ".xlit";
    Logger logger = LoggerFactory.getLogger(this.getClass());



   public Pesel getHappyPesel() throws Exception {
        Pesel pesel = new Pesel();
        for (Element link : Jsoup.connect(url).get().select(mainDiv)) {
            pesel.setData(link.select(date).text());
            pesel.setPesel(link.select(divWithPesel).select(divWithNumber).text().replace(" ", ""));
        }
        logger.info(pesel.toString());
        return pesel;
    }


}
