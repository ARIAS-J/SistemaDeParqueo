import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout/layout.component';
import { HomeComponent } from './pages/home/home.component';
import { EstanciasComponent } from './pages/estancias/estancias.component';
import { VehiculosComponent } from './pages/vehiculos/vehiculos.component';
import { ButtonComponent } from './components/button/button.component';
import { HttpClientModule } from '@angular/common/http';
import { FiltroPipe } from './pages/vehiculos/pipes/filtro.pipe';
import { ModalComponent } from './components/modal/modal.component';
import { VehiculoFormComponent } from './components/vehiculo-form/vehiculo-form.component';
import { FormsModule } from '@angular/forms';
import { PagosFormComponent } from './components/pagos-form/pagos-form.component';
import { CreditCardFormComponent } from './components/credit-card-form/credit-card-form.component';
import { EndStayFormComponent } from './components/end-stay-form/end-stay-form.component';
import { CreateStayFormComponent } from './components/create-stay-form/create-stay-form.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    HomeComponent,
    EstanciasComponent,
    VehiculosComponent,
    ButtonComponent,
    FiltroPipe,
    ModalComponent,
    VehiculoFormComponent,
    PagosFormComponent,
    CreditCardFormComponent,
    EndStayFormComponent,
    CreateStayFormComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
