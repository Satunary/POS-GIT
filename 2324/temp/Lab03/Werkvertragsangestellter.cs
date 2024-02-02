using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab03
{
    public class Werkvertragsangestellter:Mitarbeiter
    {
        public decimal Stunden {  get; set; }
        public decimal StundenLohn { get; set; }

        public Werkvertragsangestellter(decimal stunden,decimal stundenLohn, string name, string sozVersNum):base(name, sozVersNum)
        {
            Stunden = stunden;
            StundenLohn = stundenLohn;
        }

        public override decimal BerechneGehalt()
        {
            return Stunden*StundenLohn;
        }

        public override string ToString()
        {
            return base.ToString()+"\nStunden: "+Stunden+"\nStundenlohn: "+StundenLohn;
        }
    }
}
