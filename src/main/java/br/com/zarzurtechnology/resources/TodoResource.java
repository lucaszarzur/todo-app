package br.com.zarzurtechnology.resources;

import br.com.zarzurtechnology.domain.Todo;
import br.com.zarzurtechnology.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo todo = todoService.findById(id);

        return ResponseEntity.ok().body(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll() {
        List<Todo> todoList = todoService.findAll();

        return ResponseEntity.ok().body(todoList);
    }

    @GetMapping(value = "/opened")
    public ResponseEntity<List<Todo>> listOpened() {
        List<Todo> todoList = todoService.findAllOpened();

        return ResponseEntity.ok().body(todoList);
    }


    @GetMapping(value = "/closed")
    public ResponseEntity<List<Todo>> listClosed() {
        List<Todo> todoList = todoService.findAllClosed();

        return ResponseEntity.ok().body(todoList);
    }

}
