using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Augsten
{
    public class Flugzeug:Transportmittel
    {
        public string Fluglinie { get; set; }

        public Flugzeug(string fluglinie,decimal geschwindigkeit, decimal preisProKm, DateOnly zulassungsdatum):base(geschwindigkeit,zulassungsdatum,preisProKm)
        {
            Fluglinie = fluglinie;
        }

        public override decimal Kosten(decimal distanz)
        {
            if (distanz >= 200)
            {
                throw new Exception("distanz zu klein");
            }return base.Kosten(distanz);
        } 
        public override string ToString()
        {
            return $"fluglinie: {Fluglinie}\n{base.ToString()}";
        }
    }
}
