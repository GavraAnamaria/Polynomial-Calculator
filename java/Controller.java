import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model m;
    private View v;

    Controller(Model model, View view) {
        m = model;
        v = view;
        v.sumListener(new sListener());
        v.difListener(new dListener());
        v.prodListener(new pListener());
        v.catListener(new cListener());
        v.derivListener(new deListener());
        v.integrListener(new iListener());
        v.rstListener(new rListener());
    }

    class sListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m.setVal(v.getP1(), v.getP2());
                v.setOutput(m.suma().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }//x^5+5x^4+3x^5+3x^3-x^8-6x+8
        }//x^7-x^8+9x-14x^5-x^3+12x^6+6x-8
    }//-2x^8+x^7+12x^6-10x^5+5x^4+2x^3+9x

    class dListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m.setVal(v.getP1(), v.getP2());
                v.setOutput(m.diferenta().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }

    class pListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m.setVal(v.getP1(), v.getP2());
                v.setOutput(m.produs().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }
    class cListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m.setVal(v.getP1(), v.getP2());
                v.setOutput(m.cat().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }

    class deListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m.setVal(v.getP1(), v.getP2());
                v.setOutput(m.derivare().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }

    class iListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                m.setVal(v.getP1(), v.getP2());
                v.setOutput(m.integrare().toString_d());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }
    class rListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            reset();
        }
    }
    public void reset() {
        v.reset();
        m.reset();
    }
}
