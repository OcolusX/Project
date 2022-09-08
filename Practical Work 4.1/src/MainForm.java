import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JButton ACMilanButton;
    private JButton realMadridButton;
    private JPanel MainPanel;
    private JLabel Score;
    private JLabel LastScorer;
    private JLabel Winner;

    private int ACMilanScore = 0;
    private int realMadridScore = 0;

    private final String ACMilan = "AC Milan";
    private final String RealMadrid = "Real Madrid";

    public MainForm() {
        ACMilanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ACMilanScore++;
                Score.setText(ACMilanScore + " X " + realMadridScore);
                LastScorer.setText(ACMilan);

                if(ACMilanScore > realMadridScore) {
                    Winner.setText(ACMilan);
                } else if(ACMilanScore < realMadridScore) {
                    Winner.setText(RealMadrid);
                } else {
                    Winner.setText("DRAW");
                }
            }
        });

        realMadridButton.addActionListener(e -> {
            realMadridScore++;
            Score.setText(ACMilanScore + " X " + realMadridScore);
            LastScorer.setText(RealMadrid);

            if(ACMilanScore > realMadridScore) {
                Winner.setText(ACMilan);
            } else if(ACMilanScore < realMadridScore) {
                Winner.setText(RealMadrid);
            } else {
                Winner.setText("DRAW");
            }
        });
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
}
