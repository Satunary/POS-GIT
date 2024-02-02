using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab02
{
   public class Teilzeitangestellter:Angestellter
    {
        private decimal _stundenProWoche;
        public decimal StundenProWoche { 
            get {
                return _stundenProWoche; 
            } 
            set {
                if (value > 9 && value < 31)
                { _stundenProWoche = value; }
                else { Console.Write("invalid value"); } } } 
        
        public Teilzeitangestellter(decimal stundenProWoche, decimal gehalt, string name, string sozVersNum) : base(gehalt, name, sozVersNum)
    {
        StundenProWoche = stundenProWoche;
    }

    public override decimal BerechneGehalt()
    {
            return Gehalt * StundenProWoche/5 ;
    }
        public override string ToString()
        {
            return base.ToString()+"\nWochenstunden: "+StundenProWoche;
        }
    }
}
