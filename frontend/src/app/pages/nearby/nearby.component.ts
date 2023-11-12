import { Component, OnInit } from '@angular/core';
import { MapService } from 'src/app/services/map.service';

@Component({
  selector: 'app-nearby',
  templateUrl: './nearby.component.html',
  styleUrls: ['./nearby.component.scss']
})
export class NearbyComponent implements OnInit {

  listLocaion: any = []

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

  constructor(
    private mapService: MapService
  ) { }

  ngOnInit(): void {
    this.getLocation()
  }

  getMarker(value: any) {

  }

  getLocation() {
    this.mapService.getAll().subscribe(res => {
      this.listLocaion = res
      this.getMarker(res)
    })
  }

  onSearch(keyWord: string) {
    if (keyWord) {
      this.listLocaion = this.listLocaion.filter((item: any) => {
        return item.name.toLowerCase().includes(keyWord.toLowerCase())
      })
    }
    else {
      this.getLocation()
    }
  }

  viewDetail(value: any) {
  }

}
