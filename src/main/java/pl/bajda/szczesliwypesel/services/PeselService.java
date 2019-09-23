package pl.bajda.szczesliwypesel.services;


import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.repository.PeselRepository;

import java.util.List;

@Service
public class PeselService {

    private PeselRepository peselRepository;
    private UserService userService;
    private EmailService emailService;
    private PeselGetter peselGetter;

    public PeselService() {
    }

    @Autowired
    public PeselService(PeselRepository peselRepository, UserService userService, EmailService emailService, PeselGetter peselGetter) {
        this.peselRepository = peselRepository;
        this.userService = userService;
        this.emailService = emailService;
        this.peselGetter = peselGetter;
    }



    public List<Pesel> getAllPesels() {
        return Lists.newArrayList(peselRepository.findAll());
    }




}
