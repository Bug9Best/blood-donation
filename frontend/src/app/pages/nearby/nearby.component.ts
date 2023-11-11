import { Component } from '@angular/core';

@Component({
  selector: 'app-nearby',
  templateUrl: './nearby.component.html',
  styleUrls: ['./nearby.component.scss']
})
export class NearbyComponent {

  listArea: any = [
    1, 2, 3, 4, 5, 6
  ]

  options: google.maps.MapOptions = {
    zoomControl: true,
    scrollwheel: false,
    streetViewControl: false,
    fullscreenControl: false,
    disableDoubleClickZoom: true,
    mapTypeControl: false,
    center: { lat: 13.723784979498301, lng: 100.74317612937757 },

    maxZoom: 15,
    minZoom: 0,
  };

  constructor() { }

  onSearch(keyWord: string) {
    console.log(keyWord);
  }

}
