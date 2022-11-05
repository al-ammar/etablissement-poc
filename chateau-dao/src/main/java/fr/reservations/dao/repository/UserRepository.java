package fr.reservations.dao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservations.dao.entity.User;



public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {

	List<User> findByUserName(String userName, Pageable pageable);
}
