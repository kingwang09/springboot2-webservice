package com.christoper.jin.web.free.repository;

import com.christoper.jin.web.free.domain.FreeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeArticleRepository extends JpaRepository<FreeArticle, String> {
}
