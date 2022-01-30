package socle.pro.secuirty.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import socle.pro.secuirty.utils.SecurityConstant;

/**
 *
 * @author kdjimissa
 * @since: 26/01/2022
 */
@Entity
@Table(name = "group_fonctions", schema = SecurityConstant.SCHEMA)
public class GroupFonction extends MappedEntity implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "libelle", length = 100)
    private String libelle;

    @ManyToOne()
    @JoinColumn(name = "code_statut", referencedColumnName = "id")
    private Parametre statut;
    
    @Column(name = "dernier_numero")
    private Integer dernierNumero = 0;

    public GroupFonction() {
    }

    public GroupFonction(String id, String code, String libelle, Parametre statut) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "GroupFonction{" + "id=" + id + ", code=" + code + ", libelle=" + libelle + ", statut=" + statut + ", dernierNumero=" + dernierNumero + '}';
    }

}
