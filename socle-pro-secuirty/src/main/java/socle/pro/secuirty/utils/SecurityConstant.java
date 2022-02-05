/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdjimissa
 * @since: 25/01/2022
 */
public class SecurityConstant {

    public static final String SCHEMA = "socle";
    public static final String STATUT_PARAM_ETIQUETTE = "WORKFLOW_PARAM";
    public static final String ACTION_ECRANS = "ACTIONS_ECRAN";
    public static final String STATUT_PARAM_CREE = "CRE";

    public static final String ID_STATUT_PARAM_CREE = "WORK001";
    public static final String COLOR_CREE = "#1164A3";
    public static final String ACTION_EN_UTILISATION = "Activer";
    public static final String ACTION_ABANDONNER = "Abandonner";
    public static final String COLOR_EN_UTILISATION = "#a4ca3a";
    public static final String STATUT_PARAM_OBSOLETE = "AB";
    public static final String ID_STATUT_PARAM_OBSOLETE = "WORK003";
    public static final String COLOR_ABANDONNER = "#EE0000";
    public static final String STATUT_PARAM_EN_UTILISATION = "ENUT";
    public static final String ID_STATUT_PARAM_EN_UTILISATION = "WORK002";
    public static final String COLOR_WHITE = "#fff";
    public static String DEFAULT_PHOTO = "assets/images/users/avatar-1.jpg";

    public static final String API_PHOTO = "/api/photo";
    public static String NOMBRE_CARAC_REFERENT = "12";

    public static final String PROFIL_PATH_API_URL = "/profil/api";

    public static Object[] customNumberSequence(Integer from, Integer to) {
        List<Integer> value = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            value.add(i);
        }
        return value.toArray();
    }

}
