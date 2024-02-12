package com.example.reversebits.controller;

import com.example.reversebits.model.Author;
import com.example.reversebits.model.Blog;
import com.example.reversebits.service.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/blog/")
public class UserBlogController {

    @Autowired
    private UserBlogService userBlogService;

    @PostMapping("save")
    ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(userBlogService.saveBlog(blog), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    ResponseEntity<Blog> updateBlog(@RequestBody Blog blog,@PathVariable("id") Long blogId){
        return new ResponseEntity<>(userBlogService.updateBlog(blog,blogId), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<String> deleteBlog(@PathVariable("id") Long blogId){
        userBlogService.deleteBlog(blogId);
        return new ResponseEntity<>("The Record Deleted Successfully!", HttpStatus.OK);
    }
    @GetMapping("getAll")
    ResponseEntity<List<Blog>> getAllBlogs(){
        return new ResponseEntity<>(userBlogService.getAllBlogs(), HttpStatus.OK);
    }

    @PostMapping("saveAuthor")
    ResponseEntity<Author> createBlogWithAuthor(@RequestBody Author author){
        return new ResponseEntity<>(userBlogService.saveAuthor(author), HttpStatus.CREATED);
    }

    @PutMapping("updateAuthor")
    ResponseEntity<Author> updateBlogWithAuthor(@RequestBody Author author){
        return new ResponseEntity<>(userBlogService.updateAuthor(author), HttpStatus.OK);
    }

    @DeleteMapping("deleteAuthor")
    ResponseEntity<String> deleteBlogWithAuthor(@RequestBody Author author){
        return new ResponseEntity<>(userBlogService.deleteAuthor(author), HttpStatus.OK);
    }
}
