import {Routes, RouterModule} from '@angular/router';


import {AdminComponent} from './admin/index';
import {LoginComponent} from './login/login.component';

const appRoutes: Routes = [
  {path: 'admin', component: AdminComponent},
  {path: '', component: LoginComponent},

  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

export const routing = RouterModule.forRoot(appRoutes);
