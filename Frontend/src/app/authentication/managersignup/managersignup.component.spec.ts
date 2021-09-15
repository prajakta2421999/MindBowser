import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagersignupComponent } from './managersignup.component';

describe('ManagersignupComponent', () => {
  let component: ManagersignupComponent;
  let fixture: ComponentFixture<ManagersignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagersignupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagersignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
