package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.DataDiri;

public class ReadActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private TextView tvNama,tvAlamat,tvJK;
    private RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        appDatabase = AppDatabase.iniDB(getApplicationContext());

        rc = findViewById(R.id.rvMain);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvJK = findViewById(R.id.tvJK);
        tvNama = findViewById(R.id.tvNama);

        read();

    }
    private void read(){
        DataDiri[] list = appDatabase.dao().getData();

        dataDiriAdapter adapter = new dataDiriAdapter(list, new dataDiriListener() {
            @Override
            public void onButtonDelete(DataDiri item) {
                appDatabase.dao().deleteData(item);
                read();
            }

            @Override
            public void onButtonEdit(DataDiri item) {

            }
        });
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);



    }
}
