import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {ModalModule} from 'ngx-bootstrap';
import {AdminComponent} from './admin/admin.component';
import {UserService} from './user-server/user-service';
import {BsDropdownModule} from 'ngx-bootstrap';
import {routing} from './app.routing';
import {LoginComponent} from './login/login.component';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {RegisterComponent} from './registry/register.component';
import {EqualsValidatorDirective} from './registry/equals-validator.directive';
import {ValidateEmailDirective} from './registry/validate-email.directive';
import {ValidateLoginDirective} from './registry/validate-login.directive';

@NgModule({
  declarations: [
    AdminComponent ,
    LoginComponent ,
    AppComponent,
    RegisterComponent,
    EqualsValidatorDirective,
    ValidateEmailDirective,
    ValidateLoginDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    routing
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
