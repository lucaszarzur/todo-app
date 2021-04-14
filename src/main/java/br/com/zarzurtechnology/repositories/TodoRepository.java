package br.com.zarzurtechnology.repositories;

import br.com.zarzurtechnology.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
