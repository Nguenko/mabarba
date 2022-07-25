import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AboutComponent} from "./about/about.component";
import {CourseComponent} from "./course/course.component";
import {CourseResolver} from "./services/course.resolver";
import {CreateCourseComponent} from './create-course/create-course.component';
import {DragDropComponent} from './drag-drop/drag-drop.component';
import {TreeDemoComponent} from './tree-demo/tree-demo.component';
import {VirtualScrollingComponent} from './virtual-scrolling/virtual-scrolling.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import{BarbersComponent } from './barbers/barbers.component';
import { SalonsComponent } from './salons/salons.component';
import {HairSttyleComponent} from './hair-sttyle/hair-sttyle.component';
import {ManagerBarberComponent} from './manager-barber/manager-barber.component';
import {ReservationComponent} from './reservation/reservation.component';
import {PaymentComponent} from './payment/payment.component';
import {ProfilComponent} from './profil/profil.component';
import { SearchComponent } from './search/search.component';
const routes: Routes = [
    {
        path: "",
        component: HomeComponent

    },
    {
        path: "about",
        component: AboutComponent
    },
    {
      path: "hair",
      component: HairSttyleComponent
    },
    {
        path: 'courses/:id',
        component: CourseComponent,
        resolve: {
            course: CourseResolver
        }
    },
  {
    path: 'add-new-course',
    component: CreateCourseComponent
  },
  {
    path: "drag-drop-example",
    component: DragDropComponent
  },
  {
    path: "tree-demo",
    component: TreeDemoComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "barbers",
    component: BarbersComponent
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "manager-barber",
    component: ManagerBarberComponent
  },
  {
    path: "profil",
    component: ProfilComponent
  },
  {
    path: "search",
    component: SearchComponent
  },
  {
    path: 'virtual-scrolling',
    component: VirtualScrollingComponent
  },
  {
    path: 'reservation',
    component: ReservationComponent
  },
  {
    path: 'payment',
    component: PaymentComponent
  },
  {
    path:'salons',
    component:SalonsComponent 
  },
    {
        path: "**",
        redirectTo: '/'
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
