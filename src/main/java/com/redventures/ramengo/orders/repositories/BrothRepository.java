package com.redventures.ramengo.orders.repositories;

import com.redventures.ramengo.orders.domain.Broth;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrothRepository extends MongoRepository<Broth, String> {
}
