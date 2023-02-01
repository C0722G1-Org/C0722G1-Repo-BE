package com.c0722g1repobe.controller;

import com.c0722g1repobe.dto.NotificationDeleteDto;
import com.c0722g1repobe.dto.NotificationAllPropertyDto;
import com.c0722g1repobe.dto.NotificationSearchDto;
import com.c0722g1repobe.model.Notification;
import com.c0722g1repobe.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationRestController {
    @Autowired
    private INotificationService notificationService;

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to search notifications by posting date and tittle and content
     *
     * @param notificationSearchDto
     * @param pageable
     * @return HttpStatus.NO_CONTENT if not found any notification /  HttpStatus.OK and Notifications with pagination if found
     */
    @PostMapping("/search")
    public ResponseEntity<Page<NotificationAllPropertyDto>> searchNotifications(@RequestBody NotificationSearchDto notificationSearchDto,
                                                                                @PageableDefault(value = 5) Pageable pageable) {
        if (notificationSearchDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Page<NotificationAllPropertyDto> notificationPage = notificationService.searchNotifications(notificationSearchDto, pageable);
        if (notificationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notificationPage, HttpStatus.OK);
    }

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to find notifications by List ids
     *
     * @param idList
     * @return HttpStatus.NO_CONTENT if exists any notification not found or HttpStatus.OK and notification found
     */
    @PostMapping("/find-by-list-id")
    public ResponseEntity<List<NotificationDeleteDto>> findByListId(@RequestBody List<Integer> idList) {
        if (idList == null || idList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<NotificationDeleteDto> notificationDeleteDtoList = notificationService.findByListId(idList);
        if (idList.size() != notificationDeleteDtoList.size()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notificationDeleteDtoList, HttpStatus.OK);
    }

    /**
     * Create by DatLA
     * Date created: 31/01/2023
     * Function: to delete notifications by idList
     *
     * @param idList
     * @return HttpStatus.OK if remove successfully or HttpStatus.NO_CONTENT if exists not found notification
     * or HttpStatus.BAD_REQUEST if request is error
     */
    @PostMapping("/remove")
    public ResponseEntity<HttpStatus> remove(@RequestBody List<Integer> idList) {
        if (idList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<NotificationDeleteDto> notificationDeleteDtoList = notificationService.findByListId(idList);
        if (idList.size() != notificationDeleteDtoList.size()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        notificationService.removeByListId(idList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: DatLA
     * Date created: 31/01/2023
     * Function: to get List of notifications with pagination
     *
     * @param pageable
     * @return HttpStatus.NO_CONTENT if not found any notification /  HttpStatus.OK and Notifications with pagination if found
     */
    public ResponseEntity<Page<NotificationAllPropertyDto>> getListNotification(Pageable pageable) {
        NotificationSearchDto notificationSearchDto = new NotificationSearchDto("", "", "");
        Page<NotificationAllPropertyDto> notificationPage = notificationService.searchNotifications(notificationSearchDto, pageable);
        if (notificationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notificationPage, HttpStatus.OK);
    }
}
