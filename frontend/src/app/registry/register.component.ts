import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import {User} from '../user/User';
import {UserService} from '../user-server/user-service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html'
})
export class RegisterComponent {
  model = {firstName: '', lastName: '', login: '' , email: '', password: '', confirmPassword: ''};
  constructor(public  userService: UserService,
              private router: Router) {
  }

  register() {
    debugger;
    console.log(this.model);
    const user = new User(null, this.model.firstName, this.model.lastName, this.model.login, this.model.email,
      this.model.password);
    this.userService.addNewUser(user).subscribe(data => {
      debugger
      console.log(user);
      console.log(this.model);
      this.router.navigate(['game']);
    });
  }
}
