using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace Augsten
{
    public class Bus:Transportmittel
    {
        public enum Typ
        {
            Kleinbus,
            Stockbus,
            Normal
        }

        public Typ BusTyp { get; init; }

        public Bus(Typ busTyp,decimal geschwindigkeit,decimal preisProKm,DateOnly zulassungsDatum):base(geschwindigkeit,zulassungsDatum,preisProKm)
        {
            BusTyp = busTyp;
        }

        public override decimal Kosten(decimal distanzInKm)
        {
            decimal erg = base.Kosten(distanzInKm);
            int t=0;
            if (BusTyp == Typ.Kleinbus) { erg = erg * (decimal)0.8; }
            if (distanzInKm >= 300)
            {
                t = 10 * ((int)distanzInKm / 300);
            }
            return erg+t;
        }

        public override string ToString()
        {
            return $"Bustyp: {BusTyp}\n{base.ToString()}";
        }
    }
}
