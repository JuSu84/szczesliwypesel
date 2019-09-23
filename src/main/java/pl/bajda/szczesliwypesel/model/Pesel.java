package pl.bajda.szczesliwypesel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pesel {

    @Id
    @GeneratedValue
    Long id;
    private String pesel;

    public Pesel() {
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }



}
