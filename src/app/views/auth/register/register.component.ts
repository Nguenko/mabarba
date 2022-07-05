import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../_services/auth.service';
import { NgForm } from '@angular/forms';
import {Signuprequest} from '../../../model/signuprequest.model';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  formulaire : Signuprequest; 

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  beforeSubmit(forms:NgForm){
    if(forms.controls.password.value==forms.controls.passwordConfirm.value){
      this.onSubmit(forms);
    }else {
      this.errorMessage = "Password and password error must be identical";
      this.isSignUpFailed = true;
    }
  
  }

  onSubmit(forms:NgForm): void {
     let formulaire ={
      username: forms.controls.username.value,
      email :  forms.controls.email.value,
      role : forms.controls.role.value,
      password: forms.controls.password.value
    } 
      /* this.formulaire.email = forms.controls.email.value;
      this.formulaire.username = forms.controls.username.value;
      this.formulaire.password = forms.controls.password.value;
      this.formulaire.role.push(forms.controls.role.value); */
      console.log(formulaire);
      this.authService.register(formulaire).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
