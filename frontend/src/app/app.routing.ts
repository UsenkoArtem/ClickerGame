import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './registry/register.component';
import {AdminComponent} from './admin/admin.component';
import {GameComponent} from './game/game.component';

const appRoutes: Routes = [
  {path: 'admin', component: AdminComponent},
  {path: 'home/registry', component: RegisterComponent},
  {path: 'home/login', component: LoginComponent},
  {path: 'game', component: GameComponent},
  // otherwise redirect to home
  {path: '**', redirectTo: 'home/login'}
];

export const routing = RouterModule.forRoot(appRoutes);
