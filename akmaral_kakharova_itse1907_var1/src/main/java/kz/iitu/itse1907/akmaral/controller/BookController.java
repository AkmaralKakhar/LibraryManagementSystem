package kz.iitu.itse1907.akmaral.controller;

import kz.iitu.itse1907.akmaral.model.Book;
import kz.iitu.itse1907.akmaral.model.Profile;
import kz.iitu.itse1907.akmaral.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

//@Component
@RestController
@RequestMapping("/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookService.class);

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/allBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll() throws InterruptedException {

        return bookService.findAll();
    }


    @GetMapping("/getBooksByProfile")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByProfile(Profile profile) throws InterruptedException {
        return bookService.getBooksByProfile(profile);
    }


    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody

    public String saveBook(@RequestBody Book book){

        System.out.println(book.toString());
        bookService.saveBook(book);

        return "Succesfully saved!";
    }

    @DeleteMapping("/deleteBook/{id}")
    @ResponseStatus(HttpStatus.OK)

    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Успешно Удален";
    }



    @PutMapping("/updateBook/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateBook(@RequestBody Book book_update, @PathVariable int id) {

        bookService.updateBook(book_update, id);

        return "Успешно Изменен";

    }




}
