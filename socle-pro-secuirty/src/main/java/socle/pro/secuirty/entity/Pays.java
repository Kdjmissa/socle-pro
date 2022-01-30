/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import socle.pro.secuirty.utils.SecurityConstant;

/**
 *
 * @author kdjimissa
 * @since: 26/01/2022
 */
@Entity
@Table(name = "pays", schema = SecurityConstant.SCHEMA)
public class Pays implements Serializable {

    @Id
    @Column(name = "alpha_2", length = 2)
    private String alpha2;

    @Column(name = "alpha_3", length = 3)
    private String alpha3;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "indicatif", length = 10)
    private String indicatif;
    @Column(name = "actif")
    private boolean actif;

    @Column(name = "domaine_internet", length = 3)
    private String domaineInternet;

    @Lob
    @Column(name = "drapeau")
    private byte[] drapeau;

    @Column(name = "content_type")
    private String contentType;

    public Pays() {
    }

    public Pays(String alpha2, String alpha3, String nom, String indicatif, boolean actif, String domaineInternet, byte[] drapeau, String contentType) {
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.nom = nom;
        this.indicatif = indicatif;
        this.actif = actif;
        this.domaineInternet = domaineInternet;
        this.drapeau = drapeau;
        this.contentType = contentType;
    }

   

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getIndicatif() {
        return indicatif;
    }

    public void setIndicatif(String indicatif) {
        this.indicatif = indicatif;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getDomaineInternet() {
        return domaineInternet;
    }

    public void setDomaineInternet(String domaineInternet) {
        this.domaineInternet = domaineInternet;
    }

    public byte[] getDrapeau() {
        return drapeau;
    }

    public void setDrapeau(byte[] drapeau) {
        this.drapeau = drapeau;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.alpha3);
        hash = 23 * hash + Objects.hashCode(this.nom);
        hash = 23 * hash + Objects.hashCode(this.alpha2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pays other = (Pays) obj;
        if (!Objects.equals(this.alpha3, other.alpha3)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.alpha2, other.alpha2);
    }

    @Override
    public String toString() {
        return "Pays{" + "alpha2=" + alpha2 + ", alpha3=" + alpha3 + ", nom=" + nom + ", indicatif=" + indicatif + ", actif=" + actif + ", domaineInternet=" + domaineInternet + ", drapeau=" + drapeau + ", contentType=" + contentType + '}';
    }

}
