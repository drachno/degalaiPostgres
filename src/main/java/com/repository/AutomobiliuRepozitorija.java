package com.repository;


import com.entity.Automobilis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutomobiliuRepozitorija extends JpaRepository<Automobilis, Long> {

    @Query(value = "SELECT * FROM Automobiliai WHERE degalutipas = :degalai", nativeQuery = true)
    List<Automobilis> getByDegaluTipas(@Param("degalai") String degalutipas);
}
