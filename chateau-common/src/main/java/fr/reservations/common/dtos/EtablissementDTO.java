package fr.reservations.common.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementDTO {

	@Schema(required = false)
	private String id;

	@Schema(required = false)
	private String matricule;

	@Schema(required = false)
	private String libelle;

	@Schema(required = false)
	private String description;

	@Schema(required = false)
	private String adresse;

	@Schema(required = false)
	private String telephone;

	@Schema(required = false)
	private String etat;
	
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Schema(required = false)
	private LocalDateTime creationDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Schema(required = false)
	private LocalDateTime updateDate;

}
