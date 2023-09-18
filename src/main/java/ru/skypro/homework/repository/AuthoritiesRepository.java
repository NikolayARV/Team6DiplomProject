package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
    Authorities findByUsername(String username);
}
