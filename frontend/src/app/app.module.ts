///<reference path="service/logAndRegService/login-and-reg-service.ts"/>
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {ModalModule, PaginationModule} from 'ngx-bootstrap';
import {AdminComponent} from './admin/admin.component';
import {AdminService} from './service/adminService/user-service';
import {BsDropdownModule} from 'ngx-bootstrap';
import {routing} from './app.routing';
import {LoginComponent} from './login/login.component';
import {AppComponent} from './app.component';
import {RegisterComponent} from './registry/register.component';
import {EqualsValidatorDirective} from './customValidation/equals-validator.directive';
import {ValidateEmailDirective} from './customValidation/validate-email.directive';
import {ValidateLoginDirective} from './customValidation/validate-login.directive';
import {GameComponent} from './game/game.component';
import {LoginAndRegService} from './service/logAndRegService/login-and-reg-service';
import {GameService} from './service/gameService/game-service';

@NgModule({
  declarations: [
    AdminComponent ,
    LoginComponent ,
    AppComponent,
    RegisterComponent,
    GameComponent,
    EqualsValidatorDirective,
    ValidateEmailDirective,
    ValidateLoginDirective
  ],
  imports: [
    PaginationModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    routing
  ],
  providers: [AdminService, LoginAndRegService, GameService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
