package pl.bajda.szczesliwypesel.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@SequenceGenerator(name="seq", initialValue=3)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    Long id;
    private String name;
    private String mojPesel;
    @Email
    private String email;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMojPesel() {
        return mojPesel;
    }

    public void setMojPesel(String mojPesel) {
        this.mojPesel = mojPesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
