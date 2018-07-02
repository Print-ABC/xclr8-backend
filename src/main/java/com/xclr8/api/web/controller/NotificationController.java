package com.xclr8.api.web.controller;

import com.xclr8.api.service.NotificationService;
import com.xclr8.api.web.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService mNotificationService;

    /**
     * GET [url]:8080/notification
     * Return all available notifications from database
     * @return Iterable<NotificationResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<NotificationResponse> notifications() {
        return mNotificationService.findAllNotification();
    }

    /**
     * GET [url]:8080/notification/id/[recipient health id]
     * Return all available notifications filtered by given recipient health id from database
     * @param rhid
     * @return Iterable<NotificationResponse>
     */
    @RequestMapping(value = "/id/{rhid}", method = RequestMethod.GET)
    public Iterable<NotificationResponse> notificationsByRecipientHealthId(@PathVariable String rhid) {
        return mNotificationService.findNotificationsByRecipientHealthId(rhid);
    }

    /**
     * GET [url]:8080/notification/delete/id/[document id]
     * Delete all notifications filtered by given document id from database
     * @param id
     * @return true
     */
    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
    public boolean deleteNotificationsById(@PathVariable String id) {
        return mNotificationService.deleteNotificationsById(id);
    }

    /**
     * GET [url]:8080/notification/delete/hid/[recipient health id]
     * Delete all notifications filtered by given recipient health id from database
     * @param rhid
     * @return true
     */
    @RequestMapping(value = "/delete/hid/{rhid}", method = RequestMethod.DELETE)
    public boolean deleteNotificationsByRecipientHealthId(@PathVariable String rhid) {
        return mNotificationService.deleteNotificationsByRecipientHealthId(rhid);
    }
}
