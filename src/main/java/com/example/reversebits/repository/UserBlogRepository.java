package com.example.reversebits.repository;

import com.example.reversebits.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBlogRepository extends JpaRepository<Blog,Long> {
}
