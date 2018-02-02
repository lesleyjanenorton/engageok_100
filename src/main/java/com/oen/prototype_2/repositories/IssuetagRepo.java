package com.oen.prototype_2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oen.prototype_2.models.Issuetag;

public interface IssuetagRepo extends CrudRepository<Issuetag, Long>{
	public List<Issuetag> findAll();
	public Issuetag save(Issuetag it);
	public Issuetag findOne(Long id);
}
