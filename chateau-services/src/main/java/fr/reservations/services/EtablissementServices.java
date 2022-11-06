package fr.reservations.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.reservations.common.dtos.EtablissementDTO;

public interface EtablissementServices {

	EtablissementDTO getEtablissement(String id);

	EtablissementDTO getEtablissementByMatricule(String matricule);

	String insertEtablissement(EtablissementDTO user);

	void deleteEtablissement(String id);

	Page<EtablissementDTO> getEtablissement(Pageable pageable);

}
