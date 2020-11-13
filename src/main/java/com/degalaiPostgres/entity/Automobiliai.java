package com.degalaiPostgres.entity;


import javax.persistence.*;

@Entity
@Table
public class Automobiliai {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "sanaudosvasara")
    private double sanaudosVasara;

    @Column(name = "sanaudosziema")
    private double sanaudosZiema;

    @Column
    @Enumerated(EnumType.STRING)
    private Degalutipas degalutipas;

    @Column(name = "sunaudojodegalu")
    private Double sunaudojoDegalu;

    public Automobiliai() {
    }

    public Automobiliai(String name, double sanaudosVasara, double sanaudosZiema, Degalutipas degalutipas, Double sunaudojoDegalu) {
        this.name = name;
        this.sanaudosVasara = sanaudosVasara;
        this.sanaudosZiema = sanaudosZiema;
        this.degalutipas = degalutipas;
        this.sunaudojoDegalu = sunaudojoDegalu;
    }

    public Double getSunaudojoDegalu() {
        return sunaudojoDegalu;
    }

    public void setSunaudojoDegalu(Double sunaudojoDegalu) {
        this.sunaudojoDegalu = sunaudojoDegalu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSanaudosVasara() {
        return sanaudosVasara;
    }

    public void setSanaudosVasara(double sanaudosVasara) {
        this.sanaudosVasara = sanaudosVasara;
    }

    public double getSanaudosZiema() {
        return sanaudosZiema;
    }

    public void setSanaudosZiema(double sanaudosZiema) {
        this.sanaudosZiema = sanaudosZiema;
    }

    public Degalutipas getDegalutipas() {
        return degalutipas;
    }

    public void setDegalutipas(Degalutipas degalutipas) {
        this.degalutipas = degalutipas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum Degalutipas {
        BENZINAS,
        DYZELINAS,
        DUJOS
    }
}
