package edu.mum.ea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.dao.ResourceDAO;
import edu.mum.ea.domain.Resource;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDAO resourceDAO;
		
	@Override
	public void addNewOrUpdate(Resource resource) {
		resourceDAO.save(resource);
	}

	@Override
	public Iterable<Resource> addNew(List<Resource> list) {
		return resourceDAO.save(list);
	}

	@Override
	public void remove(Integer id) {
		resourceDAO.delete(id);
	}

	@Override
	public Iterable<Resource> findAll() {
		return resourceDAO.findAll();
	}

}
