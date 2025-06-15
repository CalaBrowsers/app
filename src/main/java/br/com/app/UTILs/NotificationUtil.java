package br.com.app.UTILs;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.TextArea;

public class NotificationUtil {

    public static void showSuccess(String message) {
        show(message, NotificationVariant.LUMO_SUCCESS);
    }

    public static void showError(String message) {
        show(message, NotificationVariant.LUMO_ERROR);
    }

    public static void showWarning(String message) {
        show(message, NotificationVariant.LUMO_CONTRAST);
    }

    public static void showInfo(String message) {
        show(message, NotificationVariant.LUMO_PRIMARY);
    }

    private static void show(String message, NotificationVariant variant) {
        Notification notification = new Notification(message, 3000, Notification.Position.TOP_CENTER);
        notification.addThemeVariants(variant);
        notification.open();
    }
}
