import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Perfil } from '../model/perfil';

@Injectable({
  providedIn: 'root'
})
export class SPerfilService {

  perfilURL = 'http://localhost:8080/perfil/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Perfil[]>{
    return this.httpClient.get<Perfil[]>(this.perfilURL + 'lista');
  }

  public detail(id: number): Observable<Perfil>{
    return this.httpClient.get<Perfil>(this.perfilURL + `detail/${id}`)
  }

 /* public save(perfil: Perfil): Observable<any>{
    return this.httpClient.post<any>(this.perfilURL + 'create', perfil);
  }*/

  public update(id: number, perfil: Perfil): Observable<any>{
    return this.httpClient.put<any>(this.perfilURL + `update/${id}`, perfil);
  }

}
