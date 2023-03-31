import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css'],
})
export class ButtonComponent {
  @Input() label: String = 'Button';
  @Input() variant: Variant = 'default';
  @Input() disabled: boolean = false;
  @Input() type: 'submit' | 'button' = 'button';

  @Output() onClick = new EventEmitter();

  handleBtnClick() {
    this.onClick.emit();
  }
}

type Variant = 'outline' | 'text' | 'default';
