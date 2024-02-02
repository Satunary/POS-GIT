using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace spg.Lab6.Model
{
    public class Normal : Kunde
    {
        public string Newsletter { set; get; }
        public Intervall? Haeufigkeit { set; get; }
        public Normal(string adresse, string email, string name, string tel, string newsletter, Intervall? haeufigkeit) : base(adresse, email, name, tel)
        {
            Newsletter = newsletter;
            Haeufigkeit = haeufigkeit;
        }
        public override decimal Kosten(Dienstleistung d)
        {
            return d.Preis;
        }
        public override string ToString()
        {
            return base.ToString() + $"\nNewsletter: {Newsletter}\nHaeufigkeit: {Haeufigkeit}";
        }
    }
}
