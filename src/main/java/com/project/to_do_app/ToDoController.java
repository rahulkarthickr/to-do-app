package com.project.to_do_app;

import com.project.to_do_app.entities.ToDo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/to-do")
@Slf4j // Logging
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @PostMapping("/create")
    ResponseEntity<ToDo> createUser(@Valid @RequestBody ToDo todo) {
         // try {
            ToDo createdToDo = toDoService.createToDo(todo);
            return new ResponseEntity<>((createdToDo), HttpStatus.OK);
         // }
         // catch(Exception e) {
        //   return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        //  }
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved data"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<ToDo> getToDoId(@PathVariable long id) {
        try {
            ToDo getToDo = toDoService.getToDoId(id);
            return new ResponseEntity<>((getToDo), HttpStatus.OK);
        }
        catch (Exception e) {
            // log.info("Error");
            // log.warn("Warning");
            // log.error("Error: ", e);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved data"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/page")
    ResponseEntity<Page<ToDo>> getToDoPages(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(toDoService.getAllToDoPages(page, size), HttpStatus.OK);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved data"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/list")
    ResponseEntity<List<ToDo>> getAllToDo() {
        return new ResponseEntity<List<ToDo>>(toDoService.getAllToDos(), HttpStatus.OK);
    }
    @PutMapping("/update")
    ResponseEntity<ToDo> updateUser(@Valid @RequestBody ToDo todo) {
         // try {
            ToDo updatedToDo = toDoService.updateToDo(todo);
            return new ResponseEntity<>((updatedToDo), HttpStatus.OK);
         // } catch (Exception e) {
         //     return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        //    }
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
