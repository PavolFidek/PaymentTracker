import {Component, Input, OnInit} from '@angular/core';
import {Movie} from '../movie.model';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-movie-player',
  templateUrl: './movie-player.component.html',
  styleUrls: ['./movie-player.component.scss']
})
export class MoviePlayerComponent implements OnInit {

  @Input()
  movie: Movie;
  bucketUrl: string;

  constructor(public activeModal: NgbActiveModal) {

  }

  ngOnInit() {
    this.bucketUrl = environment.bucketUrl;
  }

}
