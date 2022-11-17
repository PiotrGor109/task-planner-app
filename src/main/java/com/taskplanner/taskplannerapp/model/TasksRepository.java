package com.taskplanner.taskplannerapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {


    Page<Tasks> findAll(Pageable page);
    Optional<Tasks> findById(Integer id);
    Tasks save(Tasks entity);
    void delete(Tasks entity);
    boolean existsById(int id);
}
