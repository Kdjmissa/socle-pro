/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.services;

import java.util.List;
import org.springframework.stereotype.Service;
import socle.pro.secuirty.dto.ProfilDTO;
import socle.pro.secuirty.implementation.ProfilInterface;

/**
 *
 * @author kdjimissa
 */
@Service
public class ProfilService implements ProfilInterface{

    @Override
    public ProfilDTO saveOrUpdateProfil(ProfilDTO profilDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfilDTO getProfil(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfilDTO changeStatut(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProfilDTO> profilListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProfil(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
