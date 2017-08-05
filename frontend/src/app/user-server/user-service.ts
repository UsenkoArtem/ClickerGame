import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';

import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {User} from '../user/User';
import {map} from 'rxjs/operator/map';

@Injectable()
export class UserService {
  urlRest = 'http://localhost:8080/user';

  constructor(private http: Http) {
  };

  getAllUser(): Observable<User[]> {
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa('roma' + ':' + '1111111'));

    return this.http.get(this.urlRest, {
      headers: headers
    })
      .map((res: Response) => res.json());
  }

  deleteUser(id): Observable<User> {
    console.log(id);
    return this.http.delete(this.urlRest + '/' + id)
      .map((res: Response) => res.json());
  }

  addNewUser(user: User): Observable<User> {
    return this.http.post(this.urlRest, user)
      .map((res: Response) => res.json());
  }

  getEmail(value: any): Observable<string> {
    return this.http.get(this.urlRest + '/isRegUser?column=email&param=' + value)
      .map((res: Response) => res.json());
  }

  getLogin(value: any): Observable<string> {
    return this.http.get(this.urlRest + '/isRegUser?column=login&param=' + value)
      .map((res: Response) => res.json());
  }

  getSigIn(user: User) {
    return this.http.post(this.urlRest + '/login', user)
      .map((res: Response) => res.json());
  }

  getUserById(id: any): Observable<User> {
    return this.http.get(this.urlRest + '/' + id)
      .map((res: Response) => res.json());
  }

  updateUser(user: User): Observable<User> {
    return this.http.put(this.urlRest, user)
      .map((res: Response) => res.json());
  }
}
