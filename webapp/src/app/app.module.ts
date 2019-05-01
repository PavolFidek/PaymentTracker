import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProjectService } from './project.service';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterUserComponent } from './register-user/register-user.component';
import { RouterModule, Routes } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { LoginUserComponent } from './login-user/login-user.component';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

// PrimeNG imports
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { AccordionModule } from 'primeng/accordion';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PasswordModule } from 'primeng/password';

const appRoutes: Routes = [
  { path: 'register', component: RegisterUserComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'userLogin', component: LoginUserComponent },
  { path: '**', redirectTo: '/userLogin' }
];

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponent,
    LoginUserComponent,
    DashboardComponent,
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ButtonModule,
    CardModule,
    InputTextModule,
    ReactiveFormsModule,
    MessagesModule,
    MessageModule,
    AccordionModule,
    PasswordModule
  ],
  providers: [ ProjectService ],
  bootstrap: [ AppComponent ],
  entryComponents: [] // TODO add start component
})
export class AppModule { }
