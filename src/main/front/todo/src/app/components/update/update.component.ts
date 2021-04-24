import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  todo: Todo = {
    title: '',
    description: '',
    dateToFinish: new Date(),
    finished: false
  }

  constructor(private service: TodoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.todo.id).subscribe((response) => {
      this.todo = response;
      this.formatDateToUpdate();
    })
  }

  update(): void {
    this.formatDate();
    this.service.update(this.todo).subscribe((response) => {
      this.service.message("Informações atualizadas com sucesso!");
      this.router.navigate(['']);
    }, error => {
      this.service.message("Falha ao atualizar To-do!");
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

  formatDateToUpdate(): void {
    let date = new Date(this.todo.dateToFinish.split('/').reverse().join('-'))
    this.todo.dateToFinish = new Date(`${date.getMonth() + 1}/${date.getDate() + 1}/${date.getFullYear()}`)
  }

}
