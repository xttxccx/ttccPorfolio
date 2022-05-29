import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Formacion } from 'src/app/model/formacion.model';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-formacion',
  templateUrl: './formacion.component.html',
  styleUrls: ['./formacion.component.css']
})
export class FormacionComponent implements OnInit {

  public formaciones: Formacion[] = [];

  constructor(public formacionService: FormacionService) { }

  ngOnInit(): void {
    this.getFormaciones();
  }

  public getFormaciones(): void {
    this.formacionService.getFormacion().subscribe({
      next:(Response: Formacion[]) => {
        this.formaciones=Response;
      }, 
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
}
