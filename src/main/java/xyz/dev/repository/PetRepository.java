package xyz.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.dev.entity.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, String> {
}
