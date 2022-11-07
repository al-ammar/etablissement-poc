package fr.reservations.services.mappers;

import fr.reservations.common.dtos.ChambreDTO;
import fr.reservations.common.dtos.EtablissementDTO;
import fr.reservations.common.dtos.SectionDTO;
import fr.reservations.dao.entity.Chambre;
import fr.reservations.dao.entity.Etablissement;
import fr.reservations.dao.entity.Section;

public final class EtablissementMapper {

	public static EtablissementDTO toDTO(Etablissement e) {
		EtablissementDTO dto = EtablissementDTO.builder().adresse(e.getAdresse()).libelle(e.getLibelle())
				.description(e.getDescription()).etat(e.getEtat()).matricule(e.getMatricule()).build();
		dto.setId(e.getId());
		dto.setInsertedAt(e.getInsertedAt());
		dto.setUpdatedAt(e.getUpdatedAt());
		dto.setSections(e.getSections().stream().map(EtablissementMapper::toSectionDTO).toList());

		return dto;
	}

	public static Etablissement to(EtablissementDTO e) {
		return Etablissement.builder().adresse(e.getAdresse()).libelle(e.getLibelle()).description(e.getDescription())
				.etat(e.getEtat()).matricule(e.getMatricule()).build();

	}

	public static SectionDTO toSectionDTO(Section s) {
		SectionDTO out = SectionDTO.builder().description(s.getDescription()).matricule(s.getMatricule())
				.libelle(s.getLibelle()).build();
		out.setId(s.getId());
		out.setInsertedAt(s.getInsertedAt());
		out.setUpdatedAt(s.getUpdatedAt());
		out.setChambres(s.getChambres().stream().map(EtablissementMapper::toChambreDTO).toList());
		return out;
	}

	public static ChambreDTO toChambreDTO(Chambre c) {
		ChambreDTO out = ChambreDTO.builder().description(c.getDescription()).etage(c.getEtage())
				.libelle(c.getLibelle()).matricule(c.getMatricule()).statut(c.getStatut()).build();
		out.setId(c.getId());
		out.setInsertedAt(c.getInsertedAt());
		out.setUpdatedAt(c.getUpdatedAt());
		return out;
	}
}
