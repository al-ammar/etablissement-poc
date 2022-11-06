package fr.reservations.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "THE_PASSWORD")
	private String thePassword;

	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "CONTENT")
	private byte[] content;

}
