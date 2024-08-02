import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RecipeService } from '../../service/recipe.service';
import { Recipe } from '../../interface/recipe';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css']
})
export class RecipeComponent implements OnInit {
  recipes: Recipe[] = [];
  recipeForm: FormGroup;
  editMode = false;
  currentRecipeId: number | null | undefined = null;
  search?: string;

  constructor(private fb: FormBuilder, private recipeService: RecipeService) {
    this.recipeForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      instructions: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.recipeForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      instructions: ['', Validators.required]
    });
    this.loadRecipes();
  }

  loadRecipesByName(name?: string) {
      this.recipes = [];
      this.loadRecipes(name);
  }
  loadRecipes(name?: string): void {
    this.recipeService.getRecipes(name).subscribe((recipes: Recipe[]) => {
      this.recipes = recipes;
    });
  }

  onSubmit(): void {
    if (this.recipeForm.valid) {
      if (this.editMode) {
        this.recipeService.updateRecipe(this.currentRecipeId!, this.recipeForm.value).subscribe(() => {
          this.loadRecipes();
          this.resetForm();
        });
      } else {
        this.recipeService.createRecipe(this.recipeForm.value).subscribe(() => {
          this.loadRecipes();
          this.resetForm();
        });
      }
    }
  }

  onEdit(recipe: Recipe): void {

    this.recipeForm.patchValue(recipe);
    this.editMode = true;
    this.currentRecipeId = recipe.id !== undefined ? recipe.id : null;
  }

  onDelete(id: number | undefined): void {
    if (id !== undefined) {
      this.recipeService.deleteRecipe(id).subscribe(() => {
        this.loadRecipes();
      });
    }
  }

  resetForm(): void {
    this.recipeForm.reset();
    this.editMode = false;
    this.currentRecipeId = null;
  }
}
