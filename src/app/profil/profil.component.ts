import { Component, OnInit } from '@angular/core';
import { RestResponse } from '../model/RestResponse';
import { AuthService } from '../_services/auth.service';
import {User} from '../model/User';
@Component({
  selector: 'profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {
  user : User;
  constructor(private authservice:AuthService) { }

  ngOnInit(): void {
    this.myProfileInfo();
  }

  myProfileInfo(){
    this.authservice.getProfilInfo().subscribe(
      (data)=>{
         this.user = data.data;
         console.log(this.user);
      },
      (error)=>{
          console.log("error");
      })
    
  }

}
