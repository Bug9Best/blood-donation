import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { PrimeNGModule } from 'src/app/modules/primeng.module';

@Component({
  selector: 'page-title',
  templateUrl: './page-title.component.html',
  styleUrls: ['./page-title.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    PrimeNGModule,
  ]
})
export class PageTitleComponent {

  @Input() title: string = 'Default Title';
  @Input() label: string = 'Default label';
  @Input() icon: string = 'pi pi-home';
  @Input() showButton: boolean = false;

  @Output() onClick: EventEmitter<any> = new EventEmitter();
  eventHandle() {
    this.onClick.emit();
  }
}
