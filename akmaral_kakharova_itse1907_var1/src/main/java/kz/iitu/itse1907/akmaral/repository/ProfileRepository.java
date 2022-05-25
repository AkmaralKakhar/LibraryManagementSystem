package kz.iitu.itse1907.akmaral.repository;

import kz.iitu.itse1907.akmaral.model.Book;
import kz.iitu.itse1907.akmaral.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    //@Query("select p from #{#entityName} p")
    List<Profile> findAll();


    List<Profile> findByFname(String firstName);

    //@Query("select p from #{#entityName} p")
    //List<Profile> findByBooks(Book book);

    List<Profile> findByFnameAndLname(String firstName, String Lname);

    List<Profile> findByAge(Integer age);

    List<Profile> findByLogin(String login);
}
