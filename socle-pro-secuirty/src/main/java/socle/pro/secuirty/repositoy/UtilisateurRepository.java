/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import socle.pro.secuirty.entity.Utilisateur;

/**
 *
 * @author Lenovo
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{
    
}
