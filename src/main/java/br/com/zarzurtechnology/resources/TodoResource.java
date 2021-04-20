package br.com.zarzurtechnology.resources;

import br.com.zarzurtechnology.domain.Todo;
import br.com.zarzurtechnology.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
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

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        todo = todoService.create(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
        Todo newTodo = todoService.update(id, todo);

        return ResponseEntity.ok().body(newTodo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        todoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
