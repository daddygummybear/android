package com.bitlove.fetlife.inbound;

import com.bitlove.fetlife.FetLifeApplication;
import com.bitlove.fetlife.notification.NotificationParser;
import com.bitlove.fetlife.notification.OneSignalNotification;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

public class OnNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

    @Override
    public void notificationOpened(OSNotificationOpenResult osNotificationOpenResult) {
        FetLifeApplication fetLifeApplication = FetLifeApplication.getInstance();
        if (osNotificationOpenResult == null) {
            return;
        }

        OneSignalNotification oneSignalNotification = fetLifeApplication.getNotificationParser().parseNotification(fetLifeApplication, osNotificationOpenResult);
        oneSignalNotification.onClick(fetLifeApplication);
    }

}
