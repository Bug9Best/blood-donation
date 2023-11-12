import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'blood-bank-list',
  templateUrl: './blood-bank-list.component.html',
  styleUrls: ['./blood-bank-list.component.scss']
})
export class BloodBankListComponent {

  private _keyword: string = '';
  public get keyword(): string {
    return this._keyword;
  }

  @Input()
  public set keyword(value: string) {
    this._keyword = value;
    this.listLocaion = this._keyword ? this.performFilter() : this.getLocation();
  }

  listLocaion: any = []

  constructor(
    private router: Router,
    private locationService: LocationService
  ) { }

  ngOnInit(): void {
    this.getLocation()
  }

  getLocation() {
    this.locationService.getAll().subscribe(res => {
      this.listLocaion = res
    })
  }

  performFilter() {
    return this.listLocaion.filter((location: any) =>
      location.name.toLowerCase().includes(this.keyword.toLowerCase())
    );
  }

  viewDetail(value: any) {
    this.router.navigate(['/blood-bank/detail'], { queryParams: { id: value } })
  }
}
