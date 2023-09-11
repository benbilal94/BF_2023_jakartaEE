package be.bf.bf_2023_jakartaee.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;

    private String uName;

    private String uFirstName;
    @Column()
    private LocalDate uBirthDate;


    public Long getId() {
        return id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuFirstName() {
        return uFirstName;
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public LocalDate getuBirthDate() {
        return uBirthDate;
    }

    public void setuBirthDate(LocalDate uBirthDate) {
        this.uBirthDate = uBirthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(id, that.id) && Objects.equals(uName, that.uName) && Objects.equals(uFirstName, that.uFirstName) && Objects.equals(uBirthDate, that.uBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uName, uFirstName, uBirthDate);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", uName='" + uName + '\'' +
                ", uFirstName='" + uFirstName + '\'' +
                ", uBirthDate=" + uBirthDate +
                '}';
    }
}
