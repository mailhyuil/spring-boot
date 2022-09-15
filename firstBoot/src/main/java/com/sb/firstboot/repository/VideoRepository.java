package com.sb.firstboot.repository;

import com.sb.firstboot.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByName(String name);

    boolean existsByName(String name);

    @Query(nativeQuery = true, value="SELECT name FROM video")
    List<String> getAllEntryNames();
}
