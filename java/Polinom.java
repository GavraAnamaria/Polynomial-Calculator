import java.util.ArrayList;
import java.util.Collections;


public class Polinom {
    private ArrayList<Monom> pol = new ArrayList<>();
    private ArrayList<Monom_d> pol_d = new ArrayList<>();
    private int grad;

//--------------------------------[ ACCESARE VARIABILE ]-------------------------------------------

    public ArrayList<Monom> getPol(){
        return this.pol;
    }

    public ArrayList<Monom_d> getPol_d(){
        return this.pol_d;
    }


//--------------------------------[ PRELUCRARE DATE ]-------------------------------------------

    public void reducere() {
        Collections.sort(this.pol);
        for(int i=0; i < pol.size(); i++) {
            while( i < pol.size()-1 && pol.get(i).grad() == pol.get(i+1).grad()) {
                int val = pol.get(i).getCoef() + pol.get(i+1).getCoef();
                pol.get(i).setCoef(val);
                pol.remove(i+1);
            }
            if(pol.get(i).getCoef() == 0) {
                pol.remove(i);
                if(pol.size() == 0)
                    return;
            }
        }
        grad = pol.get(0).grad();
    }


//------------------------------------[ OPERATII ]--------------------------------------------

    public Polinom adunare(Polinom p) {
        Polinom rezultat = new Polinom();
        (rezultat.pol).addAll(this.pol);
        (rezultat.pol).addAll(p.pol);
        rezultat.reducere();
        return rezultat;
    }

    public Polinom scadere(Polinom p){
        for(Monom m:p.pol)
            m.setCoef(-m.getCoef());
        return this.adunare(p);
    }

    public Polinom inmultire(Polinom p){
        Polinom rezultat = new Polinom();
        rezultat.pol.add(new Monom(0,0));

        if(p.pol.size() == 0)
            return rezultat;

        for(Monom m:pol)
            for(Monom m2:p.pol)
                rezultat.pol.add(m.inmultire(m2));

        rezultat.reducere();
        return rezultat;
    }


    public Polinom impartire(Polinom p) throws Exception{
        Polinom q = new Polinom();
        Polinom r = this;
        q.pol.add(new Monom(0,0));

        if(p.pol.size() != 0)
            while(r.pol.size() != 0 && r.grad >= p.grad) {
                Monom t = r.pol.get(0).impartire(p.pol.get(0));
                if(t.getCoef() == 0) {
                    r.pol.remove(0);
                    continue;
                }
                q.pol.add(t);
                Polinom tp = new Polinom();
                tp.pol.add(t);
                r = r.scadere( tp.inmultire(p) );
            }
        else throw new Exception ("Impartire la 0");
        q.reducere();
        return q;
    }


    public Polinom derivare(){
        for(Monom m:pol)
            m.derivare();
        this.reducere();
        return this;
    }

    public Polinom integrare(){
        for(Monom_d m:pol_d)
            m.integrare();
        return this;
    }

//----------------------------------------[ AFISARE ]-----------------------------------------

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Monom m:this.pol) {
            s.append(m.toString());
        }
        return s.toString();
    }

    public String toString_d() {
        StringBuilder s = new StringBuilder();
        for(Monom_d m:this.pol_d) {
            s.append(m.toString());
        }
        return s.toString();
    }
}