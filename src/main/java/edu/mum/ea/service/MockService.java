package edu.mum.ea.service;

import java.text.ParseException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.domain.Administrator;
import edu.mum.ea.domain.Project;
import edu.mum.ea.domain.Resource;
import edu.mum.ea.domain.Status;
import edu.mum.ea.domain.Task;
import edu.mum.ea.domain.User;
import edu.mum.ea.utils.Formatter;
import edu.mum.ea.utils.Helper;


@Service
public class MockService {
	
	private static final Logger LOG = Logger.getLogger(MockService.class);
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired 
	private UserService userService;
	
	@PostConstruct
	public void initData() throws ParseException {
		LOG.info(">>>>>>>>>>>>>> Start mocking data >>>>>>>>>>>>>>>>");
		initProject(); 
		LOG.info(">>>>>>>>>>>>>> Done mocking project >>>>>>>>>>>>>");
	}
	
	@Transactional
	public Iterable<Resource> createResources() {
		Resource resource1 = new Resource(null, "Software Engineer");
		Resource resource2 = new Resource(null, "Product Analysis");
		Resource resource3 = new Resource(null, "English Teacher");
		Resource resource4 = new Resource(null, "Driver");
		Resource resource5 = new Resource(null, "English Translator");
		Resource resource6 = new Resource(null, "Sale Specialist");
		
		return resourceService.addNew(Arrays.asList(resource1, resource2, resource3, resource4, resource5, resource6));
	}
	
	@Transactional
	public Iterable<Task> createTask(){
		Iterable<Resource> resources = createResources();
		
		Task task1 = new Task();
		task1.setStatus(Status.NEW);
		task1.setResources(Helper.makeList(resources));
		task1.setTimeFrame(10);
		task1.setDescription("Do survey");
		
		Task task2 = new Task();
		task2.setStatus(Status.NEW);
		task2.setResources(Helper.makeList(resources));
		task2.setTimeFrame(10);
		task2.setDescription("Analysis");
		
		return taskService.addNew(Arrays.asList(task1, task2));
	}
	
	@Transactional
	public User createAdmin() {
		
		Administrator admin = new Administrator();
		admin.setName("Dara mony");
		
		return userService.addNewOrUpdate(admin);
	}
	
	@Transactional
	public Project createProject1() throws ParseException{
		Iterable<Task> tasks = createTask();
		
		Project project = new Project();
		project.setImageUrl("http://www.mychildsafety.net/image-files/child_safety.jpg");
		project.setDescription("Child Safety");
		project.setStatus(Status.INPROGRESS);
		project.setExpectedStartDate(Formatter.simpleDateFormat.parse("2016-09-10"));
		project.setExpectedEndDate(Formatter.simpleDateFormat.parse("2016-10-10"));
		project.setLocation("Farefield");
		
		// add tasks
		for(Task task : tasks) {
			project.addTask(task);
		}
		
		return projectService.newOrUpdate(project);
	}
	
	@Transactional
	public Project createProject2() throws ParseException{
		Iterable<Task> tasks = createTask();
		
		Project project = new Project();
		project.setImageUrl("https://image.freepik.com/free-vector/green-city_23-2147516165.jpg");
		project.setDescription("Green City");
		project.setStatus(Status.PENDDING);
		project.setExpectedStartDate(Formatter.simpleDateFormat.parse("2016-12-10"));
		project.setExpectedEndDate(Formatter.simpleDateFormat.parse("2017-10-10"));
		project.setLocation("Cambodia");
		
		// add tasks
		for(Task task : tasks) {
			project.addTask(task);
		}
		
		return projectService.newOrUpdate(project);
	}
	
	@Transactional
	public void initProject() throws ParseException {
		Project project1 = createProject1();
		Project project2 = createProject2();
		
		Administrator admin = (Administrator)createAdmin();
		admin.addProject(project1);
		admin.addProject(project2);
		
		userService.addNewOrUpdate(admin);
	}
}
