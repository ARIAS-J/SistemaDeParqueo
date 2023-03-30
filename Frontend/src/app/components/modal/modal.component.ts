import { Component, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent {
  @Input() title: string = 'Modal title';
  @Output() onClose = new EventEmitter();

  handleModalClose() {
    this.onClose.emit();
  }
}
