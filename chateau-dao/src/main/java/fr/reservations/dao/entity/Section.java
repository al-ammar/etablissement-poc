package fr.reservations.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "SECTION")
@EqualsAndHashCode(callSuper = true)
public class Section extends AbstractEntity {

	@Column(name = "CODE")
	private String matricule;

	@Column(name = "LIBELLE")
	private String libelle;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ETABLISSEMENT_ID", referencedColumnName = "ID")
	private Etablissement etablissement;

	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Chambre> chambres;

}
