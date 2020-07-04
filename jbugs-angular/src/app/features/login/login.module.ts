import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';


import {LoginFormComponent} from './components/login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import {MatInputModule,} from "@angular/material";

import {CookieService} from "ngx-cookie-service";
import {DialogComponent} from './components/dialog/dialog.component';
import {MatIconModule} from "@angular/material/icon";


@NgModule({
  declarations: [LoginFormComponent, DialogComponent],
  exports: [
    LoginFormComponent
  ],
    imports: [
        CommonModule,
        FormsModule,
        MatInputModule,
        MatIconModule,

    ],
  providers: [CookieService],
  entryComponents: [DialogComponent]
})
export class LoginModule {
}
