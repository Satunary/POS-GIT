using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinqUebung1
{
    /// <summary>
    /// Speichert die Schülerdaten und eine Liste aller Prüfungen des Schülers.
    /// </summary>
    public class Schueler
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Vorname { get; set; }
        public string Geschlecht { get; set; }
        public string Klasse { get; set; }
        public List<Pruefung> Pruefungen { get; set; } = new List<Pruefung>();

        public Pruefung AddPruefung(Pruefung pruefung)
        {
            Pruefungen.Add(pruefung);
            pruefung.Schueler = this;
            return pruefung;
        }
        public override string ToString()
        {
            string noten = string.Join(",", Pruefungen);
            return $"{Name}, {Klasse}, {noten}";
        }
    }
}
