using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Augsten
{
    public abstract class Transportmittel
    {
        private decimal _geschwindigkeit;
        
        private decimal _preisProKm;

        public decimal Geschwindigkeit {get { return _geschwindigkeit;} init { if (value > 0) { _geschwindigkeit = value; } else { throw new InvalidDataException(); } } }
        public DateOnly ZulassungsDatum { get; init; }

        public decimal PreisProKm { get { return _preisProKm;} set { if (value > 0) _preisProKm = value; else { throw new InvalidDataException(); } } }

        public Transportmittel(decimal geschwindigkeit, DateOnly zulassungsDatum, decimal preisProKm)
        {
            Geschwindigkeit = geschwindigkeit;
            ZulassungsDatum = zulassungsDatum;
            PreisProKm = preisProKm;
        }

        public virtual decimal Kosten(decimal distanzInKm)
        {
            return PreisProKm * distanzInKm;
        }

        public override string ToString()
        {
            return $"Geschwindigkeit: {Geschwindigkeit}\nPreis pro Km: {PreisProKm}\nZulassungsdatum: {ZulassungsDatum.ToString()}";
        }
    }
}
