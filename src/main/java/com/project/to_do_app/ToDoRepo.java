package com.project.to_do_app;

import com.project.to_do_app.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDo, Long> {

}
