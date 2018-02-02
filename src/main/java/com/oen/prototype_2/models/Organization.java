package com.oen.prototype_2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

// should have image associated on organization page

@Entity
@Table(name="organizations")
public class Organization {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="Name cannot be blank")
	private String name;
	
	@Size(min=1, message="Description must be longer. Add a little extra!")
	private String description;
	
	private Long local_admin;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "orgs_users",
			joinColumns = @JoinColumn(name = "org_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;
	
	private Integer numberOfActivists;
	
	private String location;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "orgs_tags",
			joinColumns = @JoinColumn(name = "org_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private List<Issuetag> issuetags;
	
	@OneToMany(mappedBy="organization", fetch=FetchType.LAZY)
	private List<Event> events;
	
	//
	
	public Organization() {}

	// 			GETTERS AND SETTERS
	
	
	
	
	public Long getId() {
		return id;
	}

	public List<Issuetag> getIssuetags() {
		return issuetags;
	}

	public void setIssuetags(List<Issuetag> issuetags) {
		this.issuetags = issuetags;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLocal_admin() {
		return local_admin;
	}

	public void setLocal_admin(Long local_admin) {
		this.local_admin = local_admin;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getNumberOfActivists() {
		return numberOfActivists;
	}

	public void setNumberOfActivists(Integer numberOfActivists) {
		this.numberOfActivists = numberOfActivists;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
