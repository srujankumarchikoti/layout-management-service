package com.example.layoutmanagementservice.service;

import com.example.layoutmanagementservice.model.Layout;
import com.example.layoutmanagementservice.model.User;
import com.example.layoutmanagementservice.model.UserGroup;
import com.example.layoutmanagementservice.repository.LayoutRepository;
import com.example.layoutmanagementservice.repository.UserRepository;
import com.example.layoutmanagementservice.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LayoutService {

    @Autowired
    private LayoutRepository layoutRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository UserGroupRepository;


    public List<Layout> getAllLayouts() {
        return layoutRepository.findAll();
    }

    public void assignLayoutToUser(Integer userId, Integer layoutId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Layout layout = layoutRepository.findById(layoutId).orElseThrow(() -> new RuntimeException("Layout not found"));
        user.setLayout(layout);
        userRepository.save(user);
    }


    public void assignLayoutToGroup(Integer groupId, Integer layoutId) {
        UserGroup group = UserGroupRepository.findById(groupId).orElseThrow(() -> new RuntimeException("UserGroup not found"));
        Layout layout = layoutRepository.findById(layoutId).orElseThrow(() -> new RuntimeException("Layout not found"));
        group.setLayout(layout);
        UserGroupRepository.save(group);
    }

    public void updateLayoutForUser(Integer userId, Integer layoutId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Layout layout = layoutRepository.findById(layoutId).orElseThrow(() -> new RuntimeException("Layout not found"));
        user.setLayout(layout);
        userRepository.save(user);
    }

    public void updateLayoutForGroup(Integer groupId, Integer layoutId) {
        UserGroup group = UserGroupRepository.findById(groupId).orElseThrow(() -> new RuntimeException("UserGroup not found"));
        Layout layout = layoutRepository.findById(layoutId).orElseThrow(() -> new RuntimeException("Layout not found"));
        group.setLayout(layout);
        UserGroupRepository.save(group);
    }

    public Layout getUserLayout(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getLayout();
    }

    public void updateLayout(Integer layoutId, Layout updatedLayout) {
        Optional<Layout> existingLayout = layoutRepository.findById(layoutId);
        if (existingLayout.isPresent()) {
            Layout layout = existingLayout.get();
            layout.setName(updatedLayout.getName());
            layout.setDescription(updatedLayout.getDescription());
            layoutRepository.save(layout);
        } else {
            throw new RuntimeException("Layout not found with id: " + layoutId);
        }
    }
}
