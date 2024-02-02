using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Augsten
{
    public class TransportVerwaltung
    {
        private List<Transportmittel> transportmittel;

        public TransportVerwaltung()
        {
            transportmittel = new List<Transportmittel>();
        }

        public void Einfuegen(Transportmittel t)
        {
            if(transportmittel.Contains(t)) { throw new ArgumentException("allready exists"); }
            transportmittel.Add(t);
        }

        public void SortierteAnzeige()
        {
            List<Transportmittel> ou =(from t in transportmittel
                     orderby t.PreisProKm descending
                     select t).ToList();
            ou.ForEach(t=> Console.WriteLine(t.ToString()+"\n"));
        }

        public void SortNachZulassung()
        {
            List<Transportmittel> ou = (from t in transportmittel
                                        orderby t.ZulassungsDatum descending
                                        select t).ToList();
            ou.ForEach(t => Console.WriteLine(t.ToString()+"\n"));
        }

        public IList<Transportmittel> FindeNachAlter(int baujahr)
        {
            IList<Transportmittel> ou = (from t in transportmittel
                                         where t.ZulassungsDatum.Year.CompareTo(baujahr) < 0 
                                         select t).ToList();
            return ou;
        }

        public void Loeschen(int baujahr)
        {
            List<Transportmittel> tra = (List<Transportmittel>)FindeNachAlter(baujahr);

            tra.ForEach(t=> transportmittel.Remove(t));
        }

        public decimal Reisekosten()
        {

            Random r = new Random();
            try
            {
                return transportmittel[r.Next(transportmittel.Count())].PreisProKm;
            }catch(Exception) {return -1;}
        }

    }
}
