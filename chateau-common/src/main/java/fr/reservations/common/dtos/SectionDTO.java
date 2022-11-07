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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SectionDTO extends AbstractDTO{

	@Schema(required = false)
	private String matricule;

	@Schema(required = false)
	private String libelle;

	@Schema(required = false)
	private String description;

	@Schema(required = false)
	private EtablissementDTO etablissement;

	@Schema(required = false)
	private List<ChambreDTO> chambres;

}
