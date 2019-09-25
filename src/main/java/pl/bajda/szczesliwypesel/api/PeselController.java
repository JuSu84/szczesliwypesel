package pl.bajda.szczesliwypesel.api;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public Pesel addNewHappyPesel(@RequestBody Pesel pesel) throws Exception {
        return peselService.addNewHappyPesel(pesel);
    }
}
