package com.costume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "costume")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costume implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Identificador del disfraz
     */
    private Integer id;
    @Column(nullable=false,length = 45)
    
    /**
     * Nombre del disfraz
     */
    private String name;
    @Column(nullable=false,length = 45)
    
    /**
     * Marca del disfraz
     */
    private String brand;
    
    /**
     * Año del disfraz
     */
    private Integer year;
    @Column(nullable=false,length = 250)
    
    /**
     * Descripcion del disfraz
     */
    private String description;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("costumes")
    
    /**
     * Categoria del disfraz
     */
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "costume")
    @JsonIgnoreProperties({"costume","client"})
    
    /**
     * Listado de mensajes relacionados con el disfraz
     */
    private List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costume","messages"})
    
    /**
     * Listado de reservas relacionados con el disfraz
     */
    public List<Reservation> reservations;
    
}
