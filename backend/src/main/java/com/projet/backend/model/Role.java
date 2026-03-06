package com.projet.backend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Entité représentant un rôle utilisateur</h2>
 *
 * <p>
 * Cette classe définit les rôles attribuables aux utilisateurs
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>
 * Les rôles permettent de gérer les permissions
 * et les niveaux d'accès des utilisateurs.
 * </p>
 *
 * Exemples de rôles :
 * <ul>
 *     <li>ADMIN</li>
 *     <li>USER</li>
 * </ul>
 */

@Entity
@Table(name="role")
@Schema(description = "Rôle attribuable à un utilisateur")
//@Getter
//@Setter
public class Role {
	
	/** 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/** 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Identifiant unique du rôle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant du rôle", example = "1")
    private Long id;

    /**
     * Nom du rôle.
     */
    @Column(name="name", nullable = false)
    @Schema(description = "Nom du rôle", example = "ADMIN")
    private String name;
}
