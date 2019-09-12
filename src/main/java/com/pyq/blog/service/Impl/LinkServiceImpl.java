package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.LinkMapper;
import com.pyq.blog.model.Link;
import com.pyq.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 16:34
 * @Version 1.0
 */
@Service("LinkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkMapper linkMapper;

    @Override
    public List<Link> selectAllLink() throws Exception {
        return linkMapper.selectAllLink();
    }
}
