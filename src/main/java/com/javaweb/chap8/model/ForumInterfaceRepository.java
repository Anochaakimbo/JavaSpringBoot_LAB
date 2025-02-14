package com.javaweb.chap8.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ForumInterfaceRepository extends CrudRepository<Forum, Long>{
	
	Forum findById(int id);
}
