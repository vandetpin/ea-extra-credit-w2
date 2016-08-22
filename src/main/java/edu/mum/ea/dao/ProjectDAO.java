package edu.mum.ea.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.domain.Project;
import edu.mum.ea.domain.Status;

@Repository
public interface ProjectDAO extends CrudRepository<Project, Integer> {

	Iterable<Project> findByDescriptionContainingAndLocationContaining(String keyword, String location);

	Iterable<Project> findByStatus(Status status);

}
