package com.practice1.ToDo.repository;

import com.practice1.ToDo.model.ToDo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    Optional<ToDo> findByTaskId(Long taskId);
}
