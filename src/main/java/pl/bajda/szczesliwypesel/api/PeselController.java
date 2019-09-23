package pl.bajda.szczesliwypesel.api;

import org.springframework.web.bind.annotation.*;
import pl.bajda.szczesliwypesel.model.Pesel;
import pl.bajda.szczesliwypesel.services.PeselService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pesel/")
public class PeselController {

    private PeselService peselService;

    public PeselController(PeselService peselService) {
        this.peselService = peselService;
    }

    @GetMapping
    public List<Pesel> getAllUsers(){
        return peselService.getAllUser();
    }


    @PostMapping
    public Pesel addNewPesel(@RequestBody Pesel pesel) throws IOException {
        return peselService.addPesel(pesel);
    }
}
