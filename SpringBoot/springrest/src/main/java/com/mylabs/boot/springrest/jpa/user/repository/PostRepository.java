package com.mylabs.boot.springrest.jpa.user.repository;

import com.mylabs.boot.springrest.jpa.user.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
