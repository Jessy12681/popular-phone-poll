import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="popularphone" width=400 height=300>
</applet>
*/

public class popularphone extends Applet implements ActionListener {
    int samsung_votes = 0;
    int iphone_votes = 0;

    Button samsung, iphone;
    Label result;

    public void init() {
        setLayout(new FlowLayout());

        samsung = new Button("Samsung is popular (0%)");
        iphone = new Button("iPhone is popular (0%)");

        samsung.addActionListener(this);
        iphone.addActionListener(this);

        result = new Label("Votes - Samsung: 0 | iPhone: 0");

        add(samsung);
        add(iphone);
        add(result);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == samsung) {
            samsung_votes++;
        } else if (e.getSource() == iphone) {
            iphone_votes++;
        }

        int totalVotes = samsung_votes + iphone_votes;
        int samsungPercentage = totalVotes > 0 ? (samsung_votes * 100) / totalVotes : 0;
        int iphonePercentage = totalVotes > 0 ? (iphone_votes * 100) / totalVotes : 0;

        samsung.setLabel("Samsung is popular (" + samsungPercentage + "%)");
        iphone.setLabel("iPhone is popular (" + iphonePercentage + "%)");

        result.setText("Votes - Samsung: " + samsung_votes +
                            " | iPhone: " + iphone_votes);
    }
}