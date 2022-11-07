package fr.reservations.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.reservations.common.dtos.EtablissementDTO;
import fr.reservations.dao.entity.Chambre;
import fr.reservations.dao.entity.Etablissement;
import fr.reservations.dao.entity.Section;
import fr.reservations.dao.repository.EtablissementRepository;
import fr.reservations.services.EtablissementServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/etablissement", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "etablissement services", description = "Prouf of concept Services ")
public class EtablissementController {

	@Autowired
	private EtablissementServices services;
	
	@Operation(summary = "GET ALL Etablissement")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successfully retrieved all Etablissements"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@GetMapping(produces = UserController.JSON_TYPE)
	public ResponseEntity<Map> getEtablissements(Pageable pageable) {
		Page<EtablissementDTO> results = services.getEtablissement(pageable);
		Map data = new HashMap<>();
		data.put("data", results);
		return ResponseEntity.ok(data);
	}

	@Operation(summary = "GET Etablissement")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved a Etablissement"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@GetMapping(value = "/{userID}")
	public ResponseEntity<EtablissementDTO> getEtablissement(@PathVariable String id) {
		return ResponseEntity.ok(services.getEtablissement(id));
	}
}
