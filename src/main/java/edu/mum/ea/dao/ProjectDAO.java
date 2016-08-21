package edu.mum.ea.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.domain.Resource;

@Repository
public interface ProjectDAO extends CrudRepository<Resource, Integer> {

}
