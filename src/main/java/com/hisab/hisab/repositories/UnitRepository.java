package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Optional<Unit> findById(Long id);
}
