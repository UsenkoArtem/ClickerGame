import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {NgForm} from '@angular/forms';
import {UserService} from '../user-server/user-service';
import {User} from '../user/User';


@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
  model: any = {};
  returnUrl: string;
  login: string;
  password: string;
  private bool: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userService: UserService) {
  }

  ngOnInit() {

  }

  loginUser(form: NgForm) {
    const user = new User(null, '', '', form.value.login, '', form.value.password);

    console.log(user);
    this.userService.getSigIn(user).subscribe(data => {
        this.bool = data;
        if (this.bool === true) {
          this.router.navigate(['admin']);
        } else {
            alert('Password or Login incorrect');
            return ;
        }
      }
    );

    console.log('Login');
  }
}
