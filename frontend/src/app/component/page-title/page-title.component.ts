import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
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
}
