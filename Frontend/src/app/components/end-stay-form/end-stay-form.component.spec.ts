import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndStayFormComponent } from './end-stay-form.component';

describe('EndStayFormComponent', () => {
  let component: EndStayFormComponent;
  let fixture: ComponentFixture<EndStayFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EndStayFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndStayFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
