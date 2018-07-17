package com.xclr8.api.web.controller;

import com.xclr8.api.service.NotificationService;
import com.xclr8.api.web.request.NotificationRequest;
import com.xclr8.api.web.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
     * GET [url]:8080/notification/[recipient health id]
     * Return all available notifications filtered by given recipient health id from database
     * @param rhid
     * @return Iterable<NotificationResponse>
     */
    @RequestMapping(value = "/{rhid}", method = RequestMethod.GET)
    public Iterable<NotificationResponse> notificationsByRecipientHealthId(@PathVariable String rhid) {
        return mNotificationService.findNotificationsByRecipientHealthId(rhid);
    }

    /**
     * POST [url]:8080/notification
     * Creates a notification object in the database
     * @param notification
     * @return NotificationResponse
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public NotificationResponse createNotification(@RequestBody NotificationRequest notification) {
        return mNotificationService.createNotification(notification);
    }

    /**
     * PUT [url]:8080/notification/mark-read/[notification object id]
     * Edits a notification object in the database
     * @param id
     * @return NotificationResponse
     */
    @RequestMapping(value = "/mark-read/{id}", method = RequestMethod.PUT)
    public NotificationResponse readNotification(@PathVariable String id) {

        return mNotificationService.readNotification(id);
    }

    /**
     * PUT [url]:8080/notification/mark-all-read/[user health id]
     * Edits multiple notification objects in the database
     * @param hid
     * @return NotificationResponse
     */
    @RequestMapping(value = "/mark-all-read/{hid}", method = RequestMethod.PUT)
    public Iterable<NotificationResponse> readAllNotifications(@PathVariable String hid) {

        return mNotificationService.readAllNotifications(hid);
    }

    /**
     * DELETE [url]:8080/notification/[document id]
     * Delete all notifications filtered by given document id from database
     * @param id
     * @return true
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteNotificationsById(@PathVariable String id) {
        return mNotificationService.deleteNotificationsById(id);
    }

    /**
     * DELETE [url]:8080/notification/hid/[recipient health id]
     * Delete all notifications filtered by given recipient health id from database
     * @param rhid
     * @return true
     */
    @RequestMapping(value = "/hid/{rhid}", method = RequestMethod.DELETE)
    public boolean deleteNotificationsByRecipientHealthId(@PathVariable String rhid) {
        return mNotificationService.deleteNotificationsByRecipientHealthId(rhid);
    }
}
