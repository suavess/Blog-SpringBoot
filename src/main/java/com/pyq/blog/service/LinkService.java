package com.pyq.blog.service;

import com.pyq.blog.model.Link;

import java.util.List;

public interface LinkService {
    List<Link> selectAllLink();
    void addLink(Link link);
    Link selectLinkById(String id);
    void updateLink(Link link);
    void delLink(String id);
}
