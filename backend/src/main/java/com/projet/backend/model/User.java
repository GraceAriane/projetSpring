package com.projet.backend.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * <h2>Entité représentant un utilisateur du système</h2>
 *
 * <p>
 * Cette classe représente un utilisateur de la bibliothèque.
 * Elle implémente l’interface {@link org.springframework.security.core.userdetails.UserDetails}
 * afin d’être compatible avec le système d’authentification de Spring Security.
 * </p>
 *
 * <p>
 * Chaque utilisateur possède :
 * </p>
 * <ul>
 *     <li>un identifiant unique</li>
 *     <li>un nom d'utilisateur</li>
 *     <li>un mot de passe</li>
 *     <li>une date de création</li>
 *     <li>un rôle déterminant ses permissions</li>
 * </ul>
 *
 * <p>
 * Les informations de rôle sont utilisées pour générer les autorités
 * nécessaires au contrôle d’accès dans l’application.
 * </p>
 *
 * @author
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails{

    /**
     * Identifiant unique de l'utilisateur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant unique de l'utilisateur", example = "1")
    private Long id;

    /**
     * Nom de l'utilisateur utilisé pour l'authentification.
     */
    @Column(name="name", nullable = false)
    @Schema(description = "Nom de l'utilisateur", example = "grace")
    private String name;

    /**
     * Mot de passe de l'utilisateur.
     */
    @Column(nullable = false)
    @Schema(description = "Mot de passe de l'utilisateur", example = "password123")
    private String password;

    /**
     * Date de création du compte utilisateur.
     */
    @Column(name="created_at")
    @Schema(description = "Date de création du compte", example = "2026-03-06")
    private LocalDate createdAt;

    /**
     * Rôle associé à l'utilisateur.
     */
    @ManyToOne
    @JoinColumn(name="role_id")
    @Schema(description = "Rôle attribué à l'utilisateur")
    private Role role;

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
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * @return LocalDate
	 */
	public LocalDate getCreatedAt() {
		return createdAt;
	}

	/** 
	 * @param createdAt
	 */
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	/** 
	 * @return Role
	 */
	public Role getRole() {
		return role;
	}

	/** 
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * Retourne les autorités associées à l'utilisateur.
	 *
	 * <p>
	 * Les autorités sont générées à partir du rôle de l'utilisateur.
	 * </p>
	 *
	 * @return la liste des autorités accordées à l'utilisateur
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + role.getName()));
	}
	

	/** 
	 * @return String
	 */
	@Override
	public String getUsername() {
	    return name;
	}

	/** 
	 * @return boolean
	 */
	@Override
	public boolean isAccountNonExpired() {
	    return true;
	}

	/** 
	 * @return boolean
	 */
	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}

	/** 
	 * @return boolean
	 */
	@Override
	public boolean isCredentialsNonExpired() {
	    return true;
	}

	/** 
	 * @return boolean
	 */
	@Override
	public boolean isEnabled() {
	    return true;
	}
	
}
