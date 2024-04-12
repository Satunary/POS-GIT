using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PlfsMaui.Model
{
    public class Schueler
    {
        public int Schnr { get; set; }
        public string Nachname { get; set; } = default!;
        public string Vorname { get; set; } = default!;
        public DateTime? Gebdat { get; set; }
        public string? Adresse { get; set; }
        public string? Klasse { get; set; }
    }
}
