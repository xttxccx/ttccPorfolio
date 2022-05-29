import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { perfil } from '../model/perfil.model';

@Injectable({
  providedIn: 'root'
})

export class PerfilService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getPerfil(): Observable<perfil>{
    return this.http.get<perfil>(`${this.apiServerUrl}/perfil/traer/29`);
  }

  public editarPerfil(perfil: perfil): Observable<perfil>{
    return this.http.put<perfil>(`${this.apiServerUrl}/editar`, perfil);

  }
}
