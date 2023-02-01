package com.c0722g1repobe.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationRestController_deleteNotificationByListId {
    @Autowired
    private NotificationRestController notificationRestController;

    /**
     * Created by: DatLA,
     * Date created: 01/02/2023
     * Function: delete notification by list id with list id are null
     *
     * @param: null
     */

    @Test
    public void findListNotificationByListId_29() throws Exception {
        ResponseEntity<HttpStatus> responseEntity
                = this.notificationRestController.remove(null);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    /**
     * Created by: DatLA,
     * Date created: 01/02/2023
     * Function: delete notifications with id value does not exist in database
     *
     * @param: (20, 21)
     */
    @Test
    public void findListNotificationByListId_30() throws Exception {
        List<Integer> listIds = Arrays.asList(20, 21);
        ResponseEntity<HttpStatus> responseEntity
                = this.notificationRestController.remove(listIds);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    /**
     * Created by: DatLA,
     * Date created: 01/02/2023
     * Function: delete notifications by list id with correct id value
     *
     * @param: (1, 2)
     */
    @Test
    public void findListNotificationByListId_31() throws Exception {
        List<Integer> listIds = Arrays.asList(1, 2);
        ResponseEntity<HttpStatus> responseEntity
                = this.notificationRestController.remove(listIds);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}