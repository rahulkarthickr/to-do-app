package com.project.to_do_app;
import com.project.to_do_app.entities.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepo toDoRepo;
    public ToDo createToDo(ToDo todo) {
        return toDoRepo.save(todo);
    }
    public ToDo getToDoId(long id) {
        return toDoRepo.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found with id " + id));
    }
    public List<ToDo> getAllToDos() {
        return toDoRepo.findAll();
    }
    public ToDo updateToDo(ToDo todo) {
        return toDoRepo.save(todo);
    }
    public void deleteToDo(Long id) {
        toDoRepo.delete(getToDoId(id));
    }
//    public void deleteToDos(ToDo todo) {
//        toDoRepo.delete(todo);
//    }
}
