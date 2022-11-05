package fr.reservations.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import fr.reservations.common.dtos.UserCriteriaDTO;
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
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "user services", description = "Prouf of concept Services ")
public class UserController {

	private final static String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;

	@Autowired
	private IUserServices services;

	@Operation(summary = "GET ALL USERS")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successfully retrieved all customers"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@PostMapping(path = "/search", produces = JSON_TYPE)
	public ResponseEntity<Map> searchUsers(@RequestBody UserCriteriaDTO user) {
		List<UserDTO> results = services.searchUsers(user);
		Map data = new HashMap<>();
		data.put("data", results);
		return ResponseEntity.ok(data);
	}

	@Operation(summary = "GET ALL USERS")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successfully retrieved all customers"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@GetMapping(produces = JSON_TYPE)
	public ResponseEntity<Map> getUsers(Pageable pageable) {
		Page<UserDTO> results = services.getUsers(pageable);
		Map data = new HashMap<>();
		data.put("data", results);
		return ResponseEntity.ok(data);
	}

	@Operation(summary = "GET USER")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved a customer"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@GetMapping(value = "/{userID}")
	public ResponseEntity<UserDTO> getUser(@PathVariable String userID) {
		return ResponseEntity.ok(services.getUser(userID));
	}

	@Operation(summary = "CREATE USER")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created a customer"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception"),
			@ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service") })
	@PostMapping(consumes = { "multipart/form-data", "multipart/mixed" })
	public ResponseEntity createUser(@Valid @RequestPart("user") UserDTO user,
			@RequestPart("file") MultipartFile[] file, UriComponentsBuilder uriBuilder) throws IOException {
		UserDTO userCreated = services.insertUser(user, file[0].getBytes());
		URI location = uriBuilder.path("/users/{userId}").buildAndExpand(userCreated.getId()).toUri();
		return ResponseEntity.created(location).contentType(MediaType.valueOf(JSON_TYPE)).body(userCreated);

	}

	@Operation(summary = "Update user")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully updated a customer"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception"),
			@ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service") })
	@PutMapping(value = "{id}", consumes = JSON_TYPE)
	public ResponseEntity updateUser(@PathVariable String id, @Valid @RequestBody UserDTO dto) {
		services.updateUser(id, dto);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "delete user")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully deleted a customer"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception"),
			@ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service") })
	@DeleteMapping(value = "{id}")
	public ResponseEntity deleteUSer(@PathVariable String id) {
		services.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
