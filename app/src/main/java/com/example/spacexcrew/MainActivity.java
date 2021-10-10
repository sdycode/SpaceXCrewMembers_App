package com.example.spacexcrew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.spacexcrew.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<model> models;


RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        models = new ArrayList<>();

model mo = new model();
mo.setAgency("ag");
mo.setName("baba");
models.add(mo);
        mo.setAgency("ss");
        mo.setName("ddd");
        models.add(mo);

        mo.setAgency("dds");
        mo.setName("ddsd");
        models.add(mo);


        String n = String.valueOf(models.size());

rcv = binding.rcv;
        adapter ad = new adapter( getApplicationContext(), models);

        binding.rcv.setAdapter(ad);

        binding.refreshid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.notifyDataSetChanged();
                APICallMethods methods = RetrofitClient.getRetrofitInstance().create(APICallMethods.class);
                Call<ArrayList<model>> modelCall = methods.getAllData();

                modelCall.enqueue(new Callback<ArrayList<model>>() {
                    @Override
                    public void onResponse(Call<ArrayList<model>> call, Response<ArrayList<model>> response) {

                       model m = new model();
                       models.clear();
                        for(int i =0;i<response.body().size();i++ ){
                           m = response.body().get(i);
                           models.add(m);
                            ad.notifyDataSetChanged();

                        }
                        binding.sizeid.setText(String.valueOf(response.body().size()));

//                        Toast.makeText(getApplicationContext(),"Size is "+ models.size(),Toast.LENGTH_LONG).show();
//                        Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ArrayList<model>> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();

                    }
                });

                //--------------Save data to room database ---------------

//                UserModel userModel = new UserModel();
//                for(int i =0; i< models.size();i++){
//                    model mm = models.get(i);
//                    userModel.setName(mm.getName());
//                    userModel.setAgency(mm.getAgency());
//                    userModel.setImage(mm.getImage());
//                    userModel.setStatus(mm.getStatus());
//                    userModel.setWikipedia(mm.getWikipedia());
//                    userModels.add(userModel);
//
//                }
              //  DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAll(models);

            }
        });
        binding.deletid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                models.clear();
                ad.notifyDataSetChanged();
                binding.sizeid.setText(String.valueOf(models.size()));
            }
        });
        binding.rcv.setAdapter(ad);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rcv.setLayoutManager(linearLayoutManager);
        ad.notifyDataSetChanged();

    }
}