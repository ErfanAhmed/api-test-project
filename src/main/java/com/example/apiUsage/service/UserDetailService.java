package com.example.apiUsage.service;

import com.example.apiUsage.domain.UserDetail;
import com.example.apiUsage.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Transactional
    public void save(UserDetail userDetail) {
        userDetailRepository.save(userDetail);
    }
}
