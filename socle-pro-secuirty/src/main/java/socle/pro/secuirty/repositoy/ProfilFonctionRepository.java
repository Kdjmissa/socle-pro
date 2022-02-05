/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.repositoy;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import socle.pro.secuirty.dto.MapfonctionHabilitationDTO;
import socle.pro.secuirty.entity.ProfilFonctions;

/**
 *
 * @author kdjimissa
 */
public interface ProfilFonctionRepository extends JpaRepository<ProfilFonctions, String> {

    @Query("SELECT fp FROM ProfilFonctions fp where fp.id=:id")
    public ProfilFonctions findProfilFonctionById(@Param("id") String id);

    @Query("SELECT new socle.pro.secuirty.dto.MapfonctionHabilitationDTO(fp) FROM ProfilFonctions fp where fp.profil.code=:id")
    public List<MapfonctionHabilitationDTO> findProfilFonctionByProfilId(@Param("id") String id);
    
    @Query("SELECT new socle.pro.secuirty.dto.MapfonctionHabilitationDTO(fp) FROM ProfilFonctions fp where fp.profil.code=:id and fp.profil.statut.code=:statutCode")
    public List<MapfonctionHabilitationDTO> findProfilFonctionByProfilIdAndStatut(@Param("id") String id,@Param("statutCode") String statutCode);

    @Query("SELECT fp FROM ProfilFonctions fp where fp.profil.code=:code")
    public List<ProfilFonctions> findByProfilId( @Param("code") String code);
}
