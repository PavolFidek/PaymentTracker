import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {MovieService} from './movie.service';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MoviePlayerComponent} from './movie-player/movie-player.component';

@NgModule({
  declarations: [
    AppComponent,
    MoviePlayerComponent,
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [MovieService],
  bootstrap: [AppComponent],
  entryComponents:[MoviePlayerComponent]
})
export class AppModule { }
