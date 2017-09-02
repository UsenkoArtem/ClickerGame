import {Component, OnInit} from '@angular/core';
import {AdminService} from '../service/adminService/user-service';
import {User} from '../user/User';
import {NgFor} from '@angular/common';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [AdminService]
})
export class AdminComponent implements OnInit {
  model: any = {};
  showUserList: User[] = [];
  allUsers: User[] = [];
  private userId: number;
  private newUser: User;
  private sort = {idSort: 1, firstNameSort: 1, lastNameSort: 1, loginSort: 1, emailSort: 1};
  private search = {
    searchById: '',
    searchByFirstName: '',
    searchByLastName: '',
    searchByLogin: '',
    searchByEmail: ''
  };
  constructor(private userService: AdminService) {
  }

  ngOnInit() {
    this.userService.getAllUser().subscribe(data => {
      this.allUsers = data;
      console.log(data);
      this.showUserList = data;
    });
    // this.userService.getAllUser().subscribe(data => {
    //   this.allUsers = data;
    //   this.showUserList = data;
    // });
  }

  public pageChanged(event: any): void {
    console.log('Page changed to: ' + event.page);
    console.log('Number items per page: ' + event.itemsPerPage);
  }


  sortById() {
    this.sort.idSort *= -1;
    this.showUserList.sort((a, b) => {

      if (a.id > b.id) {
        return this.sort.idSort;
      } else {
        if (a.id < b.id) {
          return -1 * this.sort.idSort;
        } else {
          return 0;
        }
      }
    });
  }

  sortByFirstName() {
    this.sort.firstNameSort *= -1;
    console.log(this.sort.firstNameSort);
    this.showUserList.sort((a, b) => {
        const number = (a.firstName.toLowerCase()).localeCompare((b.firstName.toLowerCase()));
        if (number === 1) {
          return this.sort.firstNameSort;
        } else {
          if (number === -1) {
            return -1 * this.sort.firstNameSort;
          } else {
            return 0;
          }
        }
      }
    );
    console.log(this.showUserList);
  }

  sortByLastName() {
    this.sort.lastNameSort *= -1;
    console.log(this.sort.lastNameSort);
    this.showUserList.sort((a, b) => {
        const number = (a.lastName.toLowerCase()).localeCompare((b.lastName.toLowerCase()));
        if (number === 1) {
          return this.sort.lastNameSort;
        } else {
          if (number === -1) {
            return -1 * this.sort.lastNameSort;
          } else {
            return 0;
          }
        }
      }
    );
  }

  sortByLogin() {
    this.sort.loginSort *= -1;
    console.log(this.sort.loginSort);
    this.showUserList.sort((a, b) => {
        const number = (a.login.toLowerCase()).localeCompare((b.login.toLowerCase()));
        if (number === 1) {
          return this.sort.loginSort;
        } else {
          if (number === -1) {
            return -1 * this.sort.loginSort;
          } else {
            return 0;
          }
        }
      }
    );
  }

  sortByEmail() {
    this.sort.emailSort *= -1;
    console.log(this.sort.emailSort);
    this.showUserList.sort((a, b) => {
        const number = (a.email.toLowerCase()).localeCompare((b.email.toLowerCase()));
        if (number === 1) {
          return this.sort.emailSort;
        } else {
          if (number === -1) {
            return -1 * this.sort.emailSort;
          } else {
            return 0;
          }
        }
      }
    );

  }

  deleteUser(id) {
    this.userService.deleteUser(id).subscribe(data => {
        this.showUserList = this.showUserList.filter(item => item.id !== data.id);
      }
    );

  }

  update(id) {
    window.alert(id);
    this.userService.getUserById(id).subscribe(data => {
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
    const user = new User(this.userId, this.model.firstName, this.model.lastName, this.model.login, this.model.email, '');
    console.log("AdminComponent user: ");
    console.log(user);
    this.userService.updateUser(user).subscribe(data => {
      this.newUser = data;
      this.showUserList.forEach(data => {
        if (data.id === this.userId) {
          data.lastName = this.newUser.lastName;
          data.firstName = this.newUser.firstName;
        }
      });
    });
  }

  searchUser(event: Event) {
    this.showUserList = this.allUsers.filter((data) => {
      return ((data.id.toString()).includes(this.search.searchById) &&
        (data.firstName.includes(this.search.searchByFirstName)) &&
        (data.lastName.includes(this.search.searchByLastName)) &&
        (data.login.includes(this.search.searchByLogin)) &&
        (data.email.includes(this.search.searchByEmail)));
    });
  }

  logout() {
    debugger;
    const parse = JSON.parse(localStorage.getItem('user'));
    parse.login = '';
    parse.password = '';
    parse.firstName = '';
    parse.lastName = '';
    parse.email = '';
    localStorage.setItem('user', JSON.stringify(parse));
    console.log(parse);
  }
}

