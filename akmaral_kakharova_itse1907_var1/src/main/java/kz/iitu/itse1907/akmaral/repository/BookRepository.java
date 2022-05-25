package kz.iitu.itse1907.akmaral.repository;

import kz.iitu.itse1907.akmaral.model.Book;
import kz.iitu.itse1907.akmaral.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{


    List<Book> findAll();

    List<Book> findByName(String name);

    //List<Movies> findById(Integer id);
//    @Transactional(timeout = 100)
//    @Cacheable("streaming")
    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    @Query("select b from #{#entityName} b where b.id = :id")
    Book findById(int id);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByPublishedYear(Integer publishedYear);

    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    @Query("select b, p from Book b, Profile p where b.id = p.id")
    List<Book> getBooksByProfile(Profile profile);


}
