import {Injectable, OnInit} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';

import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {User} from '../../user/User';

@Injectable()
export class AdminService{
  urlRest = 'http://localhost:8080/admin';
  user  = JSON.parse(localStorage.getItem('user'));
  userName = this.user.login;
  userPass = this.user.password;
  constructor(private http: Http) {
  };

  getAllUser(): Observable<User[]> {

    const headers = new Headers();


    headers.append('Authorization', 'Basic ' + btoa(  this.userName+ ':' + this.userPass));

    return this.http.get(this.urlRest + '/user', {
      headers: headers
    })
      .map((res: Response) => res.json());
  }

  deleteUser(id): Observable<User> {
    console.log(id);
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(  this.userName+ ':' + this.userPass));
    return this.http.delete(this.urlRest + '/user/' + id, {
      headers: headers
    })
      .map((res: Response) => res.json());
  }

  getUserById(id: any): Observable<User> {
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(  this.userName+ ':' + this.userPass));
    return this.http.get(this.urlRest + '/user/' + id,
      {
        headers: headers
      })
      .map((res: Response) => res.json());
  }

  updateUser(user: User): Observable<User> {
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(  this.userName+ ':' + this.userPass));
    return this.http.put(this.urlRest + '/user',user,{
      headers: headers
    } )
      .map((res: Response) => res.json());
  }
}
