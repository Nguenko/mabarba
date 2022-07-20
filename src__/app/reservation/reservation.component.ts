import { Component, OnInit, ViewChild} from '@angular/core';
import { FormGroup,FormControl,FormBuilder,Validators } from '@angular/forms';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatChipInputEvent} from '@angular/material/chips';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {MAT_DIALOG_DATA,  MatDialogConfig} from '@angular/material/dialog';
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

export interface Fruit {
  name: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
  {position: 11, name: 'Sodium', weight: 22.9897, symbol: 'Na'},
  {position: 12, name: 'Magnesium', weight: 24.305, symbol: 'Mg'},
  {position: 13, name: 'Aluminum', weight: 26.9815, symbol: 'Al'},
  {position: 14, name: 'Silicon', weight: 28.0855, symbol: 'Si'},
  {position: 15, name: 'Phosphorus', weight: 30.9738, symbol: 'P'},
  {position: 16, name: 'Sulfur', weight: 32.065, symbol: 'S'},
  {position: 17, name: 'Chlorine', weight: 35.453, symbol: 'Cl'},
  {position: 18, name: 'Argon', weight: 39.948, symbol: 'Ar'},
  {position: 19, name: 'Potassium', weight: 39.0983, symbol: 'K'},
  {position: 20, name: 'Calcium', weight: 40.078, symbol: 'Ca'},
];

@Component({
  selector: 'reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild('closebuttoncc', {static: false}) closebuttoncc;
  addOnBlur = true;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  fruits: Fruit[] = [{name: 'Barber'}, {name: 'Home'}, {name: 'Edit'}];
  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    // Add our fruit
    if (value) {
      this.fruits.push({name: value});
    }

    // Clear the input value
   // event.chipInput!.clear();
  }

  remove(fruit: Fruit): void {
    const index = this.fruits.indexOf(fruit);

    if (index >= 0) {
      this.fruits.splice(index, 1);
    }
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  user: any = {
    id: 'qsdgqjzjdegjsdjvqsjd'
  };

  form: FormGroup;
  isLoading = false;
  isError = false;
  isSuccess = false;
  message = { title: '', content: '' };
  messages = '';
  isSubmitted = false;
  formMode = 'create';
  itemToDeleteId: string;
  isDeleting = false;
  progress = 0;
  selectPageSize: number[];
  numberOfPages: number;
  numbers: Array<any> = [];
  usePaginationButton: boolean;
  pagesNumber: number;
  name: string;
  preview: string;
  //itemToUpdate: Offer;
  //itemToShow: Offer;
  itemToDeleteName: string;
  selectedFiles: FileList;
  currentFile: File;
  closeResult: string;


  componentInfos = {
    displayName: 'Offers'
  };

  firstParentInfos = {
    displayName: 'Companies'
  };

  secondParentInfos = {
    displayName: 'Groups'
  };
  firstNode: string;
  secondNode: string;

  selectedFile: File = null;
  
  groupId: string;


  parentInfos = {
    displayName: 'Groups',
    url: '/admin/groups'
  };

  constructor(private formBuilder: FormBuilder,public dialog: MatDialog) { }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
     }

     close() {
      alert("hello")
      this.closebuttoncc.nativeElement.click();

  }

}
