package br.com.zarzurtechnology.repositories;

import br.com.zarzurtechnology.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("SELECT todo FROM Todo todo WHERE todo.finished = false ORDER BY todo.dateToFinish")
    List<Todo> findAllOpened();

    @Query("SELECT todo FROM Todo todo WHERE todo.finished = true ORDER BY todo.dateToFinish")
    List<Todo> findAllClosed();
}
