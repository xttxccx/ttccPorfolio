import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skills } from '../model/skills.model';

@Injectable({
  providedIn: 'root'
})

export class SkillsService {

  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getSkill():Observable<Skills[]> {
    return this.http.get<Skills[]>(`${this.apiServerUrl}/skill/lista`);
  }

  public addTrabajo(skill:Skills):Observable<Skills> {
    return this.http.post<Skills>(`${this.apiServerUrl}/skill/nueva`, skill);
  }

  public editSkills(skill:Skills): Observable<Skills> {
    return this.http.put<Skills>(`${this.apiServerUrl}/skill/editar`, skill);
  }

  public deleteSkills(idSkill:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/skill/borrar/${idSkill}`);
  }

}
