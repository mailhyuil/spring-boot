package com.sb.firstboot.service;

import com.sb.firstboot.domain.Bbs;
import com.sb.firstboot.domain.Pagination;

import java.util.List;

public interface BbsService {
    public List<Bbs> selectAll();

    public int insertBbs(Bbs bbs);

    public Bbs findBbsById(long id);

    public Pagination paginate(Pagination pagination);
}
