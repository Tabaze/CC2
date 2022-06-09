package com.example.cc2;

public class Climat {
    int Id,temperature,pourcentage;
    String nomVille,pays;

    public Climat() {
    }

    public Climat(int id, int temperature, int pourcentage, String nomVille, String pays) {
        Id = id;
        this.temperature = temperature;
        this.pourcentage = pourcentage;
        this.nomVille = nomVille;
        this.pays = pays;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
