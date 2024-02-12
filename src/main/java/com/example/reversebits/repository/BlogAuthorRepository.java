package com.example.reversebits.repository;

import com.example.reversebits.model.Author;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogAuthorRepository extends JpaRepository<Author,String> {
}
