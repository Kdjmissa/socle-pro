/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.dto;

import socle.pro.secuirty.entity.Parametre;

/**
 *
 * @author kdjimissa
 */
public class StatutObjectDTO {

    private String id;
    private String code;
    private String libelle;
    private String action;
    private String color;
    private String codeCouleur;
    private String codeCouleurText;

    public StatutObjectDTO() {
    }

    public StatutObjectDTO(String id, String code, String libelle, String action, String color, String codeCouleur, String codeCouleurText) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.action = action;
        this.color = color;
        this.codeCouleur = codeCouleur;
        this.codeCouleurText = codeCouleurText;
    }

    
    public StatutObjectDTO(Parametre parametre) {
        this.id = parametre.getId();
        this.code= parametre.getCode();
        this.libelle = parametre.getLibelle();
        this.codeCouleur= parametre.getStatutBackColor();
        this.codeCouleurText= parametre.getStatutTextColor();
        this.action= parametre.getActionByStatut(parametre.getCode());
    }
    
    public StatutObjectDTO(String id, String libelle, String action, String color, String codeCouleur, String codeCouleurText) {
        this.id = id;
        this.libelle = libelle;
        this.action = action;
        this.color = color;
        this.codeCouleur = codeCouleur;
        this.codeCouleurText = codeCouleurText;
    }

//    StatutObjectDTO(String idStatut, String libelleStatut) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodeCouleur() {
        return codeCouleur;
    }

    public void setCodeCouleur(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }

    public String getCodeCouleurText() {
        return codeCouleurText;
    }

    public void setCodeCouleurText(String codeCouleurText) {
        this.codeCouleurText = codeCouleurText;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StatutObjectDTO{" + "id=" + id + ", code=" + code + ", libelle=" + libelle + ", action=" + action + ", color=" + color + ", codeCouleur=" + codeCouleur + ", codeCouleurText=" + codeCouleurText + '}';
    }

    

}
