import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class PersonaService{

  constructor(private http: HttpClient) {
  }
  getAll(): Observable<any>{
    return this.http.get('//localhost:8081/persona/lista');
  }
}
