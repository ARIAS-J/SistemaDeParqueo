import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagos-form',
  templateUrl: './pagos-form.component.html',
  styleUrls: ['./pagos-form.component.css'],
})
export class PagosFormComponent implements OnInit {
  showCreditCardForm: boolean = false;

  constructor() {}

  ngOnInit(): void {}

  creditCardFormIsOpen() {
    this.showCreditCardForm = true;
  }
  creditCardFormIsClose() {
    this.showCreditCardForm = false;
  }
}
