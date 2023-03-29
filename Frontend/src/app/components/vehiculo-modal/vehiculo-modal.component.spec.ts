import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiculoModalComponent } from './vehiculo-modal.component';

describe('VehiculoModalComponent', () => {
  let component: VehiculoModalComponent;
  let fixture: ComponentFixture<VehiculoModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehiculoModalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiculoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
