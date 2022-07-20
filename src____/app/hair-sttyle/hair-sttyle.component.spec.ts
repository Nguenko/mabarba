import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HairSttyleComponent } from './hair-sttyle.component';

describe('HairSttyleComponent', () => {
  let component: HairSttyleComponent;
  let fixture: ComponentFixture<HairSttyleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HairSttyleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HairSttyleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
