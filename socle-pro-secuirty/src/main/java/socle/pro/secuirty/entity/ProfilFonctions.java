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
@Table(name = "fonctions_profils", schema = SecurityConstant.SCHEMA)
public class ProfilFonctions extends MappedEntity implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @ManyToOne()
    @JoinColumn(name = "code_fonction", referencedColumnName = "id")
    private Fonction fonction;
    @ManyToOne()
    @JoinColumn(name = "niveau_habilitation", referencedColumnName = "id")
    private Parametre habilitation;

    @ManyToOne()
    @JoinColumn(name = "code_profil", referencedColumnName = "code")
    private Profil profil;

    public ProfilFonctions() {
    }

    public ProfilFonctions(String id, Fonction fonction, Parametre habilitation, Profil profil) {
        this.id = id;
        this.fonction = fonction;
        this.habilitation = habilitation;
        this.profil = profil;
    }

    public ProfilFonctions(String id, Fonction fonction, Profil profil) {
        this.id = id;
        this.fonction = fonction;
        this.profil = profil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Parametre getHabilitation() {
        return habilitation;
    }

    public void setHabilitation(Parametre habilitation) {
        this.habilitation = habilitation;
    }

    @Override
    public String toString() {
        return "ProfilFonctions{" + "id=" + id + ", fonction=" + fonction + ", habilitation=" + habilitation + ", profil=" + profil + '}';
    }

}
