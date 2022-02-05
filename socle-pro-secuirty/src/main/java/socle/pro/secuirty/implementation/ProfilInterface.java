/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.implementation;

import java.util.List;
import org.springframework.data.domain.Page;
import socle.pro.secuirty.dto.ProfilDTO;
import socle.pro.secuirty.entity.Profil;

/**
 *
 * @author Lenovo
 */
public interface ProfilInterface {
    public ProfilDTO saveProfil(ProfilDTO profilDTO);
    public ProfilDTO getProfil(String id);
    public Profil changeStatut(String id);
    public Page<Profil> profilListing(int page, int size , String sort);
    public void deleteProfil(String id);
    public ProfilDTO updateProfil(ProfilDTO profilDTO);
    
}
