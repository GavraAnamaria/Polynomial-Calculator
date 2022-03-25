import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private Polinom p1 = new Polinom();
    private Polinom p2 = new Polinom();


//----------------------------------[ PRELUCRARE DATE ]-------------------------------------------------

    public Polinom stringToPolynom(String input) throws Exception {
        Polinom p = new Polinom();
        int nrCaractere = 0;
        Monom o = new Monom(1, 0);
        final String patternString = "([-+]?[0-9]*x[ ^][0-9]+)|([+-]?[0-9]+x?)|([+-]?[0-9]*x)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            nrCaractere += (matcher.group(0).length());
            p.getPol().add ( o.stringToMonom (matcher.group(0)) );
        }
        if(nrCaractere != input.length()) {
            throw new Exception("POLINOAMELE CONTIN CARACTERE NEPERMISE!");
        }

        p.reducere();
        System.out.println(p);
        return p;
    }

    public void setVal(String polinom1, String polinom2) throws Exception {
        this.p1 = stringToPolynom(polinom1);
        this.p2 = stringToPolynom(polinom2);
    }


//------------------------------------[ OPERATII ]--------------------------------------------


    public Polinom suma()  {
        System.out.println(p1);
        System.out.println(p2);
        return p1.adunare(p2);
    }

    public Polinom diferenta()  {
        System.out.println(p1);
        System.out.println(p2);
        return p1.scadere(p2);
    }

    public Polinom produs() {
        System.out.println(p1);
        System.out.println(p2);
        return p1.inmultire(p2);
    }

    public Polinom cat() throws Exception {
        System.out.println(p1);
        System.out.println(p2);
        return p1.impartire(p2);
    }

    public Polinom derivare() {
        System.out.println(p1);
        System.out.println(p2);
        return p1.derivare();
    }

    public Polinom integrare() {

        System.out.println(p1);
        System.out.println(p2);
        for(Monom m: p1.getPol())
            p1.getPol_d().add(new Monom_d(m.getCoef(), m.grad()));
        return p1.integrare();
    }

    public void reset() {
        p1.getPol() .clear();
        p2.getPol() .clear();
    }
}
