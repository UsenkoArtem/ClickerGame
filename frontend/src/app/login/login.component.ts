import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {UserService} from '../user-server/user-service';
import {User} from '../user/User';

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html'
})

export class LoginComponent {
  private bool: any;
  loading = true;
  model = {login: '', password: ''};

  constructor(private router: Router,
              private userService: UserService) {
  }

  loginUser() {
    const user = new User(null, '', '', this.model.login, '', this.model.password);
    console.log(user);
    this.userService.getSigIn(user).subscribe(data => {
        this.bool = data;
        if (this.bool !== true) {
          this.loading = false;
          return;
        } else {
          this.router.navigate(['game']);
        }
      }
    );
    console.log('Login');
  }

  register() {
    this.router.navigate(['/home/registry']);
  }
}
