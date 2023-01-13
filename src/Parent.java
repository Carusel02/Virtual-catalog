import java.util.ArrayList;

public class Parent extends User implements Observer{


    ArrayList<Notification> notifications;

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void update(Notification notification) {
        if(notifications == null)
            notifications = new ArrayList<>();

        notifications.add(notification);
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }
}
