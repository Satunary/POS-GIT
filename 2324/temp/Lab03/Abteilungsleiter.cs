using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab03
{
    public class Abteilungsleiter:Angestellter
    {
        public int AnzahlMitarbeiter { get; set; }

        public Abteilungsleiter(int anzahlMitarbeiter, decimal gehalt, string name, string sozVersNum):base(gehalt,name,sozVersNum) 
        {
            AnzahlMitarbeiter=anzahlMitarbeiter;
        }

        public override decimal BerechneGehalt()
        {
            return Gehalt+(AnzahlMitarbeiter*100);
        }

        public override string ToString()
        {
            return base.ToString()+"\nAnzahl Mitarbeiter: "+AnzahlMitarbeiter;
        }
    }
}
