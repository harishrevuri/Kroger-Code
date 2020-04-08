package com.example.gitlabrepos;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitlabrepos.adapter.DataAdapter;
import com.example.gitlabrepos.api.RestClient;
import com.example.gitlabrepos.api.RestService;
import com.example.gitlabrepos.model.RepositoriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<RepositoriesModel> repositoriesModelsList;
    private RecyclerView recyclerView;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        RestService restService = RestClient.retrofit.create(RestService.class);
        Call<List<RepositoriesModel>> call = restService.getRepos();
        call.enqueue(new Callback<List<RepositoriesModel>>() {
            @Override
            public void onResponse(Call<List<RepositoriesModel>> call, Response<List<RepositoriesModel>> response) {
                repositoriesModelsList = response.body();
                recyclerView.setAdapter(new DataAdapter(getApplicationContext(), repositoriesModelsList));
                recyclerView.smoothScrollToPosition(0);
                pd.hide();
            }

            @Override
            public void onFailure(Call<List<RepositoriesModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Data");
        pd.setCancelable(false);
        pd.show();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}