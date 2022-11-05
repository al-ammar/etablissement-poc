package fr.reservations.dao.repository;

import java.util.List;

import fr.reservations.common.dtos.UserCriteriaDTO;
import fr.reservations.dao.entity.User;

public interface UserRepositoryCustom {
	List<User> searchByCritteria(UserCriteriaDTO user);
}
