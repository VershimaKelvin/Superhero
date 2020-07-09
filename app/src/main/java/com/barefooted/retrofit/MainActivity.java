package com.barefooted.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.barefooted.model.Powerstats;
import com.barefooted.model.Profile;
import com.barefooted.model.Results;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    public String searchname;
    Button search_btn;
    EditText superHeroName;
    Retrofit retrofit;
    ImageView superHeroImage;
    String imageuri,currenthero;
    TextView name,intelligence,speed,strength,durability,combact,biography,powerstats,connections,fullname,alteregos,placeofbirth,firstappearance,publisher,allignment,groupaffiliation,relatives;


    final String BASE_URL = "https://superheroapi.com/api/1004555809958987/search/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Context context=MainActivity.this;
        search_btn=findViewById(R.id.search_btn);
        superHeroImage=findViewById(R.id.heroPicture);
        name=findViewById(R.id.name);
        intelligence=findViewById(R.id.intelligence);
        speed=findViewById(R.id.speed);
        strength=findViewById(R.id.stength);
        durability=findViewById(R.id.durability);
        combact=findViewById(R.id.combact);
        superHeroName=findViewById(R.id.searchBox);
        biography=findViewById(R.id.Biography);
        powerstats=findViewById(R.id.powerstats);
        connections=findViewById(R.id.connections);
        fullname=findViewById(R.id.fullname);
        placeofbirth=findViewById(R.id.placeofbirth);
        firstappearance=findViewById(R.id.firstappearance);
        publisher=findViewById(R.id.publisher);
        allignment=findViewById(R.id.allignment);
        groupaffiliation=findViewById(R.id.groupaffiliation);
        relatives=findViewById(R.id.relatives);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchname = superHeroName.getText().toString();

                if(!TextUtils.isEmpty(searchname)){
                    backend(context);
                }else{
                    Toast.makeText(context, "Enter SuperHero or Villan name", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    public void backend(final Context context){


        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SuperHeroApi superHeroApi = retrofit.create(SuperHeroApi.class);
        Call<Profile> call= superHeroApi.getData(searchname);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

                if(!response.isSuccessful()){

                    speed.setText("Server Reponded but has issues");
                    return;
                }

                Profile profile=response.body();
               ArrayList<Results> results=profile.getResults();

               for(Results results2: results){
                   imageuri = results2.getImage().getUrl();
                   Glide.with(context)
                           .load(imageuri)
                           .placeholder(R.drawable.placeholder)
                           .into(superHeroImage);

                   name.setText("Name: "+results2.getName());
                   intelligence.setText("Intelligence: "+results2.getPowerstats().getIntelligence());
                   strength.setText("Strngth: "+results2.getPowerstats().getStrength());
                   speed.setText("Speed: "+results2.getPowerstats().getSpeed());
                   durability.setText("Durability: "+results2.getPowerstats().getDurability());
                   combact.setText("Combact: "+results2.getPowerstats().getCombat());
                   biography.setText("Biography");
                   powerstats.setText("powerstats");
                   connections.setText("connections");
                   fullname.setText("Full-Name: "+results2.getBiography().getFull_name());
                   placeofbirth.setText("place-of-birth: "+results2.getBiography().getPlace_of_birth());
                   firstappearance.setText("First-appearance: "+results2.getBiography().getFirst_appearance());
                   publisher.setText("publisher: "+results2.getBiography().getPublisher());
                   allignment.setText("allignment: "+results2.getBiography().getAlignment());
                   groupaffiliation.setText("Group-affiliation: "+results2.getConnections().getGroup_affiliation());
                   relatives.setText("Relatives: "+results2.getConnections().getRelatives());








               }

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
