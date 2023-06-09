package com.user.service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.service.entity.User;

public interface UserRepository extends MongoRepository<User, Integer> {

}
