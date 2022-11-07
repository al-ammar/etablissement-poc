package fr.reservations.common.dtos;

import java.util.List;

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
public class EtablissementDTO extends AbstractDTO {

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

	@Schema(required = false)
	private List<SectionDTO> sections;
}
