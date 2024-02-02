using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab03
{
    public class Termin:IComparable
    {
        private DateTime _datumUndZeit;
        private int _prioritaet;
        private string _thema;
        private Ort _ort;
        public int Prioritaet {
            get 
            { return _prioritaet; } 
            set {
                if (value >= 0 && value <= 5) _prioritaet = value;
                else throw new InvalidDataException("priority is only viable 0 to 5"); 
            } 
        }
        public string Thema {
            get 
            { return _thema; }
            set {
                if (value != null && !(value.Contains("#"))) _thema = value;
                else throw new NoNullAllowedException("Thema must be set and may not contain #"); 
            } 
        }
        public Ort Ort { 
            get 
            { return _ort; }
            set {
                if (value != null) _ort = value;
                else throw new NoNullAllowedException("Ort must be set"); 
            } 
        }
        public DateTime DatumUndZeit {
            get 
            { return _datumUndZeit; } 
            set { if (value != null) _datumUndZeit = value;
                else throw new NoNullAllowedException("DateTime must be set"); } }
        public Termin(DateTime dat, int prio, string them, Ort ort)
        { 
            DatumUndZeit = dat;
            Thema = them;
            Ort = ort;
            Prioritaet = prio;
        }

        public string WriteData()
        {
            return DatumUndZeit.ToString("s")+"#"+Prioritaet+"#"+Thema+"#"+ Ort.WriteData();
        }

        public override string ToString()
        {
            return "Date and Time: "+DatumUndZeit.ToString("s") + "\nPriority: " + Prioritaet + " Topic: " + Thema + " Location\n" + Ort.WriteData();
        }
        
        public int CompareTo(object? obj)
        {
            if (obj == null) return 1;
            Termin termin = obj as Termin;
            if (termin == null) throw new ArgumentException("obj is not a Termin");
            else return this.Prioritaet.CompareTo(termin.Prioritaet);
            
        }

        public override bool Equals(Object obj)
        {
            if(obj==null) return false;
            if (!(obj is Termin)) return false;
            else return Equals(obj as Termin);
        }

        public bool Equlas(Termin ter)
        {
            if(ter!=null&&ter==this) return true;
            else return false;
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
