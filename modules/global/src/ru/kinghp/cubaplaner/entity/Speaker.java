package ru.kinghp.cubaplaner.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "CUBAPLANER_SPEAKER", indexes = {
        @Index(name = "IDX_CUBAPLANER_SPEAKER_LAST_NAME", columnList = "LAST_NAME")
})
@Entity(name = "cubaplaner_Speaker")
@NamePattern("%s %s|firstName,lastName")
public class Speaker extends StandardEntity {
    private static final long serialVersionUID = 6552845745421431704L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 1024)
    @Email(message = "wrong e-mail")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}