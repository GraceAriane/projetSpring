package com.projet.backend.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

@Entity
@Table(name = "users")
//@Getter
//@Setter
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	@ManyToOne
	@JoinColumn(name="role_id")
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
	 * @return Collection<? extends GrantedAuthority>
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
