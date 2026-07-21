package de.init_software.demo.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer > {
  UserEntity findByFirstName(String firstName);
  @Transactional
  Long deleteByFirstName(String firstName); // long <= Anzahl der gelöschten Sätze
  List<UserEntity> findAll();
}
