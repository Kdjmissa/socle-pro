package socle.pro.secuirty.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author kdjimissa
 * @since: 26/01/2022
 */
@Entity
@Table(name = "profil", schema = SecurityConstant.SCHEMA)
public class Profil extends MappedEntity implements Serializable {

    @Id
    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "libelle", length = 100)
    private String libelle;

    @ManyToOne()
    @JoinColumn(name = "code_statut", referencedColumnName = "id")
    private Parametre statut;

    @Column(name = "dernier_numero")
    private Integer dernierNumero = 0;

    public Profil(String code, String libelle, Parametre statut) {
        this.code = code;
        this.libelle = libelle;
        this.statut = statut;
    }

    public Profil(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Parametre getStatut() {
        return statut;
    }

    public void setStatut(Parametre statut) {
        this.statut = statut;
    }
    public Integer getDernierNumero() {
        return dernierNumero;
    }

    public void setDernierNumero(Integer dernierNumero) {
        this.dernierNumero = dernierNumero;
    }

    @Override
    public String toString() {
        return "Profil{" + "code=" + code + ", libelle=" + libelle + ", statut=" + statut + ", dernierNumero=" + dernierNumero + '}';
    }    

}
