package edu.mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.dao.TaskDAO;
import edu.mum.ea.domain.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO taskDAO;
		
	@Override
	public void addNewOrUpdate(Task task) {
		taskDAO.save(task);
	}

	@Override
	public void remove(Integer id) {
		taskDAO.delete(id);
	}

	@Override
	public Iterable<Task> addNew(Iterable<Task> tasks) {
		return taskDAO.save(tasks);
	}

}
