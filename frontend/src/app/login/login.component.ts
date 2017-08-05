import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {AdminService} from '../service/adminService/user-service';
import {User} from '../user/User';
import {LoginAndRegService} from "../service/logAndRegService/login-and-reg-service";
import {error} from "selenium-webdriver";

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html'
})

export class LoginComponent {
  private bool: any;
  loading = true;
  model = {login: '', password: ''};

  constructor(private router: Router,
              private logAndRegService: LoginAndRegService) {
  }

  loginUser() {
    const user = new User(null, '', '', this.model.login, '', this.model.password);
    console.log(user);
    this.logAndRegService.getSigIn(user).subscribe(
      data => {
        this.router.navigate(['game']);
      },
      error => {
        this.loading = false;
      }
    );
    console.log('Login');
  }

  register() {
    this.router.navigate(['/home/registry']);
  }
}
