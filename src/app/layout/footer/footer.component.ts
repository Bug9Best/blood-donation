import { Component } from '@angular/core';
import { LayoutService } from "../service/layout.service";

@Component({
    selector: 'app-footer',
    templateUrl: './footer.component.html'
})
export class AppFooterComponent {
    constructor(public layoutService: LayoutService) { }
}
