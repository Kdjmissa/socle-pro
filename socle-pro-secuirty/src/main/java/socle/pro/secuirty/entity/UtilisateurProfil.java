/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.entity;

import java.io.Serializable;
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
@Table(name = "utilisateur_profil", schema = SecurityConstant.SCHEMA)
public class UtilisateurProfil implements Serializable {

    @Id
    @Column(name = "id", length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @JoinColumn(name = "utilisateur_id")
    @ManyToOne
    private Utilisateur utilisateur;

    @JoinColumn(name = "profil_id")
    @ManyToOne
    private Profil profil;

    public UtilisateurProfil() {
    }

    public UtilisateurProfil(String id, Utilisateur utilisateur, Profil profil) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.profil = profil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    @Override
    public String toString() {
        return "UtilisateurProfil{" + "id=" + id + ", utilisateur=" + utilisateur + ", profil=" + profil + '}';
    }
    
}
