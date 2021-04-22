import { TodoService } from './../../services/todo.service';
import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/todo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {

  todoList: Todo[] = [];
  todoListFinished: Todo[] = [];
  closed = 0;

  constructor(private service: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      response.forEach(todo => {
        if(todo.finished) {
          this.todoListFinished.push(todo);
        } else {
          this.todoList.push(todo);
        }
      })
      this.closed = this.todoListFinished.length
    })
  }

  finish(item: Todo): void {
    item.finished = true;
    this.service.update(item).subscribe((response) => {
      this.service.message("Task finalizada com sucesso!");
      this.todoList = this.todoList.filter(todo => todo.id !== item.id);
      this.closed++;
    });
  }

  delete(id: any): void {
    this.service.delete(id).subscribe((response) => {
      if(response === null) {
        this.service.message('Task deletada com sucesso!');
        this.todoList = this.todoList.filter(todo => todo.id !== id);
      }
    })
  }

  navigateToFinished(): void {
    this.router.navigate(['/finalizados']);
  }

}
