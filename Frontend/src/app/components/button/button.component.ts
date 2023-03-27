import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css'],
})
export class ButtonComponent {
  @Input() label: String = 'Button';
  @Input() variant: Variant = 'default';
  @Input() disabled: boolean = false;
}

type Variant = 'outline' | 'text' | 'default';
