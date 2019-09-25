package pl.bajda.szczesliwypesel.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Test;
import pl.bajda.szczesliwypesel.model.Pesel;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PeselGetterTest {

    @Test
    public void getHappyPesel() throws IOException {
        String url = "https://www.rmf.fm/r/pesel-2019.html";
        String mainDiv = "div#xpesele-contents";
        String date = "h3";
        String divWithPesel = ".xbig";
        String divWithNumber = ".xlit";

        Pesel pesel = new Pesel();
        for (Element link : Jsoup.connect(url).get().select(mainDiv)) {
            pesel.setData(link.select(date).text());
            pesel.setPesel(link.select(divWithPesel).select(divWithNumber).text().replace(" ", ""));
        }
        assertTrue(pesel.getData().contains("Szczęśliwy PESEL na dziś"));
    }
}