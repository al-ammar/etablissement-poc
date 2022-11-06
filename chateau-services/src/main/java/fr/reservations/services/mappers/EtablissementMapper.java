package fr.reservations.services.mappers;

import fr.reservations.common.dtos.EtablissementDTO;
import fr.reservations.dao.entity.Etablissement;

public final class EtablissementMapper {

	public static EtablissementDTO toDTO(Etablissement e) {
		return EtablissementDTO.builder().adresse(e.getAdresse()).creationDate(e.getInsertedAt())
				.updateDate(e.getUpdatedAt()).libelle(e.getLibelle()).description(e.getDescription()).id(e.getId())
				.etat(e.getEtat()).matricule(e.getMatricule()).build();
	}

	public static Etablissement to(EtablissementDTO e) {
		return Etablissement.builder().adresse(e.getAdresse()).libelle(e.getLibelle()).description(e.getDescription())
				.etat(e.getEtat()).matricule(e.getMatricule()).build();

	}
}
