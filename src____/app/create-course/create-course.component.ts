import {Component} from '@angular/core';
import {STEPPER_GLOBAL_OPTIONS} from '@angular/cdk/stepper';
import {Router} from '@angular/router';

@Component({
  selector: "create-course",
  styleUrls: ["create-course.component.scss"],
  templateUrl: "create-course.component.html"
})
export class CreateCourseComponent {
  constructor(private router :Router) { }
  navigateToSalon(){
    this.router.navigate(['/salons'])
   }
}
