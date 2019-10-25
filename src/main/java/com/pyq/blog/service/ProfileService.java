package com.pyq.blog.service;

import com.pyq.blog.model.Profile;

public interface ProfileService {
    Profile selectAll();
    void updateProfile(Profile profile);
}
