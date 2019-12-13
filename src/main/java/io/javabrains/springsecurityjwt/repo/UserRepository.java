package io.javabrains.springsecurityjwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> {
	Optional<UserBean> findByUname(String uname);
}
