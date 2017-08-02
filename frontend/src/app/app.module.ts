import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {ModalModule} from 'ngx-bootstrap';
import {AdminComponent} from './admin/admin.component';
import {UserServer} from './user-server/user-server';
import {BsDropdownModule} from 'ngx-bootstrap';
import {routing} from './app.routing';
import {LoginComponent} from './login/login.component';
import {RouterModule} from '@angular/router';
import {AppComponent} from './app.component';

@NgModule({
  declarations: [
    AdminComponent ,
    LoginComponent ,
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    routing
  ],
  providers: [UserServer],
  bootstrap: [AppComponent]
})
export class AppModule {
}
