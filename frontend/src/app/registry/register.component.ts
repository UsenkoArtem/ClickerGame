import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import {User} from '../user/User';
import {AdminService} from '../service/adminService/user-service';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginAndRegService} from "../service/logAndRegService/login-and-reg-service";

@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html'
})
export class RegisterComponent {
  model = {firstName: '', lastName: '', login: '' , email: '', password: '', confirmPassword: ''};
  constructor(public  logAndRegService: LoginAndRegService,
              private router: Router) {
  }

  register() {
    console.log(this.model);
    const user = new User(null, this.model.firstName, this.model.lastName, this.model.login, this.model.email,
      this.model.password);
    this.logAndRegService.addNewUser(user).subscribe(data => {
      debugger
      console.log(user);
      this.router.navigate(['game']);
      location.reload();
    });
  }
}
