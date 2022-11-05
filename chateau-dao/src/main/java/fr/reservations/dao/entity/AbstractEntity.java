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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
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

	@Override
	public int hashCode() {
		return Objects.hash(id, insertedAt, insertedBy, updatedAt, updatedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(insertedAt, other.insertedAt)
				&& Objects.equals(insertedBy, other.insertedBy) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(updatedBy, other.updatedBy);
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + ", insertedAt=" + insertedAt + ", insertedBy=" + insertedBy + ", updatedAt="
				+ updatedAt + ", updatedBy=" + updatedBy + "]";
	}

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
