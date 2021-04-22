import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/services/todo.service';
import { Todo } from 'src/app/models/todo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-finished',
  templateUrl: './finished.component.html',
  styleUrls: ['./finished.component.css']
})
export class FinishedComponent implements OnInit {

  todoListFinished: Todo[] = [];

  constructor(private service: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((response) => {
      response.forEach(todo => {
        if(todo.finished) {
          this.todoListFinished.push(todo);
        }
      })
    })
  }

  return(): void {
    this.router.navigate(['']);
  }

}
