package com.taskplanner.taskplannerapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


    Page<Task> findAll(Pageable page);
    Optional<Task> findById(Integer id);
    Task save(Task entity);
    void delete(Task entity);
    boolean existsById(int id);



//
//    @Query(value = "SELECT * FROM TASKS WHERE task_group_id <> 0", nativeQuery=true)
//    List<Task> findALLTasksWithNotEmptyGroup();




}
