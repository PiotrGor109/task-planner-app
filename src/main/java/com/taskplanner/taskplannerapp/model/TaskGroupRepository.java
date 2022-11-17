package com.taskplanner.taskplannerapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, Integer> {

    Page<TaskGroup> findAll(Pageable pageable);
    Optional<TaskGroup> findById(Integer id);
    TaskGroup save(TaskGroup entity);
    void delete(TaskGroup entity);

}
