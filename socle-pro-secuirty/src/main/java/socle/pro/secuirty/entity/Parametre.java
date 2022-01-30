package socle.pro.secuirty.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @since 25/01/2022
 */
@Entity
@Table(name = "parametre", schema = SecurityConstant.SCHEMA)
public class Parametre extends  MappedEntity implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "param_etiquette", referencedColumnName = "code")
    private ParametreEtiquette parametreEtiquette;

    @Column(name = "code", length = 100)
    private String code;

    @Column(name = "libelle", length = 100)
    private String libelle;

    @Column(name = "dernier_numero")
    private Integer dernierNumero = 0;

    public String getStatutBackColor() {
        if (this.code == null) {
            return "";
        }
        switch (this.code) {
            case SecurityConstant.STATUT_PARAM_CREE:
                return SecurityConstant.COLOR_CREE;
            case SecurityConstant.STATUT_PARAM_EN_UTILISATION:
                return SecurityConstant.COLOR_EN_UTILISATION;
            case SecurityConstant.STATUT_PARAM_OBSOLETE:
                return SecurityConstant.COLOR_ABANDONNER;
            default:
                return "";
        }
    }

    public String getActionByStatut(String code) {
//        System.out.println(" CODE " + code);
        if (this.code == null) {
            return "";
        }
        switch (this.code) {
            case SecurityConstant.STATUT_PARAM_CREE:
                return SecurityConstant.ACTION_EN_UTILISATION;
            case SecurityConstant.STATUT_PARAM_EN_UTILISATION:
                return SecurityConstant.ACTION_ABANDONNER;
            default:
                return "";
        }
    }

    public String getStatutTextColor() {
        if (this.code == null) {
            return "";
        }
        return SecurityConstant.COLOR_WHITE;
    }

    public static String getNextStatutBackColor(String current) {
        String codeCouleur = "";
        if (current.equals(SecurityConstant.STATUT_PARAM_CREE)) {
            codeCouleur = SecurityConstant.COLOR_EN_UTILISATION;
        }
        if (current.equals(SecurityConstant.STATUT_PARAM_EN_UTILISATION)) {
            codeCouleur = SecurityConstant.COLOR_ABANDONNER;
        } else if (current.equals(SecurityConstant.STATUT_PARAM_OBSOLETE)) {
            codeCouleur = "red";
        }
        return codeCouleur;
    }

    public static String getNextStatutColor(String current) {
        if (current.equals(SecurityConstant.STATUT_PARAM_EN_UTILISATION)) {
            return SecurityConstant.COLOR_WHITE;
        }
        if (current.equals(SecurityConstant.STATUT_PARAM_CREE)) {
            return SecurityConstant.COLOR_WHITE;
        } else {
            return SecurityConstant.COLOR_WHITE;
        }
    }

    public static String getNextStatutIdeCode(String current) {
        if (current.equals(SecurityConstant.STATUT_PARAM_CREE)) {
            return SecurityConstant.STATUT_PARAM_EN_UTILISATION;
        }
        if (current.equals(SecurityConstant.STATUT_PARAM_EN_UTILISATION)) {
            return SecurityConstant.STATUT_PARAM_OBSOLETE;
        } else {
            return "";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParametreEtiquette getParametreEtiquette() {
        return parametreEtiquette;
    }

    public void setParametreEtiquette(ParametreEtiquette parametreEtiquette) {
        this.parametreEtiquette = parametreEtiquette;
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

    public Integer getDernierNumero() {
        return dernierNumero;
    }

    public void setDernierNumero(Integer dernierNumero) {
        this.dernierNumero = dernierNumero;
    }

    @Override
    public String toString() {
        return "Parametre{" + "id=" + id + ", parametreEtiquette=" + parametreEtiquette + ", code=" + code + ", libelle=" + libelle + ", dernierNumero=" + dernierNumero + '}';
    }

}
