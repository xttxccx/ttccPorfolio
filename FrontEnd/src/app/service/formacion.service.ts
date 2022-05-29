import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Formacion } from '../model/formacion.model';

@Injectable({
  providedIn: 'root'
})
export class FormacionService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getFormacion():Observable<Formacion[]> {
    return this.http.get<Formacion[]>(`${this.apiServerUrl}/formacion/lista`);
  }

  public addFormacion(formacion:Formacion):Observable<Formacion> {
    return this.http.post<Formacion>(`${this.apiServerUrl}/formacion/nueva`, formacion);
  }

  public editFormacion(formacion:Formacion): Observable<Formacion> {
    return this.http.put<Formacion>(`${this.apiServerUrl}/formacion/editar`, formacion);
  }

  public deleteFormacion(idForm:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/formacion/borrar/${idForm}`);
  }
}
