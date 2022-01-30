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

/**
 *
 * @author kdjimissa
 */
public interface FonctionRepository extends JpaRepository<Fonction, String> {

    @Query("SELECT f FROM Fonction f where f.id=:id")
    public Fonction findFonctionById(@Param("id") String id);

    @Query("SELECT new socle.pro.secuirty.dto.SimpleObjectDTO(f) FROM Fonction f where f.statut.code=:codeStatut")
    public List<SimpleObjectDTO>findFonctionByStatut(@Param("codeStatut") String codeStatut);
}
