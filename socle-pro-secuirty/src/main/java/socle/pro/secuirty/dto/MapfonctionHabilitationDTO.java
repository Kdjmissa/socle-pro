/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.dto;

import socle.pro.secuirty.entity.ProfilFonctions;



/**
 *
 * @author kdjimissa
 */
public class MapfonctionHabilitationDTO {

    private String id;
//    @NotBlank(message = SocleConstant.F_REQUIERD)
    private String idFonction;

    private String codeFonction;
    private String libelleFonction;

//    @NotBlank(message = SocleConstant.F_REQUIERD)
    private String idHabilitation;
    private String codeHabilitation;
    private String libelleHabilitation;
    private String idProfil;
    private String libelleProfil;
    private boolean edit = false;

    public MapfonctionHabilitationDTO() {
    }

    
     public MapfonctionHabilitationDTO(ProfilFonctions profilFonctions) {
        this.id = profilFonctions.getId();
        this.idFonction = profilFonctions.getFonction().getId();
        this.codeFonction = profilFonctions.getFonction().getCode();
        this.libelleFonction = profilFonctions.getFonction().getLibelle();
        this.idHabilitation = profilFonctions.getHabilitation().getId();
        this.codeHabilitation = profilFonctions.getHabilitation().getCode();
        this.libelleHabilitation = profilFonctions.getHabilitation().getLibelle();
        this.idProfil = profilFonctions.getProfil().getCode();
        this.libelleProfil = profilFonctions.getProfil().getLibelle();
    }
    
    public MapfonctionHabilitationDTO(String id, String idFonction, String codeFonction, String libelleFonction, String idHabilitation, String codeHabilitation, String libelleHabilitation, String idProfil, String libelleProfil) {
        this.id = id;
        this.idFonction = idFonction;
        this.codeFonction = codeFonction;
        this.libelleFonction = libelleFonction;
        this.idHabilitation = idHabilitation;
        this.codeHabilitation = codeHabilitation;
        this.libelleHabilitation = libelleHabilitation;
        this.idProfil = idProfil;
        this.libelleProfil = libelleProfil;
        this.edit = true;
    }

    public MapfonctionHabilitationDTO(String idFonction, String codeFonction, String libelleFonction, String idHabilitation, String codeHabilitation, String libelleHabilitation) {
        this.idFonction = idFonction;
        this.codeFonction = codeFonction;
        this.libelleFonction = libelleFonction;
        this.idHabilitation = idHabilitation;
        this.codeHabilitation = codeHabilitation;
        this.libelleHabilitation = libelleHabilitation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(String idFonction) {
        this.idFonction = idFonction;
    }

    public String getCodeFonction() {
        return codeFonction;
    }

    public void setCodeFonction(String codeFonction) {
        this.codeFonction = codeFonction;
    }

    public String getLibelleFonction() {
        return libelleFonction;
    }

    public void setLibelleFonction(String libelleFonction) {
        this.libelleFonction = libelleFonction;
    }

    public String getIdHabilitation() {
        return idHabilitation;
    }

    public void setIdHabilitation(String idHabilitation) {
        this.idHabilitation = idHabilitation;
    }

    public String getCodeHabilitation() {
        return codeHabilitation;
    }

    public void setCodeHabilitation(String codeHabilitation) {
        this.codeHabilitation = codeHabilitation;
    }

    public String getLibelleHabilitation() {
        return libelleHabilitation;
    }

    public void setLibelleHabilitation(String libelleHabilitation) {
        this.libelleHabilitation = libelleHabilitation;
    }

    public String getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(String idProfil) {
        this.idProfil = idProfil;
    }

    public String getLibelleProfil() {
        return libelleProfil;
    }

    public void setLibelleProfil(String libelleProfil) {
        this.libelleProfil = libelleProfil;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    @Override
    public String toString() {
        return "MapfonctionHabilitationDTO{" + "idFonction=" + idFonction
                + ", codeFonction=" + codeFonction
                + ", libelleFonction=" + libelleFonction
                + ", idHabilitation=" + idHabilitation
                + ", codeHabilitation=" + codeHabilitation
                + ", libelleHabilitation=" + libelleHabilitation
                + ", idProfil=" + idProfil
                + ", libelleProfil=" + libelleProfil + '}';
    }

}
