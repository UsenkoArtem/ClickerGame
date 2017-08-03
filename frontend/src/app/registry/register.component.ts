import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html'
})
export class RegisterComponent {
  model: any = {};

  register(form: NgForm) {
    console.log(form.value);
    const reg = form.value;
    console.log(reg.lastName);
    alert('username already used');
  }
}
