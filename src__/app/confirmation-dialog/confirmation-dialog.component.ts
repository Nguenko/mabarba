import { Component, Inject, OnInit } from '@angular/core';
import {MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.scss']
})
export class ConfirmationDialogComponent implements OnInit {

  message: string = "Are you sure?"
  confirmButtonText = "Yes"
  cancelButtonText = "Cancel"
  
  constructor(
    private dialogRef: MatDialogRef<ConfirmationDialogComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any) {
    if(data){
      this.message = data.message || this.message;
      if (data.buttonText) {
        this.confirmButtonText = data.buttonText.ok || this.confirmButtonText;
        this.cancelButtonText = data.buttonText.cancel || this.cancelButtonText;
      }
        }
   }

  ngOnInit(): void {
  }

  onConfirmClick(): void {
    this.dialogRef.close(true);
  }

}
