/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.entity;

/**
 *
 * @author kdjimissa
 * @since: 26/01/2022
 */
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import socle.pro.secuirty.utils.SecurityConstant;

@Entity
@Table(name = "utilisateur", schema = SecurityConstant.SCHEMA)
public class Utilisateur extends MappedEntity implements Serializable {

    @Id
    @Column(name = "id", length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenoms")
    private String prenom;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "mot_de_passe")
    private String motDepasse;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "profession")
    private String profession;

    @Column(name = "content_type")
    private String contentType;

    @Lob
    @Column(name = "content")
    private byte[] pictureContent;

    @Column(name = "activation_key_expiration_date")
    private Instant activationExpireDate;

    @Column(name = "reset_key_expiration_date")
    private Instant resetKeyExpireDate;
    
    @Column(name = "pays")
    private String pays;

    @Column(name = "ville")
    private String ville;

    @ManyToOne()
    @JoinColumn(name = "code_statut", referencedColumnName = "id")
    private Parametre statut;

    @ManyToOne()
    @JoinColumn(name = "moyen_paiement", referencedColumnName = "id")
    private Parametre moyenPaiement;

    @Column(name = "num_moyen_paiement")
    private String numeroMoyenPaiement;

    @Column(name = "banque")
    private String banque;

    @Column(name = "num_compte")
    private String numeroDeCompte;

    @Column(name = "referent")
    private String referent;

    @Column(name = "reference_transfert")
    private String referenceTransfert;

    @Column(name = "dernier_numero")
    private Integer dernierNumero = 0;

    @Column(name = "num_sec")
    private String numeroSecurite;
    @Transient
    private Set<String> authorities;

    public Utilisateur() {
    }

    public Utilisateur(String id, String nom, String prenom, String pseudo, String motDepasse, String email, String telephone, String profession, String contentType, byte[] pictureContent, Instant activationExpireDate, Instant resetKeyExpireDate, String pays, String ville, Parametre statut, Parametre moyenPaiement, String numeroMoyenPaiement, String banque, String numeroDeCompte, String referent, String referenceTransfert, String numeroSecurite, Set<String> authorities) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.motDepasse = motDepasse;
        this.email = email;
        this.telephone = telephone;
        this.profession = profession;
        this.contentType = contentType;
        this.pictureContent = pictureContent;
        this.activationExpireDate = activationExpireDate;
        this.resetKeyExpireDate = resetKeyExpireDate;
        this.pays = pays;
        this.ville = ville;
        this.statut = statut;
        this.moyenPaiement = moyenPaiement;
        this.numeroMoyenPaiement = numeroMoyenPaiement;
        this.banque = banque;
        this.numeroDeCompte = numeroDeCompte;
        this.referent = referent;
        this.referenceTransfert = referenceTransfert;
        this.numeroSecurite = numeroSecurite;
        this.authorities = authorities;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDepasse() {
        return motDepasse;
    }

    public void setMotDepasse(String motDepasse) {
        this.motDepasse = motDepasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getPictureContent() {
        return pictureContent;
    }

    public void setPictureContent(byte[] pictureContent) {
        this.pictureContent = pictureContent;
    }

    public Instant getActivationExpireDate() {
        return activationExpireDate;
    }

    public void setActivationExpireDate(Instant activationExpireDate) {
        this.activationExpireDate = activationExpireDate;
    }

    public Instant getResetKeyExpireDate() {
        return resetKeyExpireDate;
    }

    public void setResetKeyExpireDate(Instant resetKeyExpireDate) {
        this.resetKeyExpireDate = resetKeyExpireDate;
    }

    public Parametre getStatut() {
        return statut;
    }

    public void setStatut(Parametre statut) {
        this.statut = statut;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Parametre getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(Parametre moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public String getNumeroMoyenPaiement() {
        return numeroMoyenPaiement;
    }

    public void setNumeroMoyenPaiement(String numeroMoyenPaiement) {
        this.numeroMoyenPaiement = numeroMoyenPaiement;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNumeroDeCompte() {
        return numeroDeCompte;
    }

    public void setNumeroDeCompte(String numeroDeCompte) {
        this.numeroDeCompte = numeroDeCompte;
    }

    public String getReferent() {
        return referent;
    }

    public void setReferent(String referent) {
        this.referent = referent;
    }

    public String getReferenceTransfert() {
        return referenceTransfert;
    }

    public void setReferenceTransfert(String referenceTransfert) {
        this.referenceTransfert = referenceTransfert;
    }

    public Integer getDernierNumero() {
        return dernierNumero;
    }

    public void setDernierNumero(Integer dernierNumero) {
        this.dernierNumero = dernierNumero;
    }

    public String getNumeroSecurite() {
        return numeroSecurite;
    }

    public void setNumeroSecurite(String numeroSecurite) {
        this.numeroSecurite = numeroSecurite;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", motDepasse=" + motDepasse + ", email=" + email + ", telephone=" + telephone + ", profession=" + profession + ", contentType=" + contentType + ", pictureContent=" + pictureContent + ", activationExpireDate=" + activationExpireDate + ", resetKeyExpireDate=" + resetKeyExpireDate + ", pays=" + pays + ", ville=" + ville + ", statut=" + statut + ", moyenPaiement=" + moyenPaiement + ", numeroMoyenPaiement=" + numeroMoyenPaiement + ", banque=" + banque + ", numeroDeCompte=" + numeroDeCompte + ", referent=" + referent + ", referenceTransfert=" + referenceTransfert + ", dernierNumero=" + dernierNumero + ", numeroSecurite=" + numeroSecurite + ", authorities=" + authorities + '}';
    }


}
