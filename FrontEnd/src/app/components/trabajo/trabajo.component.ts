import { Component, OnInit } from '@angular/core';
import { Trabajo } from 'src/app/model/trabajo';
import { STrabajoService } from 'src/app/service/s-trabajo.service';
import { TokenService } from 'src/app/service/token.service';

declare var window: any;

@Component({
  selector: 'app-trabajo',
  templateUrl: './trabajo.component.html',
  styleUrls: ['./trabajo.component.css']
})

export class TrabajoComponent implements OnInit {

  tra: Trabajo[] = [];
  nombreT : string = '';
  fechaIT : number = null;
  fechaFT : number = null;
  descripcionT : string = '';
  imgT : string = '';
  formModalNewT: any;

  constructor(
    private sTrabajo: STrabajoService, 
    private tokenService: TokenService
    ) { }

  isLogged = false;

  ngOnInit(): void {

    this.cargarTrabajo();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.formModalNewT = new window.bootstrap.Modal(
      document.getElementById('newModalT')
    );
  }

  cargarTrabajo(): void {
    this.sTrabajo.lista().subscribe(data => {this.tra = data;})
  }

  openFormModalNewT() {
    this.formModalNewT.show();
  }

  reloadCurrentPage() {
    window.location.reload();
  }

  onCreate(): void {
    const tra = new Trabajo(this.nombreT, this.fechaIT, this.fechaFT, this.descripcionT, this.imgT);
    this.sTrabajo.save(tra).subscribe(
      data => {
        alert("Trabajo añadido");
        this.formModalNewT.hide();
      }, err => {
        alert("Falló");
        this.formModalNewT.hide();
      })
  }

  delete(id?: number){
    if(id != undefined){
      this.sTrabajo.delete(id).subscribe(
        data => {
          this.cargarTrabajo();
        }, err => {
          alert("No se pudo borrar el trabajo");
        }
        )
    }
  }

}
