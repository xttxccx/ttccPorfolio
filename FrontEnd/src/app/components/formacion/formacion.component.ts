import { Component, OnInit } from '@angular/core';
import { Formacion } from 'src/app/model/formacion';
import { SFormacionService } from 'src/app/service/s-formacion.service';
import { TokenService } from 'src/app/service/token.service';

declare var window: any;

@Component({
  selector: 'app-formacion',
  templateUrl: './formacion.component.html',
  styleUrls: ['./formacion.component.css']
})
export class FormacionComponent implements OnInit {

  forma: Formacion[] = [];
  nombreF: string = '';
  fechaIF : number = null;
  fechaFF : number = null;
  descripcionF : string = '';
  imgF : string = null;
  formModalNewF: any;

  constructor(
    private sFormacion: SFormacionService, 
    private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    
    this.cargarFormacion();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.formModalNewF = new window.bootstrap.Modal(
      document.getElementById('newModalF')
    );
  }

  cargarFormacion(): void {
    this.sFormacion.lista().subscribe(data => {this.forma = data;})
  }

  openFormModalNewF() {
    this.formModalNewF.show();
  }

  reloadCurrentPage() {
    window.location.reload();
  }

  onCreate(): void {
    const forma = new Formacion(this.nombreF, this.fechaIF, this.fechaFF, this.descripcionF, this.imgF);
    this.sFormacion.save(forma).subscribe(
      data => {
        alert("Formación añadida");
        this.formModalNewF.hide();
      }, err => {
        alert("Falló");
        this.formModalNewF.hide();
      })
  }

  delete(id?: number){
    if(id != undefined){
      this.sFormacion.delete(id).subscribe(
        data => {
          this.cargarFormacion();
        }, err => {
          alert("No se pudo borrar la formación");
        }
        )
    }
  }


  
}
