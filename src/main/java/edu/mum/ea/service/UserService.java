package edu.mum.ea.service;

import edu.mum.ea.domain.User;

public interface UserService {
	User addNewOrUpdate(User user);
	void remove(Integer id);
	User findOne(Integer id);
}
