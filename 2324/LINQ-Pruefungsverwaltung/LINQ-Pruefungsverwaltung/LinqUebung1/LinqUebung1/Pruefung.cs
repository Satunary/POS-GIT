using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqUebung1
{
    /// <summary>
    /// Speichert eine Prüfung eines Schülers.
    /// </summary>
    public class Pruefung
    {
        public string Fach { get; set; }
        public string Pruefer { get; set; }
        public int Note { get; set; }
        public DateTime Datum { get; set; }
        public Schueler Schueler { get; set; }

        public override string ToString()
        {
            return $"{Fach} {Note}";
        }
    }
}
