package com.hcl.Phase3Final.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name= "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Integer id;
	
	
	@Column(name = "task_name")
	@Size(min = 5, message = "*Your task name must have at least 5 characters")
	@NotEmpty(message = "*Please provide a task name")
	private String name;
	
	
	@Column(name = "start_date")
	@NotEmpty(message = "*Please enter a start date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	
	@Column(name = "end_date")
	@NotEmpty(message = "*Please enter an end date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	
	@Column(name = "severity")
	@NotEmpty(message = "*Please provide a severity")
	private String severity;
	
	
	@Column(name = "description")
	@Size(min = 10, max = 100, message = "*The description cannot be shorter than 10 or greater than 100 characters.")
	@NotEmpty(message = "*Please enter a description of the task")
	private String description;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;


	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}
	

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Task [taskid=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", severity=" + severity + ", description=" + description + ", user=" + user + "]";
	}
	
		
	
}
