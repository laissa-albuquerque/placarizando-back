package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Set;
import com.placar.placarizando.entities.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeRepository extends JpaRepository<Time, UUID> {

    Time findByNomeTime(String nomeTime);

}
