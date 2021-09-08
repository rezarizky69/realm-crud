package com.eja.realmcrud.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.eja.realmcrud.R;
import com.eja.realmcrud.helper.RealmHelper;

public class UpdateDataActivity extends AppCompatActivity {

    private EditText tvNama;
    private EditText tvAlamat;
    private EditText tvEmail;
    private EditText tvMotto;
    private Button btnUpdate, btnHapus;
    private RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        Toolbar tbMW = findViewById(R.id.tbUpdate);
        setSupportActionBar(tbMW);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Update Data");

        final int id = getIntent().getIntExtra("DATA_ID", 0);
        String nama = getIntent().getStringExtra("DATA_NAMA");
        String alamat = getIntent().getStringExtra("DATA_ALAMAT");
        String email = getIntent().getStringExtra("DATA_EMAIL");
        String motto = getIntent().getStringExtra("DATA_MOTTO");

        initView();

        tvNama.setText(nama);
        tvAlamat.setText(alamat);
        tvEmail.setText(email);
        tvMotto.setText(motto);

        helper = new RealmHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tvNama.getText().toString();
                String alamat = tvAlamat.getText().toString();
                String email = tvEmail.getText().toString();
                String motto = tvMotto.getText().toString();
                helper.updateSiswa(id, nama, alamat, email, motto);
                Toast.makeText(UpdateDataActivity.this, "Update Berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.deleteSiswa(id);
                Toast.makeText(UpdateDataActivity.this, "Data Dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void initView() {
        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvEmail = findViewById(R.id.tv_email);
        tvMotto = findViewById(R.id.tv_motto);
        btnUpdate = findViewById(R.id.btn_update);
        btnHapus = findViewById(R.id.btn_hapus);
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
