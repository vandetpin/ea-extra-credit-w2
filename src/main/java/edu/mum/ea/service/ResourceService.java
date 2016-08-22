package edu.mum.ea.service;

import java.util.List;

import edu.mum.ea.domain.Resource;

public interface ResourceService {
	void addNewOrUpdate(Resource resource);
	Iterable<Resource> addNew(List<Resource> list);
	void remove(Integer id);
	Iterable<Resource> findAll();
}
