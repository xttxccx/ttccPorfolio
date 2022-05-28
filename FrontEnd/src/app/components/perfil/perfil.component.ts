import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { perfil } from 'src/app/model/perfil.model';
import { PerfilService } from 'src/app/service/perfil.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})

export class PerfilComponent implements OnInit {
  
  perfil: perfil = new perfil("","","","","","");

  constructor(public perfilService: PerfilService) { }

  ngOnInit(): void {
    this.perfilService.getPerfil().subscribe(data => {this.perfil = data});
  }

}




/* export class PerfilComponent implements OnInit {
  
  public perfil: perfil | undefined;
  public editPerfil: perfil | undefined;

  constructor(private perfilService: PerfilService) { }

  ngOnInit(): void {
    this.getPerfil();
  }

  public getPerfil():void {
    this.perfilService.getPerfil().subscribe({
      next: (response: perfil) => {
        this.perfil=response;
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
      }
    })

  }

} */
