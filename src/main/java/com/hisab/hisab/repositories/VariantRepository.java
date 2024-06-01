package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VariantRepository extends JpaRepository<Variant, Long> {
    @Override
    <S extends Variant> S save(S entity);

    @Override
    Optional<Variant> findById(Long aLong);
}
