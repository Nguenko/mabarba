import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path:'user', loadChildren: ()=>import('./user/user.module').then(m=>m.UserModule)
},
{
   path:'admin', loadChildren: ()=>import('./admin/admin.module').then(m=>m.AdminModule)
},
{
   path:'moderator', loadChildren:()=>import('./moderator/moderator.module').then(m=>m.ModeratorModule)
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
