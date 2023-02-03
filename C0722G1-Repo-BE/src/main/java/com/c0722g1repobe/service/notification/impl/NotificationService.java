package com.c0722g1repobe.service.notification.impl;

import com.c0722g1repobe.entity.notification.Notification;
import com.c0722g1repobe.repository.notification.INotificationRepository;
import com.c0722g1repobe.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private INotificationRepository notificationRepository;

    @Override
    public void updateNotification(Notification notification) {

    }

    @Override
    public void createUser(Notification notification) {

    }

    @Override
    public Notification findNotificationById(long id) {
        return null;
    }
}
