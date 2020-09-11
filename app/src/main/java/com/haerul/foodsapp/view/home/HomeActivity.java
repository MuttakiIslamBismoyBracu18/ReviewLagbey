package com.haerul.foodsapp.view.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.haerul.foodsapp.R;
import com.haerul.foodsapp.Utils;
import com.haerul.foodsapp.adapter.RecyclerViewHomeAdapter;
import com.haerul.foodsapp.adapter.ViewPagerHeaderAdapter;
import com.haerul.foodsapp.model.Categories;
import com.haerul.foodsapp.model.Meals;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.Toast.*;

public class HomeActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.viewPagerHeader)
    ViewPager viewPagerMeal;
    @BindView(R.id.recyclerCategory)
    RecyclerView recyclerViewCatergory;
    HomePresenter presenter;
    private Button Signup;
    private Button Login;
    private int counter=5;
    Spinner mySp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        presenter=new HomePresenter(this);
        presenter.getMeals();
        presenter.getCategories();
        Signup = (Button) findViewById(R.id.button2);
        Login = (Button) findViewById(R.id.button3);
        mySp =(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(HomeActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySp.setAdapter(myAdapter);

        mySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    startActivity(new Intent(HomeActivity.this,SignUpActivity.class));
                }
                else if (position==2)
                {
                    startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate3();
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate2();
            }
        });
    }

    private void validate3() {
        Intent a = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(a);
    }

    private void validate2() {
        Intent a = new Intent(HomeActivity.this, SignUpActivity.class);
        startActivity(a);
    }

    @Override
    public void showLoading()
    {
        findViewById(R.id.shimmerMeal).setVisibility(View.VISIBLE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory).setVisibility(View.VISIBLE);
    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {
        /*for (Meals.Meal mealresult : meal) {
            Log.w("meal name : ", mealresult.getStrMeal());
        } */
        ViewPagerHeaderAdapter headerAdapter= new ViewPagerHeaderAdapter(meal, this);
        viewPagerMeal.setAdapter(headerAdapter);
        viewPagerMeal.setPadding(20,0,150,0);
        headerAdapter.notifyDataSetChanged();
        headerAdapter.setOnItemClickListener((v,position) -> {
                Toast.makeText(this,meal.get(position).getStrMeal(), LENGTH_SHORT).show();
        });

    }

    @Override
    public void setCatergory(List<Categories.Category> catergory) {
        RecyclerViewHomeAdapter homeAdapter = new RecyclerViewHomeAdapter(catergory,this);
        recyclerViewCatergory.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this , 3, GridLayoutManager.VERTICAL, false   );
        recyclerViewCatergory.setLayoutManager(layoutManager);
        recyclerViewCatergory.setClipToPadding(false);
        recyclerViewCatergory.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();
        homeAdapter.setOnItemClickListener((view, position) -> {
            Toast.makeText(this,catergory.get(position).getStrCategory(), LENGTH_SHORT).show();
        });

    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Title", message);
    }

}
