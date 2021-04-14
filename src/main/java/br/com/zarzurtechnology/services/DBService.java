package br.com.zarzurtechnology.services;

import br.com.zarzurtechnology.domain.Todo;
import br.com.zarzurtechnology.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instantiateDatabase() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2", LocalDateTime.parse("14/04/2021 19:00", formatter), false);
        Todo t2 = new Todo(null, "Estudar", "Estudar Angular 11", LocalDateTime.parse("15/05/2021 19:00", formatter), false);
        Todo t3 = new Todo(null, "Viajar", "Viajar para a casa da familia no interior", LocalDateTime.parse("28/05/2021 19:00", formatter), false);
        Todo t4 = new Todo(null, "Dieta", "Não esquecer de fazer sempre a dieta regrada", LocalDateTime.parse("18/04/2021 19:00", formatter), true);

        todoRepository.saveAll(Arrays.asList(t1));
    }
}
