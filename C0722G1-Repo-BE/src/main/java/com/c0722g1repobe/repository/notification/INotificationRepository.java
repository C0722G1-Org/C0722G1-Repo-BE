package com.c0722g1repobe.repository.notification;

import com.c0722g1repobe.entity.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
            " value ( :title , :posting_date , :content, :flag_delete )", nativeQuery = true)
    void saveNotification(@Param("title") String title,
                          @Param("posting_date") String posting_date,
                          @Param("content") String content,
                          @Param("flag_delete") Boolean flag_delete);


    /**
     * Create by: AnhTDQ
     * Date created: 31/01/2023
     * Function: update Notification
     *
     * @param   title,  posting_date,  content,  flag_delete , id_notification
     * @return Optional<Notification>
     */

    @Modifying
    @Query(value = "update notification set title = :title ,posting_date = :posting_date , content = :content , flag_delete = :flag_delete " +
            " where  (id_notification = :id )", nativeQuery = true)
    void updateNotification(@Param("title") String title ,
                            @Param("posting_date") String posting_date ,
                            @Param("content") String content ,
                            @Param("flag_delete") Boolean flag_delete);

}
