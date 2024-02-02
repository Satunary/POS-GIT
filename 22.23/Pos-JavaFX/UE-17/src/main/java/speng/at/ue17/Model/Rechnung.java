package speng.at.ue17.Model;

import java.util.Arrays;
import java.util.Iterator;

public class Rechnung {
    private String rechnung;
    private int erg;

    @Override
    public String toString() {
        return rechnung+"="+erg;
    }

    public Rechnung(String rechnung,int ergebnis){
        setRechnung(rechnung);
        setErg(ergebnis);
    }

    public void setRechnung(String rechnung) {
        this.rechnung=rechnung;
    }

    public void setErg(int erg) {
        this.erg = erg;
    }

    public String getRechnung() {
        return rechnung;
    }

    public int getErg() {
        return erg;
    }
}
