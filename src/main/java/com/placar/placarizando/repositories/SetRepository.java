package com.placar.placarizando.repositories;

import com.placar.placarizando.entities.Set;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SetRepository extends JpaRepository<Set, UUID> {
}
