package edu.mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.dao.ProjectDAO;
import edu.mum.ea.domain.Project;
import edu.mum.ea.domain.Status;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public Project addNew(Project project) {
		return projectDAO.save(project);
	}
	
	@Override
	public Project newOrUpdate(Project project) {
		return projectDAO.save(project);
	}

	@Override
	public void remove(Integer id) {
		projectDAO.delete(id);
	}

	@Override
	public Project findOne(Integer id) {
		return projectDAO.findOne(id);
	}

	@Override
	public Iterable<Project> findByStatus(Status status) {
		return projectDAO.findByStatus(status);
	}

	@Override
	public Iterable<Project> findByKeywordAndLocation(String keyword, String location) {
		return projectDAO.findByDescriptionContainingAndLocationContaining(keyword, location);
	}
	
	@Override
	public Iterable<Project> findAll() {
		return projectDAO.findAll();
	}
}
