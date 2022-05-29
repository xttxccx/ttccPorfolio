import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Docencia } from '../model/docencia.model';

@Injectable({
  providedIn: 'root'
})

export class DocenciaService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getDocencia():Observable<Docencia[]> {
    return this.http.get<Docencia[]>(`${this.apiServerUrl}/docencia/lista`);
  }

  public addDocencia(docencia:Docencia):Observable<Docencia> {
    return this.http.post<Docencia>(`${this.apiServerUrl}/docencia/nueva`, docencia);
  }

  public editDocencia(docencia:Docencia): Observable<Docencia> {
    return this.http.put<Docencia>(`${this.apiServerUrl}/docencia/editar`, docencia);
  }

  public deleteDocencia(idDoc:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/docencia/borrar/${idDoc}`);
  }
}
