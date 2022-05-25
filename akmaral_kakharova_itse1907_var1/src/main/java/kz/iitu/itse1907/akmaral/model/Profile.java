package kz.iitu.itse1907.akmaral.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable {

    @Id
    @CreatedBy
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "fname")
    @CreatedDate
    @NotNull
    @Size(min = 1,max = 100)
    private String fname;

    @Column(name = "lname")
    @LastModifiedBy
    @NotNull
    @Size(min = 1,max = 100)
    private String lname;

    @Column(name = "age")
    @LastModifiedDate
    @Min(12)
    @NotNull
    private int age;

    @Column(name = "email")
    @CreatedBy
    @NotNull
    private String email;

    @Column(name = "login")
    @CreatedBy
    @NotNull
    private String login;

    @Column(name = "password")
    @CreatedBy
    @NotNull
    @Min(6)
    private String password;


    @AssertTrue(message = "Profile Name should not be named after Meirambek!")
    public boolean isNameProfileInValid(){
        return fname!= null && !fname.equalsIgnoreCase("Meirambek");
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "mylist",
            joinColumns = @JoinColumn(name = "profileId"),
            inverseJoinColumns = @JoinColumn(name = "bookId"))
    private Set<Book> movies = new HashSet<>();

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
