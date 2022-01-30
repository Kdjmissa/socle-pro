/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import socle.pro.secuirty.utils.SecurityConstant;

/**
 *
 * @author kdjimissa
 * @since: 26/01/2022
 */
@Entity
@Table(name = "file_store", schema = SecurityConstant.SCHEMA)
public class FileStore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "content_type")
    private String contentType;

    @Lob
    @Column(name = "content")
    private byte[] valeur;

    public FileStore() {
    }

    public FileStore(String id, String nom, String contentType, byte[] valeur) {
        this.id = id;
        this.nom = nom;
        this.contentType = contentType;
        this.valeur = valeur;
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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getValeur() {
        return valeur;
    }

    public void setValeur(byte[] valeur) {
        this.valeur = valeur;
    }
}
