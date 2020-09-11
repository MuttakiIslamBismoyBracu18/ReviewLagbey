
package com.haerul.foodsapp.api;

import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("latest.php")
    Call<Meals> getMeal();

    @GET("categories.php")
    default Call<Categories> getCatergories() {
        return null;
    }
}
