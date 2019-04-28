import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User, LoginData, RegisterData } from './project.model';

@Injectable()
export class ProjectService {
  private userUrl = `api/user`;

  constructor(
    private httpClient: HttpClient
  ) { }

  login(loginData: LoginData): Observable<boolean> {
    return this.httpClient.post<any>(`/userLogin`, loginData);
  }

  registerUser(registerData: RegisterData): Observable<boolean> {
    return null;
  }

  /*
    public listMovies(page: number = 0, size: number = 10): Observable<User> {
      return this.httpClient.get<User>('http://localhost:8080/getUser');
    }
    public searchMovies(searchTerm: string, page: number = 0, size: number = 10): Observable<Movie[]> {
      let params = new HttpParams()
      params.set('page', page.toString());
      params.set('size', size.toString());
      return this.httpClient.get<Movie[]>(`http://localhost:8080/search/${searchTerm}`, {params: params});
    }
  */
}
