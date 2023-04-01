import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeudasTableComponent } from './deudas-table.component';

describe('DeudasTableComponent', () => {
  let component: DeudasTableComponent;
  let fixture: ComponentFixture<DeudasTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeudasTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeudasTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
