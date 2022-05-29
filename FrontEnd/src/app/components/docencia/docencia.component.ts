import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Docencia } from 'src/app/model/docencia.model';
import { DocenciaService } from 'src/app/service/docencia.service';

@Component({
  selector: 'app-docencia',
  templateUrl: './docencia.component.html',
  styleUrls: ['./docencia.component.css']
})

export class DocenciaComponent implements OnInit {
  
  public docencias:Docencia[]=[];

  constructor(public docenciaService: DocenciaService) { }

  ngOnInit(): void {
    this.getDocencias();
  }

  public getDocencias(): void {
    this.docenciaService.getDocencia().subscribe({
      next:(Response: Docencia[]) => {
        this.docencias=Response;
      }, 
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

}
