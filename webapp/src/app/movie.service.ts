import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Movie} from './movie.model';

@Injectable()
export class MovieService {

  constructor(private httpClient: HttpClient) {
  }

  public listMovies(page: number = 0, size: number = 10): Observable<Movie[]> {
    let params = new HttpParams()
    params.set('page', page.toString());
    params.set('size', size.toString());
    return this.httpClient.get<Movie[]>('http://localhost:8080/movies', {params: params});
  }

  public searchMovies(searchTerm: string, page: number = 0, size: number = 10): Observable<Movie[]> {
    let params = new HttpParams()
    params.set('page', page.toString());
    params.set('size', size.toString());
    return this.httpClient.get<Movie[]>(`http://localhost:8080/search/${searchTerm}`, {params: params});
  }

}
