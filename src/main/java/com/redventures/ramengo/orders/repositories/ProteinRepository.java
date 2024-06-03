package com.redventures.ramengo.orders.repositories;

import com.redventures.ramengo.orders.domain.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, Long> {
}
