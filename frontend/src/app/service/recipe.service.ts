import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe } from '../interface/recipe';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private apiUrl = environment.apiURL + '/recipes';

  constructor(private http: HttpClient) { }

  getRecipes(name?: string): Observable<Recipe[]> {
    if (name == null) {
      return this.http.get<Recipe[]>(this.apiUrl);
    } else {
      let params = new HttpParams();
      params = params.set('name', name);
      return this.http.get<Recipe[]>(this.apiUrl, { params })
    }
  }

  createRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.apiUrl, recipe);
  }

  updateRecipe(id: number, recipe: Recipe): Observable<Recipe> {

    return this.http.put<Recipe>(`${this.apiUrl}/${id}`, recipe);
  }

  deleteRecipe(id: number): Observable<Recipe> {
    return this.http.delete<Recipe>(`${this.apiUrl}/${id}`);
  }
}
