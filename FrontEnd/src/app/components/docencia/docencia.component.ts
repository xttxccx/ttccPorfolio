import { Component, OnInit } from '@angular/core';
import { Docencia } from 'src/app/model/docencia';
import { SDocenciaService } from 'src/app/service/s-docencia.service';
import { TokenService } from 'src/app/service/token.service';

declare var window: any;

@Component({
  selector: 'app-docencia',
  templateUrl: './docencia.component.html',
  styleUrls: ['./docencia.component.css']
})

export class DocenciaComponent implements OnInit {
  
  doc: Docencia[] = [];
  nombreD : string = '';
  fechaID : number = null; 
  fechaFD : number = null; 
  descripcionD : string = ''; 
  imgD : string = '';
  formModalNewD: any;

  constructor(
    private sDocencia: SDocenciaService, 
    private tokenService: TokenService
    ) { }

  isLogged = false;

  ngOnInit(): void {

    this.cargarDocencia();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    this.formModalNewD = new window.bootstrap.Modal(
      document.getElementById('newModalD')
    );
  }

  cargarDocencia(): void {
    this.sDocencia.lista().subscribe(data => {this.doc = data;})
  }

  openFormModalNewD() {
    this.formModalNewD.show();
  }

  reloadCurrentPage() {
    window.location.reload();
  }

  onCreate(): void {
    const doc = new Docencia(this.nombreD, this.fechaID, this.fechaFD, this.descripcionD, this.imgD);
    this.sDocencia.save(doc).subscribe(
      data => {
        alert("Trabajo docente añadido");
        this.formModalNewD.hide();
      }, err => {
        alert("Falló");
        this.formModalNewD.hide();
      })
  }

   

  delete(id?: number){
    if(id != undefined){
      this.sDocencia.delete(id).subscribe(
        data => {
          this.cargarDocencia();
        }, err => {
          alert("No se pudo borrar el trabajo docente");
        }
        )
    }
  }

}
