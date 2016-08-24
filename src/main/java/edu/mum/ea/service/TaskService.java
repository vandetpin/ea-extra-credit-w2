package edu.mum.ea.service;

import edu.mum.ea.domain.Task;

public interface TaskService {
	Task addNewOrUpdate(Task task);
	Iterable<Task> addNew(Iterable<Task> tasks);
	void remove(Integer id);
}
