package com.example.layoutmanagementservice.controller;

import com.example.layoutmanagementservice.model.Layout;
import com.example.layoutmanagementservice.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/layouts")
public class LayoutController {

    @Autowired
    private LayoutService layoutService;

    @GetMapping("/all")
    public List<Layout> getAllLayouts() {
        return layoutService.getAllLayouts();
    }

    @PostMapping("/assign/user/{userId}/layout/{layoutId}")
    public ResponseEntity<String> assignLayoutToUser(@PathVariable Integer userId, @PathVariable Integer layoutId) {
        layoutService.assignLayoutToUser(userId, layoutId);
        return ResponseEntity.ok("Layout assigned to user successfully");
    }

    @PostMapping("/assign/group/{groupId}/layout/{layoutId}")
    public ResponseEntity<String> assignLayoutToGroup(@PathVariable Integer groupId, @PathVariable Integer layoutId) {
        layoutService.assignLayoutToGroup(groupId, layoutId);
        return ResponseEntity.ok("Layout assigned to group successfully");
    }

    @PutMapping("/update/user/{userId}/layout/{layoutId}")
    public ResponseEntity<String> updateUserLayout(@PathVariable Integer userId, @PathVariable Integer layoutId) {
        layoutService.updateLayoutForUser(userId, layoutId);
        return ResponseEntity.ok("User layout updated successfully");
    }

    @PutMapping("/update/group/{groupId}/layout/{layoutId}")
    public ResponseEntity<String> updateGroupLayout(@PathVariable Integer groupId, @PathVariable Integer layoutId) {
        layoutService.updateLayoutForGroup(groupId, layoutId);
        return ResponseEntity.ok("Group layout updated successfully");
    }

    @GetMapping("/user/{userId}")
    public Layout getUserLayout(@PathVariable Integer userId) {
        return layoutService.getUserLayout(userId);
    }

    @PutMapping("/{layoutId}")
    public ResponseEntity<String> updateLayout(@PathVariable Integer layoutId, @RequestBody Layout updatedLayout) {
        layoutService.updateLayout(layoutId, updatedLayout);
        return ResponseEntity.ok("Layout updated successfully");
    }
}
