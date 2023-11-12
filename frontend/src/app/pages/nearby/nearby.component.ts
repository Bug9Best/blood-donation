import { Component, OnInit, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { GoogleMap, MapInfoWindow, MapMarker } from '@angular/google-maps';
import { MapService } from 'src/app/services/map.service';

@Component({
  selector: 'app-nearby',
  templateUrl: './nearby.component.html',
  styleUrls: ['./nearby.component.scss']
})
export class NearbyComponent implements OnInit {

  listLocaion: any = []
  listMarker: any = []

  @ViewChild(GoogleMap, { static: false }) googleMap!: GoogleMap;
  @ViewChild(MapInfoWindow, { static: false }) infoWindow!: MapInfoWindow;

  options: google.maps.MapOptions = {
    zoomControl: true,
    disableDefaultUI: true,
    center: { lat: 13.74278137660458, lng: 100.538634066753 },
    zoom: 12,
    maxZoom: 15,
    minZoom: 0,
  };

  constructor(
    private mapService: MapService
  ) { }

  ngOnInit(): void {
    this.getLocation()
  }

  getLocation() {
    this.mapService.getAll().subscribe(res => {
      this.listLocaion = res
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

  openInfo(marker: MapMarker, content: any) {
    this.infoWindow.open(marker);
  }

  viewDetail(value: any) {
  }

}
