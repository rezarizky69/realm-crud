package com.eja.realmcrud.model;

import io.realm.RealmObject;

public class ModelSiswa extends RealmObject {

    private int id;
    private String nama;
    private String alamat;
    private String email;
    private String motto;

    public ModelSiswa(int id, String nama, String alamat, String email, String motto){
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.motto = motto;
    }

    public ModelSiswa(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

}
