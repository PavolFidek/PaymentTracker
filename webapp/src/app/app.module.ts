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
import { DataListModule } from 'primeng/datalist';
import { ChartModule } from 'primeng/chart';
import { TableDataComponent } from './dashboard/table-data/table-data.component';
import { DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';

import { CreatePaymentModalComponent } from './shared/create-payment-modal/create-payment-modal.component';
import { UpdatePaymentModalComponent } from './shared/update-payment-modal/update-payment-modal.component';

const appRoutes: Routes = [
  { path: 'register', component: RegisterUserComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'userLogin', component: LoginUserComponent },
  { path: '**', redirectTo: '/userLogin' },
  { path: '', redirectTo: 'userLogin', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    RegisterUserComponent,
    LoginUserComponent,
    DashboardComponent,
    TableDataComponent,
    CreatePaymentModalComponent,
    UpdatePaymentModalComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes, { useHash: true }),
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
    PasswordModule,
    DataListModule,
    ChartModule,
    DropdownModule,
    CalendarModule
  ],
  providers: [ ProjectService ],
  bootstrap: [ AppComponent ],
  entryComponents: [
    CreatePaymentModalComponent,
    UpdatePaymentModalComponent
  ]
})
export class AppModule { }
