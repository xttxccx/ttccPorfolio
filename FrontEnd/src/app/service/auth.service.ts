import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDto } from '../model/jwt-dto';
import { LoginUsuarix } from '../model/login-usuarix';
import { NuevxUsuarix } from '../model/nuevx-usuarix';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authURL = 'http://localhost:8080/auth/';

  constructor(private httpClient: HttpClient) { }

  public nuevx(nuevxUsuarix: NuevxUsuarix): Observable<any>{
    return this.httpClient.post<any>(this.authURL + 'nuevx', nuevxUsuarix);
  }

  public login(loginUsuarix: LoginUsuarix): Observable<JwtDto>{
    return this.httpClient.post<JwtDto>(this.authURL + 'login', loginUsuarix);
  }
}
