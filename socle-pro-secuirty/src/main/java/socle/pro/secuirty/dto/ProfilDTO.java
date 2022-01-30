/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author kdjimissa
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfilDTO {

    private String code;
    private String libelle;
    private StatutObjectDTO statut;
    private List<MapfonctionHabilitationDTO> fonctionHabilitationDTOs;
    private boolean saveOrUpdate = true;
    private boolean edit = false;
    private boolean estCree = false;
    private boolean estEnUtilisation = false;
    private boolean estObselete = false;

    public ProfilDTO() {
    }

    public ProfilDTO(String code, String libelle, StatutObjectDTO statut, List<MapfonctionHabilitationDTO> fonctionHabilitationDTOs) {
        this.code = code;
        this.libelle = libelle;
        this.statut = statut;
        this.fonctionHabilitationDTOs = fonctionHabilitationDTOs;
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

    public StatutObjectDTO getStatut() {
        return statut;
    }

    public void setStatut(StatutObjectDTO statut) {
        this.statut = statut;
    }

    public List<MapfonctionHabilitationDTO> getFonctionHabilitationDTOs() {
        return fonctionHabilitationDTOs;
    }

    public void setFonctionHabilitationDTOs(List<MapfonctionHabilitationDTO> fonctionHabilitationDTOs) {
        this.fonctionHabilitationDTOs = fonctionHabilitationDTOs;
    }

    public boolean isSaveOrUpdate() {
        return saveOrUpdate;
    }

    public void setSaveOrUpdate(boolean saveOrUpdate) {
        this.saveOrUpdate = saveOrUpdate;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isEstCree() {
        return estCree;
    }

    public void setEstCree(boolean estCree) {
        this.estCree = estCree;
    }

    public boolean isEstEnUtilisation() {
        return estEnUtilisation;
    }

    public void setEstEnUtilisation(boolean estEnUtilisation) {
        this.estEnUtilisation = estEnUtilisation;
    }

    public boolean isEstObselete() {
        return estObselete;
    }

    public void setEstObselete(boolean estObselete) {
        this.estObselete = estObselete;
    }

    @Override
    public String toString() {
        return "ProfilDTO{" + "code=" + code + ", libelle=" + libelle + ", statut=" + statut + ", fonctionHabilitationDTOs=" + fonctionHabilitationDTOs + ", saveOrUpdate=" + saveOrUpdate + ", edit=" + edit + ", estCree=" + estCree + ", estEnUtilisation=" + estEnUtilisation + ", estObselete=" + estObselete + '}';
    }
    
    
}
