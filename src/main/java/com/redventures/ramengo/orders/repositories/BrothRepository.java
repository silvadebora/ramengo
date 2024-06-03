package com.redventures.ramengo.orders.repositories;

import com.redventures.ramengo.orders.domain.Broth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrothRepository extends JpaRepository<Broth, Long> {
}
