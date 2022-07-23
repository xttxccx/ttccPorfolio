import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trabajo } from '../model/trabajo';

@Injectable({
  providedIn: 'root'
})
export class STrabajoService {

  traURL = 'https://ttcc-portfolio-back.herokuapp.com/trabajo/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Trabajo[]>{
    return this.httpClient.get<Trabajo[]>(this.traURL + 'lista');
  }

  public detail(id: number): Observable<Trabajo>{
    return this.httpClient.get<Trabajo>(this.traURL + `detail/${id}`)
  }

  public save(trabajo: Trabajo): Observable<any>{
    return this.httpClient.post<any>(this.traURL + 'create', trabajo);
  }

  public update(id: number, trabajo: Trabajo): Observable<any>{
    return this.httpClient.put<any>(this.traURL + `update/${id}`, trabajo);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.traURL + `delete/${id}`);
  }
}
