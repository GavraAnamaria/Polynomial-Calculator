import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class View extends JFrame {
    private JTextField inP1 = new JTextField(70);
    private JTextField inP2 = new JTextField(70);
    private JTextField outTf = new JTextField(60);
    private JButton prod = new JButton("Inmultire");
    private JButton sum = new JButton("Adunare");
    private JButton dif = new JButton("Scadere");
    private JButton imp = new JButton("Impartire");
    private JButton deriv = new JButton("Derivare");
    private JButton integr = new JButton("Integrare");
    private JButton rst = new JButton("Reset");

    View() {

        JPanel panou = new JPanel();
        panou.setLayout(new BoxLayout(panou, BoxLayout.Y_AXIS));
        panou.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(new JLabel("P1:"));
        p1.add(inP1);
        panou.add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("P2:"));
        p2.add(inP2);
        panou.add(p2);

        JPanel operatii = new JPanel();
        operatii.setLayout(new GridLayout(0,2));
        operatii.add(sum);
        operatii.add(dif);
        operatii.add(prod);
        operatii.add(imp);
        operatii.add(deriv);
        operatii.add(integr);
        sum.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        panou.add(operatii);

        JPanel rez = new JPanel();
        rez.setLayout(new FlowLayout());
        rez.add(new JLabel("Rezultat:"));
        rez.add(outTf);
        rez.add(rst);
        panou.add(rez);


        outTf.setEditable(false);
        this.setContentPane(panou);
        this.pack();
        this.setTitle("Polinoame");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//----------------------------------[ INTRODUCERE POLINOAME ]---------------------------------------------------

    String getP1() {
        return inP1.getText();
    }

    String getP2() {
        return inP2.getText();
    }

//--------------------------------------[ AFISARE ]------------------------------------------


    void setOutput(String rezultat) {
        outTf.setText(rezultat);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void reset() {
        outTf.setText("0");
        inP1.setText("0");
        inP2.setText("0");
    }

//----------------------------------[ ASCULTATORI ]------------------------------------------

    void sumListener(ActionListener act) {
        sum.addActionListener(act);
    }

    void difListener(ActionListener act) {
        dif.addActionListener(act);
    }

    void prodListener(ActionListener act) {
        prod.addActionListener(act);
    }

    void catListener(ActionListener act) {
        imp.addActionListener(act);
    }

    void derivListener(ActionListener act) {
        deriv.addActionListener(act);
    }

    void integrListener(ActionListener act) {
        integr.addActionListener(act);
    }

    void rstListener(ActionListener act) {
        rst.addActionListener(act);
    }
}
