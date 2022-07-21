import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { SProyectoService } from 'src/app/service/s-proyecto.service';
import { TokenService } from 'src/app/service/token.service';

declare var window: any; 

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {

  proy: Proyecto[] = [];
  nombreP : string = '';
  anioP : number = null;
  descripcionP : string = '';
  imgP : string = '';
  linkP : string = '';
  formModalNewP: any;

  constructor(
    private sProyecto: SProyectoService, 
    private tokenService: TokenService
    ) { }

  isLogged = false;

  ngOnInit(): void {

    this.cargarProyecto();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.formModalNewP = new window.bootstrap.Modal(
      document.getElementById('newModalP')
    );
  }

  cargarProyecto(): void {
    this.sProyecto.lista().subscribe(data => {this.proy = data;})    
  }

  openFormModalNewP() {
    this.formModalNewP.show();
  }

  reloadCurrentPage() {
    window.location.reload();
   }

   onCreate(): void {
    const proyecto = new Proyecto(this.nombreP, this.anioP, this.descripcionP, this.imgP, this.linkP);
    this.sProyecto.save(proyecto).subscribe(
      data => {
        alert("Proyecto añadido");
        this.formModalNewP.hide();
      }, err => {
        alert("Falló");
        this.formModalNewP.hide();
      })
  }

  delete(id?: number){
    if(id != undefined){
      this.sProyecto.delete(id).subscribe(
        data => {
          this.cargarProyecto();
        }, err => {
          alert("No se pudo borrar el proyecto");
        }
        )
    }
  }

}
