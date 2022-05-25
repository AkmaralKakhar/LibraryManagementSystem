package kz.iitu.itse1907.akmaral.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
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

@Data
@Entity
@Table(name = "Books")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Book.findAll",
        query = "select m from Book m")
public class Book implements Serializable {

    @Id
    //@Column(name = "id"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    @CreatedDate
    @NotNull
    @Size(min = 1,max = 150)
    private String name;

    @Column(name = "genre")
    @LastModifiedBy
    private String genre;

    @Column(name = "isbn")
    @CreatedBy
    @NotNull
    private long isbn;

    @Column(name = "publishedYear")
    @LastModifiedDate
    @Min(1)
    private int publishedYear;

    @Column(name = "author")
    @CreatedBy
    @NotNull
    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Recommendations> recommendations = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "mylist",
            joinColumns = @JoinColumn(name = "profileId"),
            inverseJoinColumns = @JoinColumn(name = "bookId"))
    private Set<Profile> profiles = new HashSet<>();

    @AssertTrue(message = "Book Genre should not be named after Documentary!")
    public boolean isGenreInValid(){
        return genre!= null && !genre.equalsIgnoreCase("Documentary");
    }


    @AssertTrue(message = "Book should not be named after Akmaral!")
    public boolean isNameInValid(){
        return name!= null && !name.equalsIgnoreCase("Akmaral");
    }

//    @Override
//    public String toString() {
//        return "\nBook{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", genre='" + genre + '\'' +
//                ", published year=" + publishedYear +
//                ", author=" + author +
//                '}';
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn=" + isbn +
                ", publishedYear=" + publishedYear +
                ", author='" + author + '\'' +
                '}';
    }


//    public Book(int id, String name, String genre, int publishedYear, String author) {
//        this.id = id;
//        this.name = name;
//        this.genre = genre;
//        this.publishedYear = publishedYear;
//        this.author = author;
//    }


    public Book(int id, String name, String genre, long isbn, int publishedYear, String author) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;
    }
}
