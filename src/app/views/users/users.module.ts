import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ShareModule} from'../share/share.module';
import { UsersRoutingModule } from './users-routing.module';

@NgModule({
  declarations: [],
  imports: [CommonModule,ShareModule, UsersRoutingModule]
})
export class UsersModule {}
