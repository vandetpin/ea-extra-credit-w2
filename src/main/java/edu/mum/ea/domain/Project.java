package edu.mum.ea.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Project {
	@Id @GeneratedValue
	private Integer id;
	
	private String description;
	
	private String imageUrl;
	
	@Temporal(TemporalType.DATE)
	private Date expectedStartDate;
	
	@Temporal(TemporalType.DATE)
	private Date expectedEndDate;
	
	@OneToMany(mappedBy="project", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Task> tasks = new ArrayList<Task>();
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
	
	@ManyToOne(cascade={CascadeType.MERGE})
	private User administrator;
	
	@Enumerated
	private Status status;
	
	private String location;
	
	public Project(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpectedStartDate() {
		return expectedStartDate;
	}

	public void setExpectedStartDate(Date expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public Date getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public List<Task> getTasks() {
		return Collections.unmodifiableList(tasks);
	}

	public void addTask(Task task) {
		tasks.add(task);
		task.setProject(this);
	}
	
	public void removeTask(Task task) {
		task.setProject(null);
		tasks.remove(task);
	}
	
	public List<Beneficiary> getBeneficiaries() {
		return Collections.unmodifiableList(beneficiaries);
	}

	public void addBeneficiary(Beneficiary beneficiary) {
		beneficiaries.add(beneficiary);
		beneficiary.setProject(this);
	}
	
	public void removeBeneficiary(Beneficiary beneficiary) {
		beneficiary.setProject(null);
		beneficiaries.remove(beneficiary);
	}

	public User getAdministrator() {
		return administrator;
	}

	public void setAdministrator(User administrator) {
		this.administrator = administrator;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
