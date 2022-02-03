/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socle.pro.secuirty.dto.MapfonctionHabilitationDTO;
import socle.pro.secuirty.dto.ProfilDTO;
import socle.pro.secuirty.dto.StatutObjectDTO;
import socle.pro.secuirty.entity.Parametre;
import socle.pro.secuirty.entity.Profil;
import socle.pro.secuirty.implementation.ProfilInterface;
import socle.pro.secuirty.puglin.InterneExpection;
import socle.pro.secuirty.repositoy.ParamEtiquetteRepository;
import socle.pro.secuirty.repositoy.ParametreRepository;
import socle.pro.secuirty.repositoy.ProfilFonctionRepository;
import socle.pro.secuirty.repositoy.ProfilRepository;
import socle.pro.secuirty.utils.SecurityConstant;

/**
 *
 * @author kdjimissa
 */
@Service
public class ProfilService implements ProfilInterface {

    @Autowired
    private ProfilRepository profilRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProfilFonctionRepository profilFonctionRepository;

    @Autowired
    private ParametreRepository parametreRepository;

    @Autowired
    private ParamEtiquetteRepository paramEtiquetteRepository;

    @Override
    public ProfilDTO saveProfil(ProfilDTO profilDTO) {
        this.profilValidation(profilDTO);
        Profil p = new Profil();
        p.setCode(profilDTO.getCode());
        p.setLibelle(profilDTO.getLibelle());
        p.setStatut(this.parametreRepository.findStatutByCodeAndEtiquetteCode(SecurityConstant.STATUT_PARAM_ETIQUETTE,
                SecurityConstant.STATUT_PARAM_CREE));
        p.setDernierNumero(this.profilRepository.findDernierNumeroProfil().get());
        this.profilRepository.save(p);

        return this.convertToDTO(p);
    }

    @Override
    public ProfilDTO getProfil(String id) {
        ProfilDTO profilDTO = new ProfilDTO();
        Profil p = this.profilRepository.findProfilByCode(id);
        if (p != null) {
            profilDTO.setCode(p.getCode());
            profilDTO.setLibelle(p.getLibelle());
            profilDTO.setSaveOrUpdate(false);
            profilDTO.setEdit(false);
            profilDTO.setFonctionHabilitationDTOs(this.getProfilHabilitations(p));
            profilDTO.setStatut(new StatutObjectDTO(p.getStatut()));
        } else {
            throw new InterneExpection("Ce profil n'existe pas ", null);
        }
        return profilDTO;
    }

    @Override
    public Profil changeStatut(String id) {
        Profil p = this.profilRepository.findProfilByCode(id);
        String newCodeStatut = "";

        if (p != null && p.getStatut() != null) {
            switch (p.getStatut().getCode()) {
                case SecurityConstant.STATUT_PARAM_CREE:
                    newCodeStatut = SecurityConstant.STATUT_PARAM_EN_UTILISATION;
                    break;
                case SecurityConstant.STATUT_PARAM_EN_UTILISATION:
                    newCodeStatut = SecurityConstant.COLOR_ABANDONNER;
                    break;
                case SecurityConstant.STATUT_PARAM_OBSOLETE:
                    newCodeStatut = SecurityConstant.COLOR_ABANDONNER;
                    break;
                default:
                    newCodeStatut = p.getStatut().getCode();
                    break;
            }
        } else {
            throw new InterneExpection("Ce profil n'existe pas ", null);
        }
        p.setStatut(this.parametreRepository.findStatutByCodeAndEtiquetteCode(newCodeStatut, SecurityConstant.STATUT_PARAM_ETIQUETTE));
        return this.profilRepository.save(p);
    }

    @Override
    public List<ProfilDTO> profilListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProfil(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProfilDTO convertToDTO(Profil profil) {
        ProfilDTO profilDTO = modelMapper.map(profil, ProfilDTO.class);
        if (profil != null) {
            profilDTO.setSaveOrUpdate(false);
            profilDTO.setEdit(false);
            profilDTO.setFonctionHabilitationDTOs(this.getProfilHabilitations(profil));
            profilDTO.setStatut(new StatutObjectDTO(profil.getStatut()));
        } else {
            throw new InterneExpection(" Ce profil n'existe pas ", null);
        }
        return profilDTO;
    }

    public Profil convertToEntity(ProfilDTO profilDTO) {
        Profil profil = modelMapper.map(profilDTO, Profil.class);
        return profil;
    }

    /**
     *
     * @param profil
     * @return
     */
    public List<MapfonctionHabilitationDTO> getProfilHabilitations(Profil profil) {
        return this.profilFonctionRepository.findProfilFonctionByProfilId(profil.getCode());
    }

    public void profilValidation(ProfilDTO profilDTO) {
        if (profilDTO.getCode() == null) {
            throw new InterneExpection("Le code est obligatoire ", null);
        } else if (this.profilRepository.findProfilByCode(profilDTO.getCode()) != null) {
            throw new InterneExpection("Un profil avec ce code existe déjà. Le code doit être unique ", null);
        }

        if (profilDTO.getLibelle() == null) {
            throw new InterneExpection("Libelle obligatoire ", null);
        }
    }

    @Override
    public ProfilDTO updateProfil(ProfilDTO profilDTO) {
        Profil profil = new Profil();
        profil.setCode(profilDTO.getCode());
        profil.setLibelle(profilDTO.getLibelle());
        profil = this.profilRepository.save(profil);
        profilDTO = this.getProfil(profil.getCode());
        return profilDTO;
    }
}
