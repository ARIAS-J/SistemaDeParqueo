import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateStayFormComponent } from './create-stay-form.component';

describe('CreateStayFormComponent', () => {
  let component: CreateStayFormComponent;
  let fixture: ComponentFixture<CreateStayFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateStayFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateStayFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
