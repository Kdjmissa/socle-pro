/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import socle.pro.secuirty.entity.Fonction;
import socle.pro.secuirty.entity.ParametreEtiquette;

/**
 *
 * @author kdjimissa
 * @since:03/02/2022
 */
public interface ParamEtiquetteRepository extends JpaRepository<ParametreEtiquette, String>{
    
    
     @Query("SELECT pet FROM ParametreEtiquette pet where pet.code=:code")
    public ParametreEtiquette findParamEtiquetteByCode(@Param("code") String code);
}
