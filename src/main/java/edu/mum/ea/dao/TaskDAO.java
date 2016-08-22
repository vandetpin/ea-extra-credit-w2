package edu.mum.ea.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.ea.domain.Task;

@Repository
public interface TaskDAO extends CrudRepository<Task, Integer> {

}
