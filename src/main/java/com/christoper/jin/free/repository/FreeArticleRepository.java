package com.christoper.jin.free.repository;

import com.christoper.jin.free.domain.FreeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeArticleRepository extends JpaRepository<FreeArticle, String> {
}
