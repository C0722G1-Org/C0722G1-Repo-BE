package com.c0722g1repobe.repository.notification;

import com.c0722g1repobe.entity.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface INotificationRepository extends JpaRepository<Notification, Long> {

    /**
     * Create by: AnhTDQ
     * Date created: 31/01/2023
     * Function: create new Notification
     *
     * @param title, posting_date,  content,  flag_delete
     * @return Optional<Notification>
     */

    @Modifying
    @Query(value = "insert into notification (title,posting_date,content,flag_delete)" +
            "value (?1,?2,?3, 1)", nativeQuery = true)
    void saveNotification(String title, String posting_date, String content, Boolean flag_delete);


    /**
     * Create by: AnhTDQ
     * Date created: 31/01/2023
     * Function: update Notification
     *
     * @param   title,  posting_date,  content,  flag_delete , id_notification
     * @return Optional<Notification>
     */

    @Modifying
    @Query(value = "update notification set title = ?1 ,posting_date = ?2 ,content = ?3, flag_delete = 1 " +
            "where  id_notification = ?4", nativeQuery = true)
    void updateNotification(String title, String posting_date, String content, Boolean flag_delete);

}
