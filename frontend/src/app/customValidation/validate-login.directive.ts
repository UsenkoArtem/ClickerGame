import {AbstractControl, NG_VALIDATORS, Validator} from '@angular/forms';
import {Attribute, Directive, forwardRef} from '@angular/core';
import {AdminService} from '../service/adminService/user-service';
import {LoginAndRegService} from "../service/logAndRegService/login-and-reg-service";

@Directive({
  selector: '[validateLogin][formControlName],[validateLogin] \n' +
  '    [formControl],[validateLogin][ngModel]',
  providers: [
    {provide: NG_VALIDATORS, useExisting: forwardRef(() => ValidateLoginDirective), multi: true}
  ]
})
export class ValidateLoginDirective implements Validator {
  private bool: any;
  constructor(public loginAndRegService: LoginAndRegService) {
  }
  validate(c: AbstractControl): { [p: string]: any } {
    const login = c;
    if (login.value === null || login.value === undefined) {
      return null;
    }
    if (login.value.length < 4) return null;
    this.loginAndRegService.getLogin(login.value).subscribe(data => {
      debugger;
      this.bool = data;
      if (this.bool === true) {
        login.setErrors({'validateLogin': data});
      } else {
        return null;
      }
    });
    return null;
  }
}
