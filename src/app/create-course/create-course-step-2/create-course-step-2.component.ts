import {Component, OnInit, Output,EventEmitter, Input} from '@angular/core';
import{Router} from '@angular/router';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';
@Component({
  selector: "create-course-step-2",
  templateUrl:"create-course-step-2.component.html",
  styleUrls: ["create-course-step-2.component.scss"]
})
export class CreateCourseStep2Component implements OnInit{
  constructor(private router :Router, private fb : FormBuilder) { }
  
  form1: FormGroup;
  form2: FormGroup;
  @Output() formEvent2 = new EventEmitter<any>();
  @Input() formEvent1 :any;
  ngOnInit() {
    this.form1 = this.fb.group({
      nom:new FormControl('', [Validators.required,Validators.minLength(5),Validators.maxLength(60)])
    }) 
    this.form2 = this.fb.group({
      telephone:new FormControl('', [Validators.required,Validators.minLength(5),Validators.maxLength(60)])
    }) 
  }

  /* onSubmit2(){
    console.log(this.form2.get('telephone').value);
    this.formEvent2.emit(this.form2.get('telephone').value);
  } */

  onSubmit1(){
    console.log(this.form1.value);
    this.formEvent2.emit(this.form1);
  }
  addForm1(formular: FormGroup){
    console.log(formular.value);
   }
  onSubmit2(){
    //console.log(this.form2.value);
    this.formEvent2.emit(this.form2);
    //console.log(this.form1.value);
   // this.formEvent1.emit(this.form1);
  }

}
