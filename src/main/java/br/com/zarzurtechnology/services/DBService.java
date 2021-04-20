package br.com.zarzurtechnology.services;

import br.com.zarzurtechnology.domain.Todo;
import br.com.zarzurtechnology.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instantiateDatabase() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2", sdf.parse("14/04/2021"), false);
        Todo t2 = new Todo(null, "Estudar", "Estudar Angular 11", sdf.parse("15/05/2021"), false);
        Todo t3 = new Todo(null, "Viajar", "Viajar para a casa da familia no interior", sdf.parse("28/05/2021"), false);
        Todo t4 = new Todo(null, "Dieta", "Não esquecer de fazer sempre a dieta regrada", sdf.parse("18/04/2021"), true);

        todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
