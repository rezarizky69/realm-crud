package com.eja.realmcrud.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.eja.realmcrud.R;
import com.eja.realmcrud.helper.RealmHelper;

public class TambahDataActivity extends AppCompatActivity {

    private EditText tvNama;
    private EditText tvAlamat;
    private EditText tvEmail;
    private EditText tvMotto;
    private Button btnTambah;
    private RealmHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        initView();

        Toolbar tbMW = findViewById(R.id.tbAdd);
        setSupportActionBar(tbMW);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Data");

        helper = new RealmHelper(this);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvNama.getText().toString().isEmpty() || tvAlamat.getText().toString().isEmpty() || tvEmail.getText().toString().isEmpty() || tvMotto.getText().toString().isEmpty()) {
                    Toast.makeText(TambahDataActivity.this, "Tolong Lengkapi Data!", Toast.LENGTH_LONG).show();
                } else {
                    String nama = tvNama.getText().toString();
                    String alamat = tvAlamat.getText().toString();
                    String email = tvEmail.getText().toString();
                    String motto = tvMotto.getText().toString();
                    helper.tambahSiswa(nama, alamat, email, motto);
                    Toast.makeText(TambahDataActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void initView() {
        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvEmail = findViewById(R.id.tv_email);
        tvMotto = findViewById(R.id.tv_motto);
        btnTambah = findViewById(R.id.btn_tambah);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
