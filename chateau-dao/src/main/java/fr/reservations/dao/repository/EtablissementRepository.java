package fr.reservations.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservations.dao.entity.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, String>, EtablissementRepositoryCustom {

	Etablissement findByMatricule(String matricule);
}
