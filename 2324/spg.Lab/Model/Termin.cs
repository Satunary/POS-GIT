using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace spg.Lab6.Model
{
    public class Termin : IComparable<Termin>
    {
        public DateTime Date { set; get; }
        public Kunde Kunde { set; get; }
        public List<Dienstleistung> _leistungen { get; } = new();
        public Termin(DateTime date, Kunde kunde)
        {
            Date = date;
            Kunde = kunde;
        }

        public IReadOnlyList<Dienstleistung> Leistungen => _leistungen.AsReadOnly();
        public void AddLeisung(Dienstleistung dienstleistung)
        {
            _leistungen.Add(dienstleistung);
        }

        public override string ToString()
        {
            string s = $"Termin:\n\tDatum: {Date}\n\tKunde: {Kunde.Name}";

            bool first = true;
            foreach (Dienstleistung l in Leistungen)
            {
                if(first)
                {
                    s += "\n\tDienstleistungen: " + l.Leistung;
                    first = !first;
                }
                else
                {
                    s += ", " + l.Leistung;
                }
            }
            return s;
        }
        public int CompareTo(Termin? termin)
        {
            return Date.CompareTo(termin?.Date);
        }
        public override bool Equals(object? obj)
        {
            return Equals(obj as Termin);
        }
        public bool Equals(Termin? other)
        {
            return (other == null) ? false : (Date == other.Date) && (Date.Equals(other.Date));
        }
        public override int GetHashCode()
        {
            return HashCode.Combine(Date, Kunde, Leistungen);
        }
    }
}
