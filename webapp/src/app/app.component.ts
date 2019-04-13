import {Component, OnInit} from '@angular/core';
import {Movie} from './movie.model';
import {MovieService} from './movie.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MoviePlayerComponent} from './movie-player/movie-player.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  searchTerm: string;

  movies: Movie[];

  constructor(private movieService: MovieService, private modalService: NgbModal) {

  }

  ngOnInit(): void {
    this.movieService.listMovies().subscribe((movies) => this.movies = movies)
  }

  onSearch() {
    this.movieService.searchMovies(this.searchTerm).subscribe((movies) => this.movies = movies);
  }

  playMovie(movie: Movie) {
    const modalRef = this.modalService.open(MoviePlayerComponent,  {  size: 'lg' });
    modalRef.componentInstance.movie = movie;
  }

}
