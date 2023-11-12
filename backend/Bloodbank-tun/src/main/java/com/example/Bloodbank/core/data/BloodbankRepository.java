package com.example.Bloodbank.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BloodbankRepository extends JpaRepository<BloodbankEntity, String> {
    Optional<BloodbankEntity> findById(String _id);
    BloodbankEntity findByIdOrName(String _id, String name);

}