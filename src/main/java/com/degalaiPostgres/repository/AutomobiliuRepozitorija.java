package com.degalaiPostgres.repository;


import com.degalaiPostgres.entity.Automobiliai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutomobiliuRepozitorija extends JpaRepository<Automobiliai, Long> {

    @Query(value = "SELECT * FROM Automobiliai WHERE degalutipas = :degalai", nativeQuery = true)
    List<Automobiliai> getByDegaluTipas(@Param("degalai") String degalutipas);
}
