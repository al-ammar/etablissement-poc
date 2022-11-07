package fr.reservations.common.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChambreDTO extends AbstractDTO {

	@Schema(required = false)
	private String matricule;

	@Schema(required = false)
	private String libelle;

	@Schema(required = false)
	private String description;

	@Schema(required = false)
	private String statut;

	@Schema(required = false)
	private int etage;

	@Schema(required = false)
	private SectionDTO section;

}
