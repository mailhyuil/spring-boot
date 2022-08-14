package com.sb.firstboot.repository;

import com.sb.firstboot.domain.Bbs;
import com.sb.firstboot.domain.Pagination;
import com.sb.firstboot.domain.User;

import java.util.Collection;
import java.util.List;

public interface BbsDao {
    public List<Bbs> getBoardList(Pagination pagination);
    public int getBoardListCnt();
}
