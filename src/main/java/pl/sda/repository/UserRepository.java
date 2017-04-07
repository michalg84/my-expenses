package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Michał Gałka on 2017-04-07.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}