package com.worldwidenews.worldwidenewsweb.repositories;

import com.worldwidenews.worldwidenewsweb.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
