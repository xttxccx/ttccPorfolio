import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { docencia } from '../model/docencia.model';

@Injectable({
  providedIn: 'root'
})

export class DocenciaService {
  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http: HttpClient) { }

  public getDocencia(): Observable<docencia> {
    return this.http.get<docencia>(`${this.apiServerUrl}/docencia/ver/37`)

  }
  public editarDocencia (docencia:docencia): Observable<docencia>{
    return this.http.put<docencia>(`${this.apiServerUrl}/docencia/editar`, docencia);

  }
}
