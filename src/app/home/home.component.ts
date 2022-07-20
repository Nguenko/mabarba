import {Component, OnInit} from '@angular/core';
import {Course} from "../model/course";
import {Observable} from "rxjs";
import {CoursesService} from "../services/courses.service";
import {map} from "rxjs/operators";
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';
@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

    beginnerCourses$: Observable<Course[]>;

    advancedCourses$: Observable<Course[]>;

    content: string;

    constructor(private coursesService: CoursesService,private userService: UserService,private router :Router) {

    }

   

    ngOnInit() {

        const courses$ = this.coursesService.findAllCourses();

        this.beginnerCourses$ = courses$.pipe(
          map(courses => courses.filter(course => course.category === 'BEGINNER') )
        );

        this.advancedCourses$ = courses$.pipe(
            map(courses => courses.filter(course => course.category === 'ADVANCED') )
        );


        this.userService.getPublicContent().subscribe(
          data => {
            this.content = data;
          },
          err => {
            this.content = JSON.parse(err.error).message;
          }
        );
      }
      navigateTo()
      {
        this.router.navigate(['/barbers'])
      }

}
