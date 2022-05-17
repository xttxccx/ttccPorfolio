import { Component, OnInit } from '@angular/core';
import { docencia } from 'src/app/model/docencia.model';
import { DocenciaService } from 'src/app/service/docencia.service';

@Component({
  selector: 'app-docencia',
  templateUrl: './docencia.component.html',
  styleUrls: ['./docencia.component.css']
})
export class DocenciaComponent implements OnInit {
  docencia: docencia = new docencia("","","","");

  constructor(public docenciaService: DocenciaService) { }

  ngOnInit(): void {
    this.docenciaService.getDocencia().subscribe(data => {this.docencia = data})
  }

}
