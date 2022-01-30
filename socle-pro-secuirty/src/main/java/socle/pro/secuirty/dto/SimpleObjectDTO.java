/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.dto;

import socle.pro.secuirty.entity.Fonction;
import socle.pro.secuirty.entity.Parametre;
import socle.pro.secuirty.entity.ParametreEtiquette;

/**
 *
 * @author kdjimissa
 */
public class SimpleObjectDTO {

    private String id;
    private String code;
    private String libelle;

    public SimpleObjectDTO() {
    }

    public SimpleObjectDTO(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public SimpleObjectDTO(String id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }

    public SimpleObjectDTO(ParametreEtiquette etiquette) {
        this.id = etiquette.getCode();
        this.libelle = etiquette.getLibelle();
    }

    public SimpleObjectDTO(Parametre parametre) {
        this.id = parametre.getId();
        this.code = parametre.getCode();
        this.libelle = parametre.getLibelle();
    }

    public SimpleObjectDTO(Fonction fonction) {
        this.id = fonction.getId();
        this.code = fonction.getCode();
        this.libelle = fonction.getLibelle();
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

    @Override
    public String toString() {
        return "SimpleObjectDTO{" + "id=" + id + ", code=" + code + ", libelle=" + libelle + '}';
    }
}
