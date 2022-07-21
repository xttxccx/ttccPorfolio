import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trabajo } from 'src/app/model/trabajo';
import { STrabajoService } from 'src/app/service/s-trabajo.service';

@Component({
  selector: 'app-edit-trabajo',
  templateUrl: './edit-trabajo.component.html',
  styleUrls: ['./edit-trabajo.component.css']
})
export class EditTrabajoComponent implements OnInit {

  tra: Trabajo = null;

  constructor(
    private sTrabajo: STrabajoService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sTrabajo.detail(id).subscribe(
      data => {
        this.tra = data;
      },
      err => {
        alert('Error al modificar trabajo');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sTrabajo.update(id, this.tra).subscribe(
      data => {
        this.router.navigate(['']);
      },
      err => {
        alert('Error al modificar trabajo');
        this.router.navigate(['']);
      }
    );
  }

}
