package pl.bajda.szczesliwypesel.services;


import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.repository.PeselRepository;

import java.util.List;

@Service
public class PeselService {

    private PeselRepository peselRepository;
    private PeselGetter peselGetter;

    @Autowired
    public PeselService(PeselRepository peselRepository, PeselGetter peselGetter) {
        this.peselRepository = peselRepository;
        this.peselGetter = peselGetter;
    }



    public List<Pesel> getAllPesels() {
        return Lists.newArrayList(peselRepository.findAll());
    }


    public Pesel addNewHappyPesel(Pesel pesel) throws Exception {
        pesel = peselGetter.getHappyPesel();

        return peselRepository.save(pesel);
    }

}
