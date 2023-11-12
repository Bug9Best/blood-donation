import { Component } from '@angular/core';

@Component({
  selector: 'app-blood-bank',
  templateUrl: './blood-bank.component.html',
  styleUrls: ['./blood-bank.component.scss']
})
export class BloodBankComponent {
  keyword: string = ''

  setKeyword(keyword: string) {
    this.keyword = keyword
  }
}
