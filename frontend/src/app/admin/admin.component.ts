import {Component, OnInit} from '@angular/core';
import {AdminService} from '../service/adminService/user-service';
import {User} from '../user/User';
import {NgFor} from "@angular/common";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [AdminService]
})
export class AdminComponent implements OnInit {
  model: any = {};
  userList: User[] = [];
  private userId: number;
  public newFirstName: string;
  public newLastName: string;
  private newUser: User;

  constructor(private userService: AdminService) {
  }

  ngOnInit() {
    this.userService.getAllUser().subscribe(data => this.userList = data);
  };

  deleteUser(id) {
    console.log('Delete');
    this.userService.deleteUser(id).subscribe(data => {

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

  update(id) {
    console.log(id);
    this.userService.getUserById(id).subscribe(data => {

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
      this.userList.forEach(data => {
        if (data.id === this.userId) {
          data.lastName = this.newUser.lastName;
          data.firstName = this.newUser.firstName;
          data.email = this.newUser.email;
        }
      });
    });
  }
}

