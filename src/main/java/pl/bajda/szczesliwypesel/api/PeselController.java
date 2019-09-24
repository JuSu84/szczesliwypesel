package pl.bajda.szczesliwypesel.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.services.PeselService;

import java.util.List;

@RestController
@RequestMapping("/pesel/")
public class PeselController {

    private PeselService peselService;

    public PeselController(PeselService peselService) {
        this.peselService = peselService;
    }

    @GetMapping
    public List<Pesel> getAllPesels() {
        return peselService.getAllPesels();
    }

//    @PostMapping
//    public Pesel addNewPesel(@RequestBody Pesel pesel) throws IOException {
//        return peselService.addPesel(pesel);
//    }
}
