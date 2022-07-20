import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerBarberComponent } from './manager-barber.component';

describe('ManagerBarberComponent', () => {
  let component: ManagerBarberComponent;
  let fixture: ComponentFixture<ManagerBarberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerBarberComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManagerBarberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
