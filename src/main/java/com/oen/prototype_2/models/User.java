package com.oen.prototype_2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Size(min=1, message="Email cannot be blank")
    private String email;
	
	@Size(min=1, message="First name cannot be blank")
    private String first_name;
	
	@Size(min=1, message="Last name cannot be blank")
    private String last_name;
	
	@Size(min=1, message="Username cannot be blank")
	private String username;
	
	@Size(min=5, message="Password must be greater than 5 characters")
    private String password;
	
	@Transient
    private String passwordConfirmation;
	
	@Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "orgs_users",
		joinColumns = @JoinColumn(name = "org_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<Organization> organizations;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="users")
    private List<Event> events;
    
    private Integer numberOfOrgs;
    
    private Integer numberOfEvents;
    
    private Boolean isFlagged;
    
    private Integer zipcode;
    
    private Boolean isSearching;
    //
    
    public User() {}

    //			GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Integer getNumberOfOrgs() {
		return numberOfOrgs;
	}

	public void setNumberOfOrgs(Integer numberOfOrgs) {
		this.numberOfOrgs = numberOfOrgs;
	}

	public Integer getNumberOfEvents() {
		return numberOfEvents;
	}

	public void setNumberOfEvents(Integer numberOfEvents) {
		this.numberOfEvents = numberOfEvents;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	public Boolean getIsFlagged() {
		return isFlagged;
	}

	public void setIsFlagged(Boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Boolean getIsSearching() {
		return isSearching;
	}

	public void setIsSearching(Boolean isSearching) {
		this.isSearching = isSearching;
	}
	
	
    
}