package fr.reservations.common.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({ "id", "userName", "password", "lastName", "firstName" })
public class UserDTO {

	@Schema(required = false)
	private String id;

	@Schema(required = true)
	private String userName;

	@Schema(required = true)
	private String password;

	@Schema(required = false)
	private String lastName;

	@Schema(required = false)
	private String firstName;

	@Schema(required = false)
	private Boolean authenticated;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Schema(required = false)
	private LocalDateTime creationDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Schema(required = false)
	private LocalDateTime updateDate;

	@Schema(required = false)
	private byte[] content;
}
