package kz.iitu.itse1907.akmaral;

import kz.iitu.itse1907.akmaral.model.Book;
import kz.iitu.itse1907.akmaral.repository.BookRepository;
import kz.iitu.itse1907.akmaral.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringLab7ApplicationTests {

    Logger logger = LoggerFactory.getLogger(BookService.class);

    private BookService bookService;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAll() throws InterruptedException {
        List<Book> res = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Robinson Crusoe");
        book1.setAuthor("Daniel Defoe");
        book1.setGenre("Classic");
        book1.setPublishedYear(1719);
        res.add(book1);

        //s(4,'Little Women', 'Detective', 1869,'Louisa May Alcott');
        Book book4 = new Book();
        book4.setId(4);
        book4.setName("Little Women");
        book4.setAuthor("Louisa May Alcott");
        book4.setGenre("Detective");
        book4.setPublishedYear(1869);
        res.add(book4);

        //(3,'Alice in Wonderland', 'Fantasy', 1865,'Lewis Carrol');
        Book book3 = new Book();
        book3.setId(3);
        book3.setName("Alice in Wonderland");
        book3.setAuthor("Lewis Carrol");
        book3.setGenre("Fantasy");
        book3.setPublishedYear(1865);
        res.add(book3);

        //(2,'Emma', 'Drama', 1816,'Jane Austen');
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("Emma");
        book2.setAuthor("Jane Austen");
        book2.setGenre("Drama");
        book2.setPublishedYear(1816);
        res.add(book2);

        List<Book> result = bookService.findAll();
        Assertions.assertEquals(res, result);
    }



}
