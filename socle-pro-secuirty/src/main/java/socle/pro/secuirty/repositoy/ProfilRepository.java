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
import socle.pro.secuirty.dto.SimpleObjectDTO;
import socle.pro.secuirty.entity.Profil;

/**
 *
 * @author kdjimissa
 */
public interface ProfilRepository extends JpaRepository<Profil, String> {

    @Query("SELECT p FROM Profil  p where p.code=:code")
    public Profil findProfilByCode(@Param("code") String code);

    @Query("SELECT new socle.pro.secuirty.dto.SimpleObjectDTO(p.code,p.libelle) FROM Profil  p where p.statut.code=:code")
    public List<SimpleObjectDTO> findProfilByStatut(@Param("code") String code);
}
