import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Signuprequest} from '../model/signuprequest.model';
import {RestResponse} from '../model/RestResponse';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(user:Signuprequest): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      role:[user.role],
      password: user.password
    }, httpOptions);
    
  }

  getProfilInfo():Observable<RestResponse> {
    console.log(AUTH_API+'me');
    return this.http.get<RestResponse>(AUTH_API+'me', httpOptions);
  }
}
