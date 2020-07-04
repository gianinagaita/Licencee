import {Component, OnInit} from '@angular/core';

import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";
import {BugsService} from "../../services/bugs.service";
import {Bug} from "../../models/bugs.model";


@Component({
  selector: 'app-bugs',
  templateUrl: './bugs.component.html',
  styleUrls: ['./bugs.component.css']
})
export class BugsComponent implements OnInit {


  constructor(private router: Router,
              private route: ActivatedRoute,
              private permissionService: AuthenticationService,
              private bugService: BugsService) {
  }
   bugs: Bug[];

  ngOnInit() {
    this.loadBugs();
  }

  add() {
    this.router.navigate(['./insert'], {relativeTo: this.route});
  }
  refresh() {
    this.loadBugs();
  }

  private loadBugs() {
    this.bugService.loadAllBugs()
      .subscribe(
        bugs => this.bugs = bugs,
        error => alert(error)
      )
  }
}
