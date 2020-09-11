
package com.haerul.foodsapp.view.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.haerul.foodsapp.R;

import java.time.Instant;
import java.util.Objects;

public class ViewPage extends AppCompatActivity {
    Dialog popAddPost;
    //ImageView popupUserImage;
    //ImageView popupPopImage;
    Button popupAddBtn;
    TextView popupTitle,popupDescription,val;
    ProgressBar popupProgressBar;
    private Instant Glide;
    FloatingActionButton fab;
    double avg=0;
    SeekBar serviceR, restaurantR, foodR, environmentR;
    double s1,s2,s3,s4,average;

    /*private void iniPopup() {

        popAddPost.setContentView(R.layout.activity_view_page);
        popAddPost.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popAddPost.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popAddPost.getWindow().getAttributes().gravity = Gravity.TOP;
        val=(TextView) findViewById(R.id.val);
        popupUserImage = popAddPost.findViewById(R.id.popup_user_image);
        popupPopImage = popAddPost.findViewById(R.id.popup_user_image);
        popupTitle = popAddPost.findViewById(R.id.popup_title);
        popupDescription = popAddPost.findViewById(R.id.popup_description);
        popupAddBtn = popAddPost.findViewById(R.id.popup_add);

        popupProgressBar = popAddPost.findViewById(R.id.popup_progressBar);
        //Glide.with(activity: ViewPage.this).load(getCurrentFocus());

        popupProgressBar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                popupAddBtn.setVisibility(View.INVISIBLE);
                popupProgressBar.setVisibility(View.VISIBLE);
            }
        });
    } */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        popupAddBtn=(Button) findViewById(R.id.popup_add);
        val=(TextView) findViewById(R.id.val);
        fab=(FloatingActionButton) findViewById(R.id.fab);
        serviceR=(SeekBar)findViewById(R.id.ServiceR);
        restaurantR=(SeekBar)findViewById(R.id.RestaurantR);
        foodR = (SeekBar) findViewById(R.id.FoodR);
        environmentR = (SeekBar) findViewById(R.id.EnvironmentR);
        popupTitle= (TextView) findViewById(R.id.popup_title);
        popupDescription = (TextView) findViewById(R.id.popup_description);

      //  int s1=serviceR.getProgress();
        //int s2=restaurantR.getProgress();
        //int s3=foodR.getProgress();
        //int s4=environmentR.getProgress();
        serviceR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s1=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ViewPage.this, "Ingredients Rating is : "+s1,Toast.LENGTH_SHORT).show();


            }
        });

        foodR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s3=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ViewPage.this, "Taste Rating is : "+s3,Toast.LENGTH_SHORT).show();


            }
        });

        restaurantR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s2=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ViewPage.this, "Repeatation Rating is : "+s2,Toast.LENGTH_SHORT).show();

            }
        });

        environmentR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s4=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ViewPage.this, "Cooking Rating is : "+s4,Toast.LENGTH_SHORT).show();


            }
        });



         //average=(s1+s2+s3+s4)/4.0;
        //validate6();
         popupAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val.setText("Ekhon na, Pore Bolbo");
                //validate4();
        }
         });

         fab.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 String title = popupTitle.getText().toString();
                 String des = popupDescription.getText().toString();
                 double avg= ((s1+s2+s3+s4)/4.0);
                 if(avg<=6.0)
                 {
                     val.setText("Your Review over "+title+" goes by : \n"+des+"\nYour Average Rating is " +avg+" Seems like You don't like "+title+" that much");
                 }
                 if(avg>6.0 && avg<8.0)
                 {
                     val.setText("Your Review over "+title+" goes by : \n"+des+"\nYour Average Rating is " +avg+" Seems like You like "+title+" a lot");
                 }
                 else if (avg>8.0 && avg<=10.0) {
                     val.setText("Your Review over " + title + " goes by : \n" + des + "\nYour Average Rating is " + avg + "\n Seems like " + title + " is your favorite food");
                     //val.setText("Your Review over "+title+" goes by : \n"+des+"\nYour Average Rating is " +);
                 }
             }
         });
    }

   /* private double validate6() {
        //val.setText("Ekhon Bolbo na");
        //Toast.makeText(this, (CharSequence) val,Toast.LENGTH_SHORT);

    } */

}