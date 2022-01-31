/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Kdjimissa
 * Created: 13 Octobre 2019
 * Edited : 25 Janvier 2022
 */
INSERT INTO socle.parametre_etiquette(
            code, libelle, code_statut)
    VALUES 
('ACTIONS_ECRAN', 'Les actions écrans', NULL),
('WORKFLOW_PARAM', 'Workflow standard des objets', NULL),
('MOBILE_MOYENTPAI', 'Les moyens de paiement', NULL),
('WORKFLOW_DEFAUT_OBJET', 'List worflow par défaut des actions', NULL),
('CODIFICATION_OUI_NON', 'OUI / NON', NULL),
('CODIFICATION_CONCEPT_METIER', 'Concept Métier', NULL)
ON CONFLICT (code) DO UPDATE 
SET libelle= EXCLUDED.libelle,
code_statut= EXCLUDED.code_statut;


INSERT INTO socle.parametre(
            id, code, libelle, param_etiquette)
    VALUES 
('WORK001', 'CRE', 'Crée', 'WORKFLOW_PARAM'),
('WORK002', 'ENUT', 'En Utilisation', 'WORKFLOW_PARAM'),
('WORK003', 'AB', 'Abandonné', 'WORKFLOW_PARAM'),
('ACTE001', '1', 'Lire', 'ACTIONS_ECRAN'),
('ACTE002', '2', 'Saisir', 'ACTIONS_ECRAN'),
('ACTE003', '3', 'Valider', 'ACTIONS_ECRAN'),
('ACTE004', '4', 'Administrer', 'ACTIONS_ECRAN'),

('MP001', 'TM', 'T-money', 'MOBILE_MOYENTPAI'),
('MP002', 'FLZ', 'Flooz', 'MOBILE_MOYENTPAI'),
('MP003', 'MTNM', 'MTN money', 'MOBILE_MOYENTPAI'),
('MP004', 'MTNM', 'Orange money', 'MOBILE_MOYENTPAI'),
('MP005', 'ATELM', 'Airtel money', 'MOBILE_MOYENTPAI'),
('MP006', 'PYPAL', 'Paypal', 'MOBILE_MOYENTPAI'),
('MP007', 'VB', 'Virement bancaire', 'MOBILE_MOYENTPAI'),
('WK001', 'AC', 'Activer', 'WORKFLOW_DEFAUT_OBJET'),
('WK002', 'IA', 'Inactif', 'WORKFLOW_DEFAUT_OBJET'),
('CODE001', 'O', 'OUI', 'CODIFICATION_OUI_NON'),
('CODE002', 'N', 'NON', 'CODIFICATION_OUI_NON'),
('CONCEP_METIER_PROFIL', 'PUTCPT', 'Concept Métier des profils utilisateur', 'CODIFICATION_CONCEPT_METIER'),
('CONCEP_METIER_UTILISATEUR', 'UTCPT', 'Concept Métier des utilisateurs', 'CODIFICATION_CONCEPT_METIER')
ON CONFLICT (id) DO UPDATE 
SET code= EXCLUDED.code,
 libelle= EXCLUDED.libelle,
param_etiquette= EXCLUDED.param_etiquette;


INSERT INTO socle.group_fonctions(
            id, code, libelle, code_statut)
    VALUES ('GP001', 'GP_PARAM', 'Les fonctions de paramètrage', 'WORK002')
ON CONFLICT (id) DO UPDATE 
SET code= EXCLUDED.code,
 libelle= EXCLUDED.libelle,
code_statut=EXCLUDED.code_statut;


INSERT INTO socle.fonctions(
            id, code, libelle, group_fonction, code_statut)
    VALUES 
('FCT001', 'FCT_GEST_USER', 'Gestion des Utilisateurs', 'GP001', 'WORK002'),
('FCT002', 'FCT_GEST_PRFL', 'Gestion des Profils', 'GP001', 'WORK002'),
('FCT003', 'FCT_APP_PARAM', 'App paramètres', 'GP001', 'WORK002')
ON CONFLICT (id) DO UPDATE 
SET code= EXCLUDED.code,
 libelle= EXCLUDED.libelle,
code_statut=EXCLUDED.code_statut;


/**LISTE DES PAYS**/
INSERT INTO  socle.pays(alpha_2,alpha_3,nom,indicatif,actif,domaine_internet) 
VALUES 
('TG','TOG','Togo','+228','true','.tg'),
('BJ','BNI','Benin','+229','false','.bj'),
('BF','BFA','Burkina Faso','+225','false','.bf'),
('CI','CIV','Côte d’Ivoire','+229','false','.ci'),
('GW','GNB','Guinée Bissau','+245','false','.gw'),
('ML','MLI','Mali','+223','false','.ml'),
('NI','NER','Niger','+227','false','.ni'),
('SN','SEN','Sénégal','+221','false','.sn'),
('CG','CGB','Congo-Brazzaville','+242','false','.cg')
ON CONFLICT (alpha_2) DO UPDATE 
SET
nom= EXCLUDED.nom,
indicatif =EXCLUDED.indicatif,
actif =EXCLUDED.actif
;
-- 

/**LISTE DES PAYS**/
INSERT INTO  socle.villes(code,code_pays,nom,actif) 
VALUES 

('0001','TG','Sokode','true'),
('0002','TG','Kpalime','true'),
('0003','TG','Atakpame','true'),
('0004','TG','Kara','true'),
('0005','TG','Aneho','true'),
('0006','TG','Dapaong','true'),
('0007','TG','Tsévié','true'),
('0008','TG','Bassar','true'),
('0009','TG','Badou','true'),
('00010','TG','Notsè','true'),
('00011','TG','Vogan','true'),
('00012','TG','Togoville','true'),
('00013','TG','Niamtougou','true'),
('00014','TG','Kandé','true'),
('00015','TG','Bafilo','true'),
('00016','TG','Bandjéli','true'),
('00017','TG','Baguida','true'),
('00018','TG','Agbodrafo','true'),
('00019','TG','Tabligbo','true'),
('00020','TG','Tchamba','true'),
('00024','TG','Mango','true'),
('00021','TG','Amlamé','true'),
('00022','TG','Sotouboua','true'),
('00023','TG','Djarkpanga','true'),

('00025','TG','Kpagouda','true'),
('00026','TG','Guérin-kouka','true'),
('00027','TG','Blita','true'),
('00028','TG','Ketao','true'),
('00029','TG','Galangachi','true'),
('00030','TG','Anié','true'),
('00031','TG','Tado','true'),

('00032','TG','Pya','true'),
('00033','TG','Ahépé','true'),
('00035','TG','Alédjo kadara','true'),

('00036','TG','Biankouri','true'),
('00037','TG','Tandouaré','true'),
('00038','TG','Tchèkpo-dédékpoè','true'),
('00039','TG','Anfané','true'),
('00040','TG','Afagnan','true'),

('00041','TG','Namoudjogo','true'),
('00042','TG','Cincassé','true'),
('00051','TG','Kovié','true'),
('00043','TG','Lakata','true'),
('00044','TG','Gassema','true'),
('00045','TG','Yadé','true'),
('00046','TG','Sara-kawa','true'),
('00047','TG','Garimbombe','true'),
('00048','TG','Gbanbale','true'),
('00049','TG','Kévé','true'),
('00050','TG','Assahoun','true'),
('00052','TG','Lome','true')
ON CONFLICT (code) DO UPDATE 
SET
code_pays= EXCLUDED.code_pays,
nom =EXCLUDED.nom,
actif =EXCLUDED.actif;

 

INSERT INTO socle.utilisateur(
            id, nom, prenoms, pseudo, mot_de_passe, email, telephone, profession, 
  pays, ville, code_statut, moyen_paiement, num_moyen_paiement, 
            banque, num_compte, referent, reference_transfert, dernier_numero, 
            num_sec)
    VALUES ('37c42f09-5089-424c-bf8f-574ac1689f28','ADMIN','ADMIN',
'admin','$2a$12$wOHCwsRsJ9qCnjCMdzfCRu6tkv28I/IgcrjX1SdbyjrPrNP1eEhLu','admin@gmail.com',NULL,NULL,NULL,NULL,'WK001',NULL,NULL,NULL,NULL,NULL,NULL,22,'055432954')
ON CONFLICT (id)
DO UPDATE
SET 
nom=EXCLUDED.nom,
code_statut=EXCLUDED.code_statut,
mot_de_passe=EXCLUDED.mot_de_passe
;


