import {PersonaService} from './persona.service';
import {OnInit} from '@angular/core';
export class PeronasComponent implements OnInit {
  personas: Array<any>;
  constructor(private personaService: PersonaService) {}
  ngOnInit() {
    this.personaService.getAll().subscribe(data => {
      this.personas = data;
    });


  }

}
