package kz.iitu.itse1907.akmaral;

import kz.iitu.itse1907.akmaral.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLab7Application {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) throws InterruptedException {
       applicationContext =  SpringApplication.run(SpringLab7Application.class, args);

        BookService bookService = applicationContext.getBean(BookService.class);


        System.out.println(bookService.findAll());

        System.out.println(bookService.findByGenre("Fantasy"));

while (true){
    continue;
}

    }

}
