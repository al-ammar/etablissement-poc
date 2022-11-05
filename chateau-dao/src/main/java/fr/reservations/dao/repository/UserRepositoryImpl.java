package fr.reservations.dao.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.reservations.common.dtos.UserCriteriaDTO;
import fr.reservations.dao.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	EntityManager em;

	public List<User> searchByCritteria(UserCriteriaDTO user) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		List<Predicate> conditions = new ArrayList<>();
		if (StringUtils.isNotEmpty(user.getUserName())) {
			conditions.add(builder.equal(root.get("userName"), user.getUserName()));
		}
		if (StringUtils.isNotBlank(user.getFirstName())) {
			conditions.add(builder.equal(root.get("firstName"), user.getFirstName()));
		}
		if (user.getCreationDateDebut() != null) {
			conditions.add(builder.greaterThanOrEqualTo(root.get("insertedAt"), user.getCreationDateDebut()));
		}
		if (user.getCreationDateFin() != null) {
			conditions.add(builder.lessThanOrEqualTo(root.get("insertedAt"), user.getCreationDateFin()));
		}
		query.where(conditions.toArray(new Predicate[0]));
		TypedQuery<User> q = em.createQuery(query);
		return q.getResultList();
	}

}
