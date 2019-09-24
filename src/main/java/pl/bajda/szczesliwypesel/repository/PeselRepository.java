package pl.bajda.szczesliwypesel.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bajda.szczesliwypesel.model.Pesel;

public interface PeselRepository extends CrudRepository<Pesel, Long> {

}
