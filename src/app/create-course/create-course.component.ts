import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {STEPPER_GLOBAL_OPTIONS} from '@angular/cdk/stepper';
import {Router} from '@angular/router';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

@Component({
  selector: "create-course",
  styleUrls: ["create-course.component.scss"],
  templateUrl: "create-course.component.html"
})
export class CreateCourseComponent implements OnInit {
  constructor(private router :Router, private fb : FormBuilder) { }
 form : FormGroup;
 form1: FormGroup;
 @Output() formEvent1 = new EventEmitter<any>();
  ngOnInit(){

  }
  navigateToSalon(){
    this.router.navigate(['/salons'])
   }

    forms = this.fb.group({
    nom:new FormControl('', [Validators.required,Validators.minLength(5),Validators.maxLength(60)]),
    telephone:new FormControl('', [Validators.required,Validators.minLength(5),Validators.maxLength(60)])
    }); 

    addForm2(formular2: FormGroup){
     this.forms.patchValue(formular2.value);
     //this.forms.get("telephone");
     console.log(this.forms.value);
    }
    addForm1(formular: FormGroup){
      this.forms.patchValue(formular.value)
      console.log(this.forms.value);
      //this.reactiveForm.setValue(contact);
     }

     onSubmit1(){
      console.log(this.form1.value);
      this.formEvent1.emit(this.form1);
    }
}
