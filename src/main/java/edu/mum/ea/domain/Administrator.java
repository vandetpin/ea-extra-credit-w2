package edu.mum.ea.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Admin")
public class Administrator extends User {
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
	private List<Project> projects = new ArrayList<Project>();
	
	public Administrator(){}
	
	public Administrator(Integer id, String name) {
		super.setId(id);
		super.setName(name);
	}

	public List<Project> getProjects(){
		return Collections.unmodifiableList(projects);
	}
	
	public void addProject(Project project) {
		projects.add(project);
		project.setAdministrator(this);
	}
	
	public void removeProject(Project project) {
		project.setAdministrator(null);
		projects.remove(project);
	}
}
