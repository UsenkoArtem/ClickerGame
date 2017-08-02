import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {ModalModule} from 'ngx-bootstrap';
import {AppComponent} from './app.component';
import {UserServer} from './user-server/user-server';
import {BsDropdownModule} from 'ngx-bootstrap';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()

  ],
  providers: [UserServer],
  bootstrap: [AppComponent]
})
export class AppModule {
}
