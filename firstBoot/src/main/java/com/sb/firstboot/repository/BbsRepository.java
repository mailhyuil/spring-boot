package com.sb.firstboot.repository;

import com.sb.firstboot.domain.Bbs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BbsRepository extends JpaRepository<Bbs,Long> {
    public Bbs findOneById(long id);
}
