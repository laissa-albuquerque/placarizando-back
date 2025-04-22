package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Torneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TorneioRepository extends JpaRepository<Torneio, UUID> {

    Optional<Torneio> findByCodigoTorneio(String codigo);
}
