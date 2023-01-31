package c0722g1repobe.repository;

import c0722g1repobe.dto.NotificationAllPropertyDto;
import c0722g1repobe.dto.NotificationDeleteDto;
import c0722g1repobe.dto.NotificationSearchDto;
import c0722g1repobe.model.Notification;
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
     * Function: to search notifications by posting date and tittle and content
     *
     * @param notificationSearchDto
     * @param pageable
     * @return Notifications with pagination
     */
    @Query(value = "SELECT nt.`id_notification` AS idNotification, nt.posting_date AS postingDate, nt.`tittle` AS `tittle`, nt.`content` AS `content` " +
            " FROM `notification` as nt " +
            " WHERE nt.flag_delete = 0 " +
            " AND nt.posting_date BETWEEN :#{#notificationSearchDto.startDate} AND NOW()" +
            " AND nt.`tittle` LIKE %:#{#notificationSearchDto.tittle}% " +
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
    @Query(value = "select `id_notification` AS idNotification, tittle FROM `notification` WHERE id_notification IN :idList AND flag_delete = 0", nativeQuery = true)
    List<NotificationDeleteDto> findByListId(@Param("idList") List<Integer> idList);

    /**
     * Create by DatLA
     * Date created: 31/01/2023
     * Function: remove the list of notifications by id by updating the flag_deleted attribute.
     *
     * @param idList
     */
    @Modifying
    @Query(value = "update `notification` set flag_delete = 1 where id_notification in :idList", nativeQuery = true)
    void removeByListId(@Param("idList") List<Integer> idList);

}