package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.ProfileMapper;
import com.pyq.blog.model.Profile;
import com.pyq.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProfileService")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileMapper profileMapper;

    @Override
    public Profile selectAll(){
        return profileMapper.selectAll();
    }

    @Override
    public void updateProfile(Profile profile){
        profileMapper.updateProfile(profile);
    }
}
