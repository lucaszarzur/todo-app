package br.com.zarzurtechnology.services;

import br.com.zarzurtechnology.domain.Todo;
import br.com.zarzurtechnology.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo findById(Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);

        return todo.orElse(null);
    }

    public List<Todo> findAll() {
        List<Todo> todoList = todoRepository.findAll();

        return todoList;
    }

    public List<Todo> findAllOpened() {
        List<Todo> todoList = todoRepository.findAllOpened();

        return todoList;
    }

    public List<Todo> findAllClosed() {
        List<Todo> todoList = todoRepository.findAllClosed();

        return todoList;
    }
}
