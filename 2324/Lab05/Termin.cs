using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab05
{
    public class Termin
    {
        private List<Service> services;
        public Person Kunde {  get; init; }
        public Person Mitarbeiter { get; init; }
        public DateTime Time {  get; init; }

        public Termin(Person kunde, Person mitarbeiter,DateTime time)
        {
            Kunde = kunde;
            Mitarbeiter = mitarbeiter;
            Time = time;
            services = new List<Service>();
        }

        public void AddService(Service s)
        {
            if (s != null) services.Add(s); else { throw new ArgumentNullException("s is null"); }
        }

        /*public List<Service> GetServices()
        {
            return services;
        }*/

        public bool Overlaps(Termin t)
        {
            DateTime intEnd = Time;
            DateTime end = t.Time;
            intEnd.AddHours(double.Parse("" + DauerInH()));
            end.AddHours(double.Parse("" + t.DauerInH()));
            if (DateTime.Compare(Time,end) > 0 || DateTime.Compare(t.Time,intEnd)>0) return false;
           else return true;
        }



        public bool Overlaps(DateTime begin, DateTime end)
        {
            DateTime intEnd = Time;
            intEnd.AddHours(double.Parse(""+DauerInH()));
            
            if (DateTime.Compare(Time, end) > 0 || DateTime.Compare(begin, intEnd) > 0) return false;
            else return true;
        }

        public decimal Beza()
        {
            decimal erg = 0;
            foreach (Service s in services)
            {
                erg += s.PreisInEur;
            }
            return erg;
        }

        public decimal DauerInH()
        {
            decimal erg = 0;
            foreach (Service s in services)
            {
                erg += s.DauerInH;
            }
            return erg;
        }
    }
}
