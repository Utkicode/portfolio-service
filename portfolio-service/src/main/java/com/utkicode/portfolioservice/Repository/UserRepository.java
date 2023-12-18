package com.utkicode.portfolioservice.Repository;

import com.utkicode.portfolioservice.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

}
