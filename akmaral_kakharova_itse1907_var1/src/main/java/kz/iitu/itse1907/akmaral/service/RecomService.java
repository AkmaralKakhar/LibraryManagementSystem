package kz.iitu.itse1907.akmaral.service;

import kz.iitu.itse1907.akmaral.model.Recommendations;
import kz.iitu.itse1907.akmaral.repository.RecomRepository;
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
public class RecomService {

    private RecomRepository recomRepository;

    Logger logger = LoggerFactory.getLogger(RecomService.class);

    @Autowired
    public RecomService(RecomRepository recomRepository) {
        this.recomRepository = recomRepository;
    }

    @Transactional(readOnly=true)
    @Cacheable("streaming")
    public List<Recommendations> findAll() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Listed elements of Books");
        return recomRepository.findAll();}

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Cacheable("streaming")
    public List<Recommendations> findAllById(Integer id){
        return recomRepository.findAllById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Cacheable("streaming")
    public List<Recommendations> findByBook_Id(Integer id){
        return recomRepository.findByBook_Id(id);
    }

    @Transactional(timeout = 100)
    @Cacheable("streaming")
    public List<Recommendations> findByComment(String comment){
        return recomRepository.findByComment(comment);
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Cacheable("streaming")
    public List<Recommendations> findByIdAndAndBook(Integer id, Integer movies_id){
        return recomRepository.findByIdAndAndBook(id,movies_id);
    }
}
