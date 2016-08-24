package edu.mum.ea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.domain.Project;
import edu.mum.ea.domain.Resource;
import edu.mum.ea.domain.Task;
import edu.mum.ea.json.JProject;
import edu.mum.ea.service.ProjectService;
import edu.mum.ea.service.ResourceService;
import edu.mum.ea.service.TaskService;
import edu.mum.ea.service.UserService;
import edu.mum.ea.utils.Helper;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	private static final Logger LOG = Logger.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("projects", projectService.findAll());
		return "projectList";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		projectService.remove(id);
		
		return new ResponseEntity<>("projects", HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@Transactional
	public ResponseEntity<String> add(@RequestBody Project project) {
		LOG.info(">>>>>>>>>> calling add project >>>>>>>>>>>>>>>>>");
		//processing data
		
		if(project.getTasks() != null) {
			List<Task> saveTasks = new ArrayList<Task>();
			
			//save resource
			for(Task task : project.getTasks()) {
				if(!CollectionUtils.isEmpty(task.getResources())) {
					Iterable<Resource> resources = resourceService.addNew(task.getResources());
					task.setResources(Helper.makeList(resources));
				}
				
				// save task
				saveTasks.add(taskService.addNewOrUpdate(task));
			}
			
			// add save task to project
			for(Task task : saveTasks) {
				project.addTask(task);
			}
			
		}
		
		//save project
		projectService.addNew(project);
		
		return new ResponseEntity<>("projects", HttpStatus.OK);
	}
}
