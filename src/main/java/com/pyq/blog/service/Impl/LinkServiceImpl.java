package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.LinkMapper;
import com.pyq.blog.model.Link;
import com.pyq.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LinkService")
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkMapper linkMapper;

    @Override
    public List<Link> selectAllLink() {
        return linkMapper.selectAllLink();
    }

    @Override
    public void addLink(Link link) {
        linkMapper.addLink(link);
    }

    @Override
    public Link selectLinkById(String id) {
        return linkMapper.selectLinkById(id);
    }

    @Override
    public void updateLink(Link link) {
        linkMapper.updateLink(link);
    }

    @Override
    public void delLink(String id) {
        linkMapper.delLink(id);
    }
}
