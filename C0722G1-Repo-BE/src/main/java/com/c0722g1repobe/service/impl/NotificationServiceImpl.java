package com.c0722g1repobe.service.impl;

import com.c0722g1repobe.dto.NotificationDeleteDto;
import com.c0722g1repobe.dto.NotificationAllPropertyDto;
import com.c0722g1repobe.dto.NotificationSearchDto;
import com.c0722g1repobe.repository.INotificationRepository;
import com.c0722g1repobe.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationService {
    @Autowired
    private INotificationRepository notificationRepository;

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to get notification in page
     * @param notificationSearchDto
     * @param pageable
     * @return notifications list with pagination
     */
    @Override
    public Page<NotificationAllPropertyDto> searchNotifications(NotificationSearchDto notificationSearchDto,
                                                                Pageable pageable) {
        return notificationRepository.searchNotifications(notificationSearchDto, pageable);
    }

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to find notifications list by list of ids
     *
     * @param idList
     * @return notification list
     */
    @Override
    public List<NotificationDeleteDto> findByListId(List<Integer> idList) {
        return notificationRepository.findByListId(idList);
    }

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to delete notifications list by list of ids
     *
     * @param idList
     */
    @Override
    public void removeByListId(List<Integer> idList) {
        notificationRepository.removeByListId(idList);
    }
}