package c0722g1repobe.service;

import c0722g1repobe.dto.NotificationAllPropertyDto;
import c0722g1repobe.dto.NotificationDeleteDto;
import c0722g1repobe.dto.NotificationSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface INotificationService {

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to get notification in page
     * @param notificationSearchDto
     * @param pageable
     * @return notifications list with pagination
     */
    Page<NotificationAllPropertyDto> searchNotifications(NotificationSearchDto notificationSearchDto, Pageable pageable);

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to find notifications list by list of ids
     *
     * @param idList
     * @return notification list
     */
    List<NotificationDeleteDto> findByListId(List<Integer> idList);

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to delete notifications list by list of ids
     *
     * @param idList
     */
    void removeByListId(List<Integer> idList);
}
