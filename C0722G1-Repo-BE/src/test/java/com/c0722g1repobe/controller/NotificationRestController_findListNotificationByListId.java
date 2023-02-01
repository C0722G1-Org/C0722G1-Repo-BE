package com.c0722g1repobe.controller;

import com.c0722g1repobe.dto.NotificationDeleteDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationRestController_findListNotificationByListId {
    @Autowired
    private NotificationRestController notificationRestController;

    /**
     * Created by: DatLA,
     * Date created: 01/02/2023
     * Function: notification list search by list id with list id are null
     * @param: null
     */

    @Test
    public void findListNotificationByListId_1() throws Exception {
        ResponseEntity<List<NotificationDeleteDto>> responseEntity
                = this.notificationRestController.findByListId(null);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
