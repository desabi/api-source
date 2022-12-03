package com.desabi.api.source.repository;

import com.desabi.api.source.entity.PersonEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonEntity, ObjectId> {
}
