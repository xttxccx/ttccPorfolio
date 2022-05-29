import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyectos } from '../model/proyectos.model';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  private apiServerUrl=environment.apiBaseUrl;  

  constructor(private http:HttpClient) { }

  public getProyectos():Observable<Proyectos[]> {
    return this.http.get<Proyectos[]>(`${this.apiServerUrl}/proyecto/lista`);
  }

  public addProyecto(proyecto:Proyectos):Observable<Proyectos> {
    return this.http.post<Proyectos>(`${this.apiServerUrl}/proyecto/nuevo`, proyecto);
  }

  public editProyecto(proyecto:Proyectos): Observable<Proyectos> {
    return this.http.put<Proyectos>(`${this.apiServerUrl}/proyecto/editar`, proyecto);
  }

  public deleteProyecto(idProy:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/proyecto/borrar/${idProy}`);
  }
}
