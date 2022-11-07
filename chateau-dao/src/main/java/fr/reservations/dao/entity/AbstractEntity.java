package fr.reservations.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
public class AbstractEntity implements Serializable {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "INSERTED_AT")
	private LocalDateTime insertedAt;

	@Column(name = "INSERTED_BY")
	private String insertedBy;

	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@PrePersist
	private void onPrePersist() {
		if (id == null) {
			id = UUID.randomUUID().toString();
			insertedBy = "TBD";
		}
		if(insertedAt == null) {
			insertedAt = LocalDateTime.now();
		}
	}

	@PreUpdate
	private void onPreUpdate() {
		updatedAt = LocalDateTime.now();
		updatedBy = "TBD";
	}

}
