package ntt.aug.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ntt.aug.docker.entity.ToDoItem;


public interface ToDoRepository extends JpaRepository<ToDoItem, Integer> {
	
}
