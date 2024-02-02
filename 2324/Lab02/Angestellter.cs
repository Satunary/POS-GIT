using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab02
{
    public class Angestellter : Mitarbeiter
    {
        private decimal _gehalt;
        public decimal Gehalt {
            get
            {
                return _gehalt;
            }
            set
            {
                if (value!=null)
                {
                    _gehalt = value;
                }
                else { Console.Write("invalid Gehalt"); }
            }
        }

        public Angestellter(decimal gehalt,string name, string sozVersNum) : base(name, sozVersNum)
        {
            Gehalt = gehalt;
        }

        public override decimal BerechneGehalt()
        {
            return Gehalt;
        }

        public override string ToString()
        {
            return base.ToString();
        }

    }
}
