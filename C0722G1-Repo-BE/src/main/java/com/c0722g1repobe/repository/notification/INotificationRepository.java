package com.c0722g1repobe.repository.notification;

import com.c0722g1repobe.dto.notification.NotificationAllPropertyDto;
import com.c0722g1repobe.dto.notification.NotificationDeleteDto;
import com.c0722g1repobe.dto.notification.NotificationSearchDto;
import com.c0722g1repobe.entity.notification.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface INotificationRepository extends JpaRepository<Notification, Long> {

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to search notifications by posting date and title and content
     *
     * @param notificationSearchDto
     * @param pageable
     * @return Notifications with pagination
     */
    @Query(value = "SELECT nt.`id_notification` AS idNotification, nt.posting_date AS postingDate, nt.`title` AS `title`, nt.`content` AS `content` " +
            " FROM `notification` AS nt " +
            " WHERE nt.flag_delete = 0 " +
            " AND nt.posting_date BETWEEN :#{#notificationSearchDto.startDate} AND NOW()" +
            " AND nt.`title` LIKE %:#{#notificationSearchDto.title}% " +
            " AND nt.`content` LIKE %:#{#notificationSearchDto.content}% " +
            " ORDER BY nt.posting_date DESC "
            , nativeQuery = true)
    Page<NotificationAllPropertyDto> searchNotifications(@Param("notificationSearchDto") NotificationSearchDto notificationSearchDto,
                                                         Pageable pageable);

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to find notification by List ids
     *
     * @param idList
     * @return notifications list
     */
    @Query(value = "SELECT `id_notification` AS idNotification, `title` FROM `notification` WHERE id_notification IN :idList AND flag_delete = 0", nativeQuery = true)
    List<NotificationDeleteDto> findByListId(@Param("idList") List<Long> idList);

    /**
     * Create by DatLA
     * Date created: 31/01/2023
     * Function: remove the list of notifications by id by updating the flag_deleted attribute.
     *
     * @param idList
     */
    @Modifying
    @Query(value = "UPDATE `notification` SET flag_delete = 1 WHERE id_notification IN :idList", nativeQuery = true)
    void removeByListId(@Param("idList") List<Long> idList);

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
