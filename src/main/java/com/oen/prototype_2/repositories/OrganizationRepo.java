package com.oen.prototype_2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oen.prototype_2.models.Organization;

public interface OrganizationRepo extends CrudRepository<Organization, Long> {
	public List<Organization> findAll();
	public Organization save(Organization o);
	public Organization findOne(Long id);
}
