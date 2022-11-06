package fr.reservations.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.reservations.common.dtos.EtablissementDTO;
import fr.reservations.dao.entity.Etablissement;
import fr.reservations.dao.repository.EtablissementRepository;
import fr.reservations.services.EtablissementServices;
import fr.reservations.services.mappers.EtablissementMapper;

@Service
@Transactional
public class EtablissementServiceImpl implements EtablissementServices {

	@Autowired
	private EtablissementRepository repository;

	@Override
	public EtablissementDTO getEtablissement(String id) {
		return EtablissementMapper.toDTO(repository.getReferenceById(id));
	}

	@Override
	public EtablissementDTO getEtablissementByMatricule(String matricule) {
		return EtablissementMapper.toDTO(repository.findByCode(matricule));
	}

	@Override
	public String insertEtablissement(EtablissementDTO user) {
		return repository.save(EtablissementMapper.to(user)).getId();
	}

	@Override
	public void deleteEtablissement(String id) {
		repository.deleteById(id);
	}

	@Override
	public Page<EtablissementDTO> getEtablissement(Pageable pageable) {
		Page<Etablissement> results = repository.findAll(pageable);
		List<EtablissementDTO> resultsDTO = results.stream().map(EtablissementMapper::toDTO).toList();
		return new PageImpl<>(resultsDTO, pageable, results.getTotalElements());
	}

}
