package kz.iitu.itse1907.akmaral.service;

import kz.iitu.itse1907.akmaral.model.Book;
import kz.iitu.itse1907.akmaral.model.Profile;
import kz.iitu.itse1907.akmaral.repository.ProfileRepository;
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
public class ProfileService {

    private ProfileRepository profileRepository;
    Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional(readOnly=true)
    @Cacheable("streaming")
    public List<Profile> findAll() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Listed elements of profiles");
        return profileRepository.findAll();}

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Cacheable("streaming")
    public List<Profile> findByFirstName(String firstName){
       return profileRepository.findByFname(firstName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Cacheable("streaming")
    public List<Profile> findByFnameandLname(String firstName, String lastName){
       return profileRepository.findByFnameAndLname(firstName,lastName);
    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public List<Profile> findByAge(Integer age){
        return profileRepository.findByAge(age);
    }

//    @Transactional(timeout = 100)
//    @Cacheable("streaming")
//    public List<Profile> findByBooks(Book book){
//        return profileRepository.findByBooks(book);
//    }
//


    @Transactional(rollbackFor = {RuntimeException.class})
    @Cacheable("streaming")
    public List<Profile> findByLogin(String login){
        return profileRepository.findByLogin(login);
    }
}
