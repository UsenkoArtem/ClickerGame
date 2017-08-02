import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';

import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {User} from '../user/User';

@Injectable()
export class UserServer {
  urlRest = 'http://localhost:8080/user';

  constructor(private http: Http) {
  };

  getAllUser(): Observable<User[]> {
    return this.http.get(this.urlRest)
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
}
