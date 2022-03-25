public class Monom_d {
    private double coeficient;
    private int putere;


    public Monom_d(int c, int p){
        this.coeficient = c;
        this.putere = p;
    }

    public void integrare() {
        putere++;
        coeficient = coeficient / putere;
    }

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
