import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  returnUrl: string;
  login: string;
  password: string;

  constructor(private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {

  }

  loginUser() {
    this.loading = true;
    this.router.navigate(['admin']);
    console.log('Login');
  }
}
