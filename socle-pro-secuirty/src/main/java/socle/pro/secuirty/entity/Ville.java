/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import socle.pro.secuirty.utils.SecurityConstant;

/**
 *
 * @author NGS_004
 */
@Entity

@Table(name = "villes", schema = SecurityConstant.SCHEMA)
public class Ville implements Serializable {

    @Id
    @Column(name = "code", length = 15)
    private String code;
    @Column(name = "nom", length = 100)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "code_pays")
    private Pays pays;

    @Column(name = "actif")
    private boolean actif;

    public Ville() {
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Ville(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

}
