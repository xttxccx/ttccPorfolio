import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Perfil } from 'src/app/model/perfil';
import { SPerfilService } from 'src/app/service/s-perfil.service';

@Component({
  selector: 'app-edit-perfil',
  templateUrl: './edit-perfil.component.html',
  styleUrls: ['./edit-perfil.component.css']
})
export class EditPerfilComponent implements OnInit {

  perfil: Perfil = null;

  constructor(
    private sPerfil: SPerfilService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPerfil.detail(id).subscribe(
      data => {
        this.perfil = data;
      },
      err => {
        alert('Error al modificar perfil');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sPerfil.update(id, this.perfil).subscribe(
      data => {
        this.router.navigate(['']);
      },
      err => {
        alert('Error al modificar perfil');
        this.router.navigate(['']);
      }
    );
  }

}
