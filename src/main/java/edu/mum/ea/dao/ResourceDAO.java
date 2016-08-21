package edu.mum.ea.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.domain.Project;

@Repository
public interface ResourceDAO extends CrudRepository<Project, Integer> {

}
