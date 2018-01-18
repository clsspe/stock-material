package com.example.ricardo.stockmaterial;

/**
 * Created by Ricardo on 16/01/2018.
 */

public class Material {
    protected String materialNome;

    public Material(String nome) {
        materialNome = nome;
    }
    public Material() {
        materialNome = null;
    }
    public void setMaterial(String n) {
        materialNome = n;
    }
    public String getMaterial() {
        return materialNome;
    }

    @Override
    public String toString() {
        return materialNome;
    }
}
