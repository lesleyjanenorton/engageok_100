package com.oen.prototype_2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="issuetags")
public class Issuetag {
	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "orgs_tags",
			joinColumns = @JoinColumn(name = "tag_id"),
			inverseJoinColumns = @JoinColumn(name = "org_id")
	)
	private List<Organization> organizations;
	
	//
	
	public Issuetag() {}

	// 				GETTERS AND SETTERS 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}
	
	
	
}
