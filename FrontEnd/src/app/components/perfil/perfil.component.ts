import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/model/perfil';
import { perfil } from 'src/app/model/perfil.model';
import { SPerfilService } from 'src/app/service/s-perfil.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})

export class PerfilComponent implements OnInit {
  
  perfil: Perfil[] = [];

  constructor(private sPerfil: SPerfilService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    
    this.cargarPerfil();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarPerfil(): void {
    this.sPerfil.lista().subscribe(data => {this.perfil = data;})    
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
