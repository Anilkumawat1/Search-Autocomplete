package com.anilkumawat.searchautocomplete.repositories;

import com.anilkumawat.searchautocomplete.entities.DataGathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataGatheringRepository extends JpaRepository<DataGathering,Long> {
    @Query(value ="SELECT d.word, COUNT(d) as frequency FROM DataGathering d GROUP BY d.word ORDER BY frequency DESC")
    List<Object[]> findWordFrequencies();
}
