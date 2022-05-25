package kz.iitu.itse1907.akmaral.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "recommendations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendations {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @CreatedBy
    @NotNull
    private int id;

    @Column(name = "comment")
    @CreatedBy
    @NotNull
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    @JsonIgnore
    private Book book;

    @AssertTrue(message = "Recommendations comment should not be empty or null!")
    public boolean isNameProfileInValid(){
        return comment!= null;
    }


    @Override
    public String toString() {
        return "Recommendations{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", books=" + book +
                '}';
    }
}
