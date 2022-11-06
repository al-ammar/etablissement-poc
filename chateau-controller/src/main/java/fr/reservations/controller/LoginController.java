package fr.reservations.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.reservations.common.dtos.UserDTO;
import fr.reservations.services.IUserServices;
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
@RequestMapping(value = "/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "login services", description = "Prouf of concept Services ")

public class LoginController {

	@Autowired
	private IUserServices services;

	@Operation(summary = "Authentication")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successfully retrieved all customers"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@PostMapping(consumes = UserController.JSON_TYPE, produces = UserController.JSON_TYPE)
	public ResponseEntity<Map> authentication(@Valid @RequestBody UserDTO user) {
		Map data = new HashMap<>();
		data.put("data", services.authentication(user.getUserName(), user.getPassword()));
		return ResponseEntity.ok(data);
	}
}
