package com.eja.realmcrud.helper;

import android.content.Context;
import android.widget.Toast;

import com.eja.realmcrud.model.ModelSiswa;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmHelper {

    private Context context;
    private Realm realm;
    private RealmResults<ModelSiswa> realmResults;

    private static final String TAG = "RealmHelper";

    public RealmHelper(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void inputDataAwal() {
        ModelSiswa modelSiswa = new ModelSiswa();
        modelSiswa.setId(1);
        modelSiswa.setNama("Eza");
        modelSiswa.setAlamat("Bekasi");
        modelSiswa.setEmail("ejaganteng@email.com");
        modelSiswa.setMotto("all is well");

        realm.beginTransaction();
        realm.copyToRealm(modelSiswa);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
    }

    public ArrayList<ModelSiswa> tampilDataSiswa() {
        ArrayList<ModelSiswa> data = new ArrayList<>();
        realmResults = realm.where(ModelSiswa.class).findAll();
        realmResults.sort("id", Sort.ASCENDING);

        if (realmResults.size() > 0) {
            for (int i = 0; i < realmResults.size(); i++) {
                ModelSiswa modelSiswa = new ModelSiswa();
                modelSiswa.setId(realmResults.get(i).getId());
                modelSiswa.setNama(realmResults.get(i).getNama());
                modelSiswa.setAlamat(realmResults.get(i).getAlamat());
                modelSiswa.setEmail(realmResults.get(i).getEmail());
                modelSiswa.setMotto(realmResults.get(i).getMotto());
                data.add(modelSiswa);
            }
        }
        return data;
    }

    public void tambahSiswa(String nama, String alamat, String email, String motto) {
        ModelSiswa modelSiswa = new ModelSiswa();
        modelSiswa.setId((int) (System.currentTimeMillis() / 1000));
        modelSiswa.setNama(nama);
        modelSiswa.setAlamat(alamat);
        modelSiswa.setEmail(email);
        modelSiswa.setMotto(motto);

        realm.beginTransaction();
        realm.copyToRealm(modelSiswa);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
    }

    public void updateSiswa(int id, String nama, String alamat, String email, String motto) {
        realm.beginTransaction();
        ModelSiswa modelSiswa = realm.where(ModelSiswa.class).equalTo("id", id).findFirst();
        modelSiswa.setNama(nama);
        modelSiswa.setAlamat(alamat);
        modelSiswa.setEmail(email);
        modelSiswa.setMotto(motto);
        realm.copyToRealm(modelSiswa);
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil diupdate", Toast.LENGTH_LONG).show();
    }

    public void deleteSiswa(int id) {
        realm.beginTransaction();
        RealmResults<ModelSiswa> modelSiswa = realm.where(ModelSiswa.class).equalTo("id", id).findAll();
        modelSiswa.deleteAllFromRealm();
        realm.commitTransaction();

        Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_LONG).show();
    }
}

