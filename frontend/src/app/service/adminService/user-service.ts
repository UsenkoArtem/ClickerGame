import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';

import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {User} from '../../user/User';
import {map} from 'rxjs/operator/map';

@Injectable()
export class AdminService {
  urlRest = 'http://localhost:8080/admin';

  constructor(private http: Http) {
  };

  getAllUser(): Observable<User[]> {
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa('roma' + ':' + '1111111'));
    return this.http.get(this.urlRest + '/user', {
      headers: headers
    })
      .map((res: Response) => res.json());
  }

  deleteUser(id): Observable<User> {
    console.log(id);
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa('roma' + ':' + '1111111'));
    return this.http.delete(this.urlRest + '/user/' + id,{
      headers: headers
    })
      .map((res: Response) => res.json());
  }

  getUserById(id: any): Observable<User> {
    return this.http.get(this.urlRest + '/user/' + id)
      .map((res: Response) => res.json());
  }

  updateUser(user: User): Observable<User> {
    return this.http.put(this.urlRest + '/user', user)
      .map((res: Response) => res.json());
  }
}
