package com.c0722g1repobe.controller;

import com.c0722g1repobe.dto.NotificationDeleteDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    /**
     * Created by: DatLA,
     * Date created: 01/02/2023
     * Function: notification list search by list id with value does not exist in database
     * @param: (20,21)
     */
    @Test
    public void findListNotificationByListId_2() throws Exception {
        List<Integer> listIds = Arrays.asList(20,21);
        ResponseEntity<List<NotificationDeleteDto>> responseEntity
                = this.notificationRestController.findByListId(listIds);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    /**
     * Created by: DatLA,
     * Date created: 01/02/2023
     * Function: notification list search by list id with correct id value
     * @param: (1,2)
     */
    @Test
    public void findListNotificationByListId_3() throws Exception {
        List<Integer> listIds = Arrays.asList(1,2);
        ResponseEntity<List<NotificationDeleteDto>> responseEntity
                = this.notificationRestController.findByListId(listIds);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2, Objects.requireNonNull(responseEntity.getBody()).size());
        Assertions.assertEquals("Thông báo đầu tiên",
                responseEntity.getBody().get(0).getTitle());
    }
}
