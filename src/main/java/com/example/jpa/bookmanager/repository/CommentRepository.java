package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
