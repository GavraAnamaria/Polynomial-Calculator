public class Monom  implements Comparable<Monom>{
    private int coeficient;
    private int putere;

    public Monom(int c, int p){
        this.coeficient = c;
        this.putere = p;
    }

//------------------------------------[ ACCESARE VARIABILE ]--------------------------------------------

    public int grad() {
        return this.putere;
    }

    public int getCoef() {
        return this.coeficient;
    }

    public void setCoef(int val) {
        this.coeficient = val;
    }

    public int compareTo(Monom x) {
        if(putere == x.putere && coeficient == x.coeficient)
            return 0;
        return -Integer.compare(putere, x.putere);
    }



//------------------------------------[ OPERATII ]--------------------------------------------



    public Monom inmultire(Monom m) {
        return new Monom(this.coeficient * m.coeficient, this.putere + m.putere);
    }

    public Monom impartire(Monom m){
        return new Monom((this.coeficient / m.coeficient), this.putere - m.putere);
    }

    public void derivare() {
        if(putere == 0)
            coeficient = 0;
        else {
            coeficient = coeficient * putere;
            putere--;
        }
    }


//------------------------------------[ CITIRE ]--------------------------------------------


    public Monom stringToMonom(String s) {
        int c = 1;
        int p = 1;
        try{                    //verificam daca e termen liber
            c = Integer.parseInt(s);
            return new Monom(c, 0);
        }catch (NumberFormatException e)
        {
            if(s.indexOf("x")==1 && s.charAt(0) == '-') {  //x este precedat de semnul "-"
                c = -1;
            }
            if(s.indexOf("x") > 1 || (s.indexOf("x") == 1 && s.charAt(0) != '+' && s.charAt(0) != '-')) { //x est precedat de un numar
                c = Integer.parseInt(s.substring(0,s.indexOf("x")));
            }
            if(s.contains("^")) {
                p = Integer.parseInt( s.substring( s.indexOf("^")+1 ) );
            }
            return new Monom(c, p);
        }
    }

//------------------------------------[ AFISARE ]--------------------------------------------


    @Override
    public String toString() {
        String s = "";
        if(coeficient < 0)
            if(coeficient == -1 && putere != 0)
                s = s + "-";
            else
                s = s + coeficient;
        else
        if(coeficient == 1 && putere != 0)
            s = s + "+";
        else
            s = s + "+" + coeficient;
        if(putere == 1)
            s = s + "x";
        if(putere > 1)
            s = s + "x^" + putere;
        return s;
    }
}
