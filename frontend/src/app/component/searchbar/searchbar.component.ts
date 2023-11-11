import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { PrimeNGModule } from 'src/app/modules/primeng.module';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    PrimeNGModule,
  ]
})
export class SearchbarComponent {
  keyWord: string = '';

  @Output() onSearch: EventEmitter<string> = new EventEmitter<string>();
  search() {
    this.onSearch.emit(this.keyWord);
  }

}
