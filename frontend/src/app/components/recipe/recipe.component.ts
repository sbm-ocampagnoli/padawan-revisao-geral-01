import { Component, OnInit } from '@angular/core';
import { Recipe } from 'src/app/interface/recipe';
import { RecipeService } from 'src/app/service/recipe.service';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {

  recipes: Recipe[] = [];

  constructor(private service: RecipeService) { }

  ngOnInit(): void {
    this.service.getRecipes().subscribe((recipes) => {
      this.recipes = recipes;
    }, (error) => {
      console.error('Error:', error);
    });
  }

}
