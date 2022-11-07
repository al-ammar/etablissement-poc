package fr.reservations.common.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode
@ToString
public class AbstractDTO implements Serializable{

	@Schema(required = false)
	private String id;

	@Schema(required = false)
	private LocalDateTime insertedAt;
	
	@Schema(required = false)
	private LocalDateTime updatedAt;
}
