import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../../user/User';
import {Injectable} from '@angular/core';

@Injectable()
export class LoginAndRegService {
  private urlRest = 'http://localhost:8080/entrance';

  constructor(private http: Http) {
  }

  addNewUser(user: User): Observable<User> {
    return this.http.post(this.urlRest + '/registration', user)
      .map((res: Response) => res.json());
  }

  getEmail(value: any): Observable<string> {
    return this.http.get(this.urlRest + '/isRegUser?column=email&param=' + value)
      .map((res: Response) => res.json());
  }

  getLogin(value: any): Observable<string> {
    debugger;
    return this.http.get(this.urlRest + '/isRegUser?column=login&param=' + value)
      .map((res: Response) => {

        return res.json();
      });
  }

  getSigIn(user: User) {
    const userDTO = {login: '', password: ''};
    userDTO.login = user.login;
    userDTO.password = user.password;
    return this.http.post(this.urlRest + '/signIn', userDTO)
      .map((res: Response) => res.json());
  }
}
