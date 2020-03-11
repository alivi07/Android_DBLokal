package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.DataDiri;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private Button btnInput, btnRead;
    private EditText etNama,etAlamat,etJK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.iniDB(getApplicationContext());
        etAlamat = findViewById(R.id.etAlamat);
        etJK = findViewById(R.id.etJK);
        etNama = findViewById(R.id.etNama);
        btnInput = findViewById(R.id.btnInput);
        btnRead = findViewById(R.id.btnRead);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                startActivity(intent);
            }
        });
    }

    private void insertData(){
        // TODO 1: Simpan inputan ke dalam String (Char untuk jkelamin)
            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            char jk = etJK.getText().toString().charAt(0);


        // TODO 2: Masukkan ke dalam item
        //    DataDiri item = new DataDiri();
        //    item.setNama(...);
        //    ...
        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJk(jk);


        // TODO 3: Panggil fungsi InsertData
        //    appDatabase.dao().insertData(item);
        appDatabase.dao().insertData(item);


        // TODO 4: hapus inputan
        etNama.setText("");
        etAlamat.setText("");
        etJK.setText("");
    }




}

