package pl.sda.service.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.User;

/**
 * Created by Michał Gałka on 2017-04-07.
 */
@Repository
interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User u where u.mail = :mail")
    User findUserByMail(@Param("mail") String mail);

    User findByUsername(String username);


}