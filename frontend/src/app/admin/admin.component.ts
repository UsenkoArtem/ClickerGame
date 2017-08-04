import {Component, OnInit} from '@angular/core';
import {UserService} from '../user-server/user-service';
import {User} from '../user/User';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [UserService]
})
export class AdminComponent implements OnInit {
  userList: User[] = [];
  public newFirstName: string;
  public newLastName: string;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.getAllUser().subscribe(data => this.userList = data);
  };

  deleteUser(id) {
    console.log('Delete');
    this.userService.deleteUser(id).subscribe();
    const userLs: User[] = [];
    this.userList.filter(item => {
      if (item.id !== id) {
        userLs.push(item);
      }
    });
    this.userList = userLs;
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

  updateUser(id) {
    console.log(id);
  }
}

