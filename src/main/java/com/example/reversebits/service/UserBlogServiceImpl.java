package com.example.reversebits.service;

import com.example.reversebits.model.Author;
import com.example.reversebits.model.Blog;
import com.example.reversebits.repository.BlogAuthorRepository;
import com.example.reversebits.repository.UserBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBlogServiceImpl implements UserBlogService{

    @Autowired
    private UserBlogRepository userBlogRepository;

    @Autowired
    private BlogAuthorRepository blogAuthorRepository;

    @Override
    public Blog saveBlog(Blog blog) {
        return userBlogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog, Long id) {
        Blog existingBlog = userBlogRepository.findById(id).get();
        existingBlog.setBlogPost(blog.getBlogPost());
        return userBlogRepository.save(existingBlog);
    }

    @Override
    public void deleteBlog(Long id) {
         userBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return userBlogRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        Blog blog = this.getBlog(Long.valueOf(author.getBlog().get("blogId").toString()));
        author.setAuthorId(blog.getAuthorId());
        Map<String,Object> blogMap = new HashMap<>();
        blogMap.put("blogId",Long.valueOf(author.getBlog().get("blogId").toString()));
        blogMap.put("blogPost"
                ,author.getBlog().get("blogPost").toString().isBlank()
        || author.getBlog().get("blogPost").toString().isEmpty() ? blog.getBlogPost() :
                        author.getBlog().get("blogPost").toString());
        author.setBlog(blogMap);
        return blogAuthorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        Blog blog = this.getBlog(Long.valueOf(author.getBlog().get("blogId").toString()));
        if(author.getAuthorId().equalsIgnoreCase(blog.getAuthorId())) {
            blog.setBlogPost(author.getBlog().get("blogPost").toString());
            userBlogRepository.save(blog);
            return blogAuthorRepository.save(author);
        }
        return null;
    }

    @Override
    public String deleteAuthor(Author author) {
        Blog blog = this.getBlog(Long.valueOf(author.getBlog().get("blogId").toString()));
        String message="Sorry Record Not Deleted!";
        if(author.getAuthorId().equalsIgnoreCase(blog.getAuthorId())) {
            blogAuthorRepository.deleteById(String.valueOf(Long.valueOf(author.getBlog().get("blogId").toString())));
            message="The Record Deleted Successfully!";
        }
        return message;
    }

    public Blog getBlog(Long blogId){
        return userBlogRepository.findById(blogId).get();
    }
}
