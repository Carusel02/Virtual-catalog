import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NotificationPageInfo extends JFrame {
    JFrame frame;

    int y = 20;
    public NotificationPageInfo(Observer observator, String text) {
        // setare frame
        frame = new JFrame("NotificationPageInfo");
        frame.setVisible(true);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        String[] createParent = text.split(" ");
        String nume = createParent[0];
        String prenume = createParent[1];
        Parent parinte = new Parent(nume,prenume);


        int i = 0;
        for(Notification notif : ((Parent)observator).getNotifications()) {
            System.out.println(notif);
            JLabel labelName = new JLabel("Number notification : " + i);
            labelName.setFont(new Font("Serif", Font.PLAIN, 20));
            labelName.setForeground(new Color(25, 25, 112));
            labelName.setLayout(null);
            labelName.setBounds(0,y,500,100);
            y += 20;
            JLabel gradeName = new JLabel(notif.grade.toString());
            gradeName.setFont(new Font("Serif", Font.PLAIN, 20));
            gradeName.setForeground(new Color(25, 25, 112));
            gradeName.setLayout(null);
            gradeName.setBounds(0,y,900,100);
            y += 40;
            frame.add(labelName);
            frame.add(gradeName);

            i++;
        }


    }

}

