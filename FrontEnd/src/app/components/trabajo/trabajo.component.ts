import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Trabajo } from 'src/app/model/trabajo.model';
import { TrabajoService } from 'src/app/service/trabajo.service';

@Component({
  selector: 'app-trabajo',
  templateUrl: './trabajo.component.html',
  styleUrls: ['./trabajo.component.css']
})
export class TrabajoComponent implements OnInit {

  public trabajos:Trabajo[]=[];

  constructor(private trabajoService: TrabajoService) { }

  ngOnInit(): void {
    this.getTrabajos();
  }

  public getTrabajos(): void{
    this.trabajoService.getTrabajo().subscribe({
      next:(Response: Trabajo[]) => {
        this.trabajos=Response;
      }, 
      error:(error:HttpErrorResponse)=> {
        alert(error.message);
      }
    })
  }

}
