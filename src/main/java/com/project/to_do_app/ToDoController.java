package com.project.to_do_app;

import com.project.to_do_app.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/to-do")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @PostMapping("/create")
    ResponseEntity<ToDo> createUser(@RequestBody ToDo todo) {
        try {
            ToDo createdToDo = toDoService.createToDo(todo);
            return new ResponseEntity<>((createdToDo), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/{id}")
//    ResponseEntity<ToDo> getToDoId(@PathVariable long id) {
//        try {
//            ToDo getToDo = toDoService.getToDoId(id);
//            return new ResponseEntity<>((getToDo), HttpStatus.OK);
//        }
//        catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
    @GetMapping("/list")
    ResponseEntity<List<ToDo>> getAllToDo() {
        return new ResponseEntity<List<ToDo>>(toDoService.getAllToDos(), HttpStatus.OK);
    }
    @PutMapping("/update")
    ResponseEntity<ToDo> updateUser(@RequestBody ToDo todo) {
        try {
            ToDo updatedToDo = toDoService.updateToDo(todo);
            return new ResponseEntity<>((updatedToDo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/delete/{id}")
    void DeleteUser(@PathVariable long id) {
        try {
            toDoService.deleteToDo(id);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
