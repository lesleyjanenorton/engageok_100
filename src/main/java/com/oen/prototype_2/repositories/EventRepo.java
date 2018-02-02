package com.oen.prototype_2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oen.prototype_2.models.Event;

public interface EventRepo extends CrudRepository<Event, Long> {
	public List<Event> findAll();
	public Event save(Event e);
	public Event findOne(Long id);
}