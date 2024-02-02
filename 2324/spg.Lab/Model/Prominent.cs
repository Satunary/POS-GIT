using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace spg.Lab6.Model
{
    public class Prominent : Kunde
    {
        public int? Rabatt { set; get; }
        public string Sonderbehandlungen { set; get; }
        public Prominent(int? rabatt, string sonderbehandlungen, string adresse, string email, string name, string tel) : base(adresse, email, name, tel)
        {
            Rabatt = rabatt;
            Sonderbehandlungen = sonderbehandlungen;
        }
        public override decimal Kosten(Dienstleistung d)
        {
            return d.Preis - (d.Preis / 100 * (Rabatt ?? 0));
        }

        public override string ToString()
        {
            return base.ToString() + 
                ((Rabatt != null) ? $"\nRabatt: {Rabatt}%" : "") + 
                (string.IsNullOrEmpty(Sonderbehandlungen) ? "" : $"\nSonderbehandlungen: {Sonderbehandlungen}")
                ;
        }
    }
}
