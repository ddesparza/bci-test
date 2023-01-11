package bci.test.practico.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bci.test.practico.model.Phones;

public interface IPhonesRepository extends JpaRepository<Phones, String> {

}
