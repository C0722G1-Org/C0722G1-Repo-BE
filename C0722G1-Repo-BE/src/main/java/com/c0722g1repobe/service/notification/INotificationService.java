package com.c0722g1repobe.service.notification;

import com.c0722g1repobe.entity.notification.Notification;


public interface INotificationService {

    /**
     * Create by: AnhTDQ
     * Date created: 01/02/2023
     * Function: to update notification
     *
     * @return notification
     */

    void updateNotification(Notification notification);

    /**
     * Create by: AnhTDQ
     * Date created: 01/02/2023
     * Function: to create notification
     *
     * @return notification
     */
    void createUser(Notification notification);

    /**
     * Create by: AnhTDQ
     * Date created: 01/02/2023
     * Function: to find notification by id
     *
     * @param id
     * @return notification
     */

    Notification findNotificationById(long id);
}
