package com.taskplanner.taskplannerapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, Integer>
{


    Page<TaskGroup> findAll(Pageable page);
    Optional<TaskGroup> findById(Integer id);
    TaskGroup save(TaskGroup entity);
    void delete(TaskGroup entity);
    boolean existsById(int id);





}










