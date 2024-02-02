using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab03
{
    public class Ort
    {
       
        public int Postleitzahl { get; }
        public string Stadt { get; }
        public string Strasse { get; }
        public Ort(int postleitzahl, string stadt, string strasse) 
        { 
            if (postleitzahl != null ) 
            { Postleitzahl = postleitzahl; }
            else { throw new NoNullAllowedException("Postleitzahlmust be set"); }
            if (stadt != null && !(stadt.Contains('#'))) 
            { Stadt = stadt; }
            else { throw new NoNullAllowedException("Stadt must be set"); }
            if (strasse != null && !(strasse.Contains('#'))) 
            { Strasse = strasse; }
            else { throw new NoNullAllowedException("Strasse must be set"); }
        }
        public int CompareTo(Ort ort) {
            if (ort == null) return -1;
            if (Equals(ort)) return 0; return -1; 
        }
        public override Boolean Equals(Object obj) {
            if (obj is Ort) {
                return Equals(obj as Ort);
            }
            return false; 
        }
        public Boolean Equals(Ort ort) {
            return ort.Strasse == Strasse && ort.Stadt == Stadt && ort.Postleitzahl == Postleitzahl;
        }

        public override int GetHashCode() { return base.GetHashCode(); }

    

        public override string ToString()
        {
            return "Postal Code: "+Postleitzahl + " City: " + Stadt + " Street: " + Strasse;
        }

        public string WriteData()
        {
            return Postleitzahl +"#"+ Stadt +"#"+ Strasse;
        }
    }
}
