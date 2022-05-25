package kz.iitu.itse1907.akmaral.service;

import kz.iitu.itse1907.akmaral.model.Book;
import kz.iitu.itse1907.akmaral.model.Profile;
import kz.iitu.itse1907.akmaral.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    Logger logger = LoggerFactory.getLogger(BookRepository.class);

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly=true)
    @Cacheable("streaming")
    public List<Book> findAll() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Listed elements of Movies");
        return bookRepository.findAll();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Cacheable("streaming")
    public List<Book> findByName(String name){
        return bookRepository.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Cacheable("streaming")
    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public List<Book> findByGenre(String genre){
        return bookRepository.findByGenre(genre);

    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public List<Book> getBooksByProfile(Profile profile){
        return bookRepository.getBooksByProfile(profile);

    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Cacheable("streaming")
    public List<Book> findByPublishedYear(Integer publishedYear){
        return bookRepository.findByPublishedYear(publishedYear);
    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public String saveBook(Book book){
        //System.out.println(movie.toString());
        bookRepository.save(book);
        return "sohraneno";
    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public String deleteBook(int id){
        //System.out.println(movie.toString());
        bookRepository.deleteById(id);
        return "udaleno";
    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public String updateBook(Book movie_update, int id){

        Book book = bookRepository.findById(id);

        book.setName(movie_update.getName());
        book.setGenre(movie_update.getGenre());
        book.setPublishedYear(movie_update.getPublishedYear());
        book.setAuthor(movie_update.getAuthor());

        bookRepository.save(book);

        return "updated";
    }

    /*

        Book book = bookRepository.findAllById(book_update.getId());
        book.setName(book_update.getName());
        book.setGenre(book_update.getGenre());
        book.setPrice(book_update.getPrice());


        bookRepository.save(book);

        return "Успешно Изменен";

    }


    */
}
