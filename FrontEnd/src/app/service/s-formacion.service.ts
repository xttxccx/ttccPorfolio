import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formacion } from '../model/formacion';


@Injectable({
  providedIn: 'root'
})
export class SFormacionService {

  formaURL = 'https://ttcc-portfolio-back.herokuapp.com/formacion/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Formacion[]>{
    return this.httpClient.get<Formacion[]>(this.formaURL + 'lista');
  }

  public detail(id: number): Observable<Formacion>{
    return this.httpClient.get<Formacion>(this.formaURL + `detail/${id}`)
  }

  public save(formacion: Formacion): Observable<any>{
    return this.httpClient.post<any>(this.formaURL + 'create', formacion);
  }

  public update(id: number, formacion: Formacion): Observable<any>{
    return this.httpClient.put<any>(this.formaURL + `update/${id}`, formacion);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.formaURL + `delete/${id}`);
  }
}
