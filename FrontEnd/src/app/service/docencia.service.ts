import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { docencia } from '../model/docencia.model';

@Injectable({
  providedIn: 'root'
})

export class DocenciaService {
  URL = 'http://localhost:8080/docencia/';

  constructor(private http: HttpClient) { }

  public getDocencia(): Observable<docencia> {
    return this.http.get<docencia>(this.URL+'traer/1')

  }
}
