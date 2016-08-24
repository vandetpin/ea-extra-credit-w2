package edu.mum.ea.service.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ea.domain.Administrator;
import edu.mum.ea.domain.Project;
import edu.mum.ea.service.UserService;

@Aspect
@Service
public class ProjectServiceAspect {
	
	@Autowired
	private UserService userService;
	
	private static final Logger LOG = Logger.getLogger(ProjectServiceAspect.class);
	
	@Transactional
	@Around("execution(* edu.mum.ea.service.ProjectServiceImpl.addNew(..))") 
	public Project addNewProject(ProceedingJoinPoint call) throws Throwable {
		LOG.info(">> Add new project advice");
		Project project = (Project)call.proceed();
		
		//TODO get user login from security context
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Administrator admin = (Administrator)userService.findOne(1);
		admin.addProject(project);
		userService.addNewOrUpdate(admin);
		
		return project;
	}
}
