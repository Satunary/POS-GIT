using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab0{
    public class Schule
    {
        private string vorname = "";
        public void setVorname(string vorname)
        {
            this.vorname = vorname;
        }
        public string getVorname()
        {
            return this.vorname;
        }
        // C# mit properties
        private string _nachname; //code convention field

        public Schule(string vorname = "ur mum", int alter = 25)
        {
            this.vorname = vorname;
            _nachname = "AAAAAAAAA";
            Alter = alter;
        }

        public string Nachname {
            get
            {  return this._nachname; }
             set
            {
                if(value.Length < 2) {
                    throw new ArgumentException("nachname zu kurz");
                }
                _nachname = value;
            } 
        }
        public int Alter { get; set; }

        public override string ToString()
        {
            return Nachname +" "+getVorname()+" "+Alter;
        }
    }
  
}
