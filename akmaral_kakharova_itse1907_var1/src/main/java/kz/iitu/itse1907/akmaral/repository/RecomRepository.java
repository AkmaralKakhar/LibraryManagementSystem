package kz.iitu.itse1907.akmaral.repository;

import kz.iitu.itse1907.akmaral.model.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomRepository extends JpaRepository<Recommendations,Integer> {


    @Query("select r from #{#entityName} r")
    List<Recommendations> findAll();

    List<Recommendations> findAllById(Integer id);

    List<Recommendations> findByBook_Id(Integer id);

    List<Recommendations> findByComment(String comment);

    List<Recommendations> findByIdAndAndBook(Integer id, Integer movies_id);

}
