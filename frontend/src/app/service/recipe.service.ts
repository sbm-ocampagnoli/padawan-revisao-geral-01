import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Recipe } from '../interface/recipe';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private API = environment.apiURL + '/recipes';

  constructor(private httpClient: HttpClient) { }

  getRecipes(): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(this.API);
  }
}
