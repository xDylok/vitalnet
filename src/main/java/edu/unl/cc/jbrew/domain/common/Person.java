package edu.unl.cc.jbrew.domain.common;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable {

    private Long id;

    @NotNull @NotEmpty
    private String firstName;

    @NotNull @NotEmpty
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private GenderType gender;

    public Person() {
        birthDate = LocalDate.now();
    }

    public Person(Long id, String firstName, String lastName, String email, GenderType gender)
            throws IllegalArgumentException{
        this();
        //validateObligatoryField(firstName);
        //validateObligatoryField(lastName);
        this.id = id;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.email = email;
        this.gender = gender;
    }

    private void validateObligatoryField(String text) throws IllegalArgumentException{
        if (text == null || text.isEmpty()){
            throw new IllegalArgumentException("Campo obligatorio vacio");
        }
    }

    public String getFullName(){
        return lastName + " " + firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.birthDate);
        hash = 53 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.birthDate, other.birthDate);
    }

    @Override
    public String toString() {
        return "Person{" + "id:" + id + ", firstName:" + firstName + ", lastName:" + lastName + ", birthDate:" + birthDate + ", email:" + email + '}';
    }
}