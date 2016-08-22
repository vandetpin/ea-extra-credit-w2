package edu.mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.dao.UserDAO;
import edu.mum.ea.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
		
	@Override
	public User addNewOrUpdate(User user) {
		return userDAO.save(user);
	}

	@Override
	public void remove(Integer id) {
		userDAO.delete(id);
	}

	@Override
	public User findOne(Integer id) {
		return userDAO.findOne(id);
	}

}
