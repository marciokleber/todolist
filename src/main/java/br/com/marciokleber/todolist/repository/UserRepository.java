package br.com.marciokleber.todolist.repository;

import br.com.marciokleber.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   User findByUserName(String username);
}
