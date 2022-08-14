package com.sb.firstboot.service.impl;

import com.sb.firstboot.domain.Bbs;
import com.sb.firstboot.domain.Pagination;
import com.sb.firstboot.repository.BbsDao;
import com.sb.firstboot.repository.BbsRepository;
import com.sb.firstboot.service.BbsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsServiceImpl implements BbsService {

    @Autowired
    BbsRepository bbsRepository;

    @Autowired
    SqlSessionTemplate sqlSession;

    @Override
    public List<Bbs> selectAll() {
        return bbsRepository.findAll();
    }

    @Override
    public int insertBbs(Bbs bbs) {
            bbsRepository.save(bbs);
        return 0;
    }

    @Override
    public Bbs findBbsById(long id) {

        return bbsRepository.findOneById(id);
    }

    @Override
    public Pagination paginate(Pagination pagination) {
        return pagination;
    }
}
