import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import {User} from '../user/User';
import {UserServer} from '../user-server/user-server';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html'
})
export class RegisterComponent {
  model: any = {};

  constructor(public  userService: UserServer,
              private router: Router) {
  }

  register(form: NgForm) {
    const user = new User(null, form.value.firstName, form.value.lastName, form.value.login, form.value.email,
      form.value.password);
    this.userService.addNewUser(user);
    console.log(user);
    console.log(form);
    this.router.navigate(['admin']);

  }
}
