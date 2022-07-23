import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Docencia } from '../model/docencia';

@Injectable({
  providedIn: 'root'
})
export class SDocenciaService {

  docURL = 'https://ttcc-portfolio-back.herokuapp.com/docencia/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Docencia[]>{
    return this.httpClient.get<Docencia[]>(this.docURL + 'lista');
  }

  public detail(id: number): Observable<Docencia>{
    return this.httpClient.get<Docencia>(this.docURL + `detail/${id}`)
  }

  public save(docencia: Docencia): Observable<any>{
    return this.httpClient.post<any>(this.docURL + 'create', docencia);
  }

  public update(id: number, docencia: Docencia): Observable<any>{
    return this.httpClient.put<any>(this.docURL + `update/${id}`, docencia);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.docURL + `delete/${id}`);
  }
}
