package edu.mum.ea.service;


import edu.mum.ea.domain.Project;
import edu.mum.ea.domain.Status;

public interface ProjectService {
	Project newOrUpdate(Project project);
	Project addNew(Project project);
	void remove(Integer id);
	Project findOne(Integer id);
	Iterable<Project> findByStatus(Status status);
	Iterable<Project> findByKeywordAndLocation(String keyword, String location);
	Iterable<Project> findAll();
}
