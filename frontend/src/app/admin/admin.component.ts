import {Component, OnInit} from '@angular/core';
import {UserService} from '../user-server/user-service';
import {User} from '../user/User';
import {NgFor} from "@angular/common";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [UserService]
})
export class AdminComponent implements OnInit {
  model: any = {};
  userList: User[] = [];
  private userId: number;
  public newFirstName: string;
  public newLastName: string;
  private newUser: User;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.getAllUser().subscribe(data => this.userList = data);
  };

  deleteUser(id) {
    console.log('Delete');
    this.userService.deleteUser(id).subscribe(data => {
        debugger;
        const users: User[] = [];
        this.userList.filter(item => {
          if (item.id !== data.id) {
            users.push(item);
          }
        });
        this.userList = users;
      }
    );

  }

  create() {
    debugger;
    let user = new User(null, this.newFirstName, this.newLastName, '', '', '');
    let newUser = new User(null, '', '', '', '', '');
    this.userService.addNewUser(user).subscribe(data => {
      console.log(data);
      newUser.id = data.id;
      newUser.firstName = data.firstName;
      newUser.lastName = data.lastName;
      user.id = data.id;
      this.userList.push(newUser);
    });
    this.newLastName = '';
    this.newLastName = '';
  }

  update(id) {
    console.log(id);
    this.userService.getUserById(id).subscribe(data => {
      debugger;
      console.log(data);
      this.userId = data.id;
      const firstName = (<HTMLInputElement>document.getElementById('firstName'));
      firstName.setAttribute('placeholder', data.firstName);
      const lastName = (<HTMLInputElement>document.getElementById('lastName'));
      lastName.setAttribute('placeholder', data.lastName);
      const email = (<HTMLInputElement>document.getElementById('email'));
      email.setAttribute('placeholder', data.email);
      const login = (<HTMLInputElement>document.getElementById('login'));
      login.setAttribute('placeholder', data.login);
    });
  }

  updateUser() {
    const user = new User(this.userId, this.model.firstName, this.model.lastName, '', this.model.email, '');
    this.userService.updateUser(user).subscribe(data => {
      this.newUser = data;
      this.userList.forEach(user => {
        if (user.id === this.userId) {
          user.lastName = this.newUser.lastName;
          user.firstName = this.newUser.firstName;
          user.email = this.newUser.email;
        }
      });
    });
  }
}

