import {Routes, RouterModule} from '@angular/router';


import {AdminComponent} from './admin/index';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './registry/register.component';

const appRoutes: Routes = [
  {path: 'admin', component: AdminComponent},
  {path: 'registry', component: RegisterComponent},
  {path: '', component: LoginComponent},

  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

export const routing = RouterModule.forRoot(appRoutes);
