package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, UUID> {
    public List<Partida> findByCodigoTorneio(String torneioToken);
}
