package com.example.reversebits.service;

import com.example.reversebits.model.Author;
import com.example.reversebits.model.Blog;

import java.util.List;

public interface UserBlogService {

    public Blog saveBlog(Blog blog);

    public Blog updateBlog(Blog blog,Long id);

    public void deleteBlog(Long id);

    public List<Blog> getAllBlogs();

    public Author saveAuthor(Author author);

    public Author updateAuthor(Author author);

    public String deleteAuthor(Author author);
}
