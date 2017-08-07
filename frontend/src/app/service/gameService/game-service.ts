import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class GameService {
  private parse: any;
  constructor(private http: Http) {
  }

  isAccess(): Observable<boolean> {
    debugger;

    try {
      const item = localStorage.getItem('user');
      this.parse = JSON.parse(item);
    } catch (e) {
      return e;
    }
    console.log((this.parse.login + ':' + this.parse.password));
    const headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.parse.login + ':' + this.parse.password));
    return this.http.get('http://localhost:8080/game', {
      headers: headers
    })
      .map((res: Response) => res.json());
  }
}
