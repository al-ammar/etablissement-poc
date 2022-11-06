package fr.reservations.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ETABLISSEMENT")
@EqualsAndHashCode(callSuper = true)
public class Etablissement extends AbstractEntity{

	@Column(name = "CODE")
	private String matricule;
	
	@Column(name = "LIBELLE")
	private String libelle;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ADRESSE")
	private String adresse;
	
	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "ETAT")
	private String etat;
}
