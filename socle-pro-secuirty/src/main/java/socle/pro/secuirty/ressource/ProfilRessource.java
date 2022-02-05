/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.ressource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import socle.pro.secuirty.dto.ProfilDTO;
import socle.pro.secuirty.dto.SimpleObjectDTO;
import socle.pro.secuirty.entity.Profil;
import socle.pro.secuirty.repositoy.FonctionRepository;
import socle.pro.secuirty.repositoy.ParametreRepository;
import socle.pro.secuirty.services.ProfilService;
import socle.pro.secuirty.utils.Pager;
import socle.pro.secuirty.utils.SecurityConstant;

/**
 *
 * @author kdjimissa
 */
@RestController()
@RequestMapping(path = SecurityConstant.PROFIL_PATH_API_URL)
public class ProfilRessource {

    private static final String VALUE_RESP = "Responded";
    private static final String VALUE_TIMEZONE = "TimeZonesController";
    private static final String FONCTIONS = "fonctions";
    private static final String HABILITATIONS = "habilitations";

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};

    @Autowired
    private ProfilService profilService;

    @Autowired
    private FonctionRepository fonctionRepository;

    @Autowired
    private ParametreRepository parametreRepository;

    /**
     * @author: kokou Wama DJIMISSA
     * @since: 04/02/2022
     * @description: Cette ressource permet de charger la liste de toutes les
     * fonctions Activées
     * @return
     */
    @RequestMapping(value = "/loadFonction", method = RequestMethod.GET)
    public Object loadFonction() {
        Map<String, Object> p = new HashMap<>();
        List<SimpleObjectDTO> fonctions = fonctionRepository.findFonctionByStatut(SecurityConstant.STATUT_PARAM_EN_UTILISATION);
        p.put(FONCTIONS, fonctions);
        return p;
    }

    /**
     * @return @author: kokou Wama DJIMISSA
     * @since: 04/02/2022
     * @description: Cette ressource permet de charger les autorisations sur une
     * fonctionnalité.
     */
    @RequestMapping(value = "/loadNiveauHabilitation", method = RequestMethod.GET)
    public Object loadNiveauHabilitations() {
        Map<String, Object> p = new HashMap<>();
        List<SimpleObjectDTO> habilitations = parametreRepository.findFonctionByParamEtiquette(SecurityConstant.ACTION_ECRANS);
        p.put(HABILITATIONS, habilitations);
        return p;
    }

    /**
     *
     *
     * @param pageSize
     * @param page
     * @param motCle
     * @return
     */
    @RequestMapping(value = "/profils/{pageSize}/{page}", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> profils(@PathVariable("pageSize") Optional<Integer> pageSize,
            @PathVariable("page") Optional<Integer> page, @RequestParam(name = "motCle") Optional<String> motCle) {
        HashMap<String, Object> model = new HashMap<>();
        int valeurPagesize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int valeurPage = 0;

        if (page.isPresent()) {
            valeurPage = (page.orElse(0) < 1 ? INITIAL_PAGE : page.get() - 1);
        }
        Page<Profil> profils = this.profilService.profilListing(valeurPage, pageSize.get(), "");

        Pager pager = new Pager(profils.getTotalPages(), profils.getNumber(), BUTTONS_TO_SHOW);
        List<ProfilDTO> profilDTOs = new ArrayList<>();
        profils.getContent().forEach(profil -> {
            profilDTOs.add(this.profilService.convertToDTO(profil));
        });
        model.put("pageSizes", PAGE_SIZES);
        model.put("pager", pager);
        model.put("sequence", SecurityConstant.customNumberSequence(pager.getStartPage(), pager.getEndPage()));
        model.put("selectedPageSize", valeurPagesize);
        model.put("profils", profilDTOs);
        HttpHeaders headers = new HttpHeaders();
        headers.add(VALUE_RESP, VALUE_TIMEZONE);
        return ResponseEntity.accepted().headers(headers).body(model);
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getProfil/{id}", method = RequestMethod.GET)
    public Object getProfilDetails(@PathVariable("id") String id) {
        Map<String, Object> p = new HashMap<>();
        p.put("profilDTO", this.profilService.getProfil(id));
        return p;
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateProfil/{id}", method = RequestMethod.PUT)
    public Object updateProfil(@PathVariable("id") String id) {
        Map<String, Object> p = new HashMap<>();
        p.put("profilDTO", this.profilService.updateProfil(this.profilService.getProfil(id)));
        return p;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/changeProfilSatut/{id}", method = RequestMethod.PUT)
    public Object changeProfilStatut(@PathVariable("id") String id) {
        Map<String, Object> p = new HashMap<>();
        p.put("profilDTO", this.profilService.convertToDTO(this.profilService.changeStatut(id)));
        return p;
    }

    @RequestMapping(value = "/deleteProfil/{id}", method = RequestMethod.PUT)
    public Object deleteProfil(@PathVariable("id") String id) {
        Map<String, Object> p = new HashMap<>();
        this.profilService.deleteProfil(id);
        return p;
    }

    /**
     *
     *
     * @param profilDTO
     * @return 
     */
    @RequestMapping(value = "/saveProfil/{id}", method = RequestMethod.POST)
    public Object saveProfil(@RequestBody() ProfilDTO profilDTO) {
        Map<String, Object> p = new HashMap<>();
        p.put("profilDTO", this.profilService.saveProfil(profilDTO));
        return p;
    }

}
