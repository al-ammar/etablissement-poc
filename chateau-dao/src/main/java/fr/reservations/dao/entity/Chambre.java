package fr.reservations.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CHAMBRE")
@EqualsAndHashCode(callSuper = true)
public class Chambre extends AbstractEntity{
	
	@Column(name = "CODE")
	private String matricule;
	
	
	@Column(name = "LIBELLE")
	private String libelle;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "STATUT")
	private String statut;
	
	@Column(name = "ETAGE")
	private int etage;
	
	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name="TYPE")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SECTION_ID", referencedColumnName = "ID")
	private Section section;

}
