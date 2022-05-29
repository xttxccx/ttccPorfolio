import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Trabajo } from '../model/trabajo.model';

@Injectable({
  providedIn: 'root'
})
export class TrabajoService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getTrabajo():Observable<Trabajo[]> {
    return this.http.get<Trabajo[]>(`${this.apiServerUrl}/trabajo/lista`);
  }

  public addTrabajo(trabajo:Trabajo):Observable<Trabajo> {
    return this.http.post<Trabajo>(`${this.apiServerUrl}/trabajo/nuevo`, trabajo);
  }

  public editTrabajo(trabajo:Trabajo): Observable<Trabajo> {
    return this.http.put<Trabajo>(`${this.apiServerUrl}/trabajo/editar`, trabajo);
  }

  public deleteTrabajo(idTra:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/trabajo/borrar/${idTra}`);
  }




}
