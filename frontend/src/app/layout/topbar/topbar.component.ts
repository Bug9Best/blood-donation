import { Component, ElementRef, ViewChild } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { LayoutService } from "../service/layout.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
})
export class AppTopBarComponent {

  items: MenuItem[] = [
    {
      label: 'ตัวเลือก',
      items: [
        {
          label: 'ประวัติส่วนตัว',
          icon: 'pi pi-user',
          command: () => {
            this.router.navigate(['/profile']);
          }
        },
        {
          label: 'ออกจากระบบ',
          icon: 'pi pi-sign-out',
          command: () => {
          }
        }
      ]
    },
  ];

  @ViewChild('menubutton') menuButton!: ElementRef;

  @ViewChild('topbarmenubutton') topbarMenuButton!: ElementRef;

  @ViewChild('topbarmenu') menu!: ElementRef;

  constructor(
    public layoutService: LayoutService,
    private router: Router
  ) { }
}
