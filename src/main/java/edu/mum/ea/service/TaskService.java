package edu.mum.ea.service;

import edu.mum.ea.domain.Task;

public interface TaskService {
	void addNewOrUpdate(Task task);
	Iterable<Task> addNew(Iterable<Task> tasks);
	void remove(Integer id);
}
