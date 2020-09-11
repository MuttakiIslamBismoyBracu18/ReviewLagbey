/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 9/8/20 5:36 PM                                               -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.home;

import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCatergory(List<Categories.Category> catergory);
    void onErrorLoading(String message);

}
