import { Todo } from './../../models/todo';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  todo: Todo = {
    title: '',
    description: '',
    dateToFinish: new Date(),
    finished: false
  }

  constructor(private service: TodoService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.formatDate();
    this.service.create(this.todo).subscribe((response) => {
      this.service.message("To-do criado com sucesso!");
      this.router.navigate(['']);
    }, error => {
      this.service.message("Falha ao criar To-do!");
      this.router.navigate(['']);
    })
  }

  cancel(): void {
    this.router.navigate([''])
  }

  formatDate(): void {
    let date = new Date(this.todo.dateToFinish);
    this.todo.dateToFinish = `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()}`
  }

}
