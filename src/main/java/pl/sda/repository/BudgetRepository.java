package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.Budget;
import pl.sda.model.User;

import java.util.List;

/**
 * Created by Michał Gałka on 2017-05-23.
 */
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

    List<Budget> findAllByUser(User user);

    @Query("from Budget b where b.user = :user and b.year = :year and b.month = :month")
    List<Budget> findAllBy(@Param("user") User user,
                           @Param("year") Integer year,
                           @Param("month") Integer month);
}