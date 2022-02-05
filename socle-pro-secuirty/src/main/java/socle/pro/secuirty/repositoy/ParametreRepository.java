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
import socle.pro.secuirty.entity.Fonction;
import socle.pro.secuirty.entity.Parametre;

/**
 *
 * @author kdjimissa
 */
public interface ParametreRepository extends JpaRepository<Parametre, String> {

    @Query("SELECT p FROM Parametre p where p.code=:code and p.parametreEtiquette.code=:etiqCode")
    public Parametre findStatutByCodeAndEtiquetteCode(@Param("code") String code,@Param("etiqCode")String etiqCode);

    @Query("SELECT new socle.pro.secuirty.dto.SimpleObjectDTO(p) FROM Parametre p where p.parametreEtiquette.code=:code and p.parametreEtiquette.statut.code=:statutcode")
    public List<SimpleObjectDTO> findFonctionByParamEtiquetteCodeAndStatut(@Param("code") String code, @Param("statutcode") String statutcode);
    
    @Query("SELECT new socle.pro.secuirty.dto.SimpleObjectDTO(p) FROM Parametre p where p.parametreEtiquette.code=:code")
    public List<SimpleObjectDTO> findFonctionByParamEtiquette(@Param("code") String code);
}
