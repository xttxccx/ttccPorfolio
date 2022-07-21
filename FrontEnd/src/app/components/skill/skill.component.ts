import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SSkillService } from 'src/app/service/s-skill.service';
import { TokenService } from 'src/app/service/token.service';

declare var window: any;

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {
  
  skills: Skill[] = [];
  nombreS: string = '';
  porcentajeS : number = null;
  formModalNewS: any;

  constructor(
    private sSkill: SSkillService, 
    private tokenService: TokenService, 
    ) { }
  
  isLogged = false;

  ngOnInit(): void {

    this.cargarSkill();

    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }

    this.formModalNewS = new window.bootstrap.Modal(
      document.getElementById('newModalS')
    );
  }

  cargarSkill(): void {
    this.sSkill.lista().subscribe(data => {this.skills = data})
  }

 openFormModalNewS() {
    this.formModalNewS.show();
  }

  /* openFormModal(mode:String, skill?: Skill):void {
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target','newModal');
    }else if(mode==='editModal'){
      button.setAttribute('data-target','editModal');

    }else if(mode==='deleteModal'){
      button.setAttribute('data-target','deleteModal');
      this.delete(skill.id);
    }

  }*/

  reloadCurrentPage() {
    window.location.reload();
   }

  onCreate(): void {
    const skill = new Skill(this.nombreS, this.porcentajeS);
    this.sSkill.save(skill).subscribe(
      data => {
        alert("Habilidad añadida");
        this.formModalNewS.hide();
      }, err => {
        alert("Falló");
        this.formModalNewS.hide();
      })
  }

  delete(id?: number){
    if(id != undefined){
      this.sSkill.delete(id).subscribe(
        data => {
          this.cargarSkill();
        }, err => {
          alert("No se pudeo borrar la habilidad");
        }
      )
    }
  }

}
