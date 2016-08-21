package edu.mum.ea.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.domain.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

}
