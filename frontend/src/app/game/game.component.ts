import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: 'game.html',
  styleUrls: ['game.css']
})
export class GameComponent extends OnInit {
  private bool: boolean;

  ngOnInit(): void {
    this.bool = false;
  }

}
