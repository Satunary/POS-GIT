using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace spg.Lab6.Model
{
    public class TestPerson : Kunde
    {
        public string Firma { set; get; }
        public decimal? Stundensatz { set; get; }
        public TestPerson(string adresse, string email, string name, string tel, string firma, decimal? stundensatz) : base(adresse, email, name, tel)
        {
            Firma = firma;
            Stundensatz = stundensatz;
        }
        public override decimal Kosten(Dienstleistung d)
        {
            if (Stundensatz.HasValue)
            {
                return Stundensatz.Value * ((decimal)d.ZeitAufwand);
            }
            else
            {
                return 0m;
            }
        }
        public override string ToString()
        {
            return base.ToString() +
                ((Stundensatz != null) ? $"\nStundensatz: {Stundensatz}%" : "") +
                $"\nFirma: {Firma}"
                ;
        }

    }
}
