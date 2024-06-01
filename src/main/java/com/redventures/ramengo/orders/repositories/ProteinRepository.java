package com.redventures.ramengo.orders.repositories;

import com.redventures.ramengo.orders.domain.Protein;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProteinRepository extends MongoRepository<Protein, String> {
}
