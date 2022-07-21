import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Docencia } from 'src/app/model/docencia';
import { SDocenciaService } from 'src/app/service/s-docencia.service';

@Component({
  selector: 'app-edit-docencia',
  templateUrl: './edit-docencia.component.html',
  styleUrls: ['./edit-docencia.component.css']
})
export class EditDocenciaComponent implements OnInit {

  doc: Docencia = null;

  constructor(
    private sDocencia: SDocenciaService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sDocencia.detail(id).subscribe(
      data => {
        this.doc = data;
      },
      err => {
        alert('Error al modificar trabajo docente');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sDocencia.update(id, this.doc).subscribe(
      data => {
        this.router.navigate(['']);
      },
      err => {
        alert('Error al modificar trabajo docente');
        this.router.navigate(['']);
      }
    );
  }

}
