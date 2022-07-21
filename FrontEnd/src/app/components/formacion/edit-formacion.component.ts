import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Formacion } from 'src/app/model/formacion';
import { SFormacionService } from 'src/app/service/s-formacion.service';

@Component({
  selector: 'app-edit-formacion',
  templateUrl: './edit-formacion.component.html',
  styleUrls: ['./edit-formacion.component.css']
})
export class EditFormacionComponent implements OnInit {

  forma: Formacion = null;

  constructor(
    private sFormacion: SFormacionService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sFormacion.detail(id).subscribe(
      data => {
        this.forma = data;
      },
      err => {
        alert('Error al modificar la formación');
        this.router.navigate(['']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sFormacion.update(id, this.forma).subscribe(
      data => {
        this.router.navigate(['']);
      },
      err => {
        alert('Error al modificar la formación');
        this.router.navigate(['']);
      }
    );
  }


}
