using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace spg.Lab6.Model
{
    public class Dienstleistung : IEquatable<Dienstleistung>
    {
        private string _leistung;
        private decimal _preis;
        private double _zeitAufwand;

        public Dienstleistung(string leistung, decimal preis, double zeitAufwand)
        {
            Leistung = leistung;
            Preis = preis;
            ZeitAufwand = zeitAufwand;
        }
        public string Leistung
        {
            get => _leistung;
            set => _leistung = value ?? throw new ArgumentException("Leistung ist null!");
        }

        public decimal Preis
        {
            get => _preis;
            set
            {
                if (value < 0) throw new ArgumentException("Preis ist kleiner 0!");

                _preis = value;
            }
        }

        public double ZeitAufwand
        {
            get => _zeitAufwand;
            set
            {
                if (value < 0) throw new ArgumentException("Zeitaufwand ist kleiner 0!");

                _zeitAufwand = value;
            }
        }

        public override string ToString()
        {
            return $"{Leistung} für {Preis} dauert {ZeitAufwand} Stunden";
        }
        public override bool Equals(object? obj)
        {
            return Equals(obj as Dienstleistung);
        }
        public bool Equals(Dienstleistung? other)
{
            return (other == null) ? false : Leistung == other.Leistung;
        }
        public override int GetHashCode()
        {
            return HashCode.Combine(Leistung, Preis, ZeitAufwand);
        }
    }
}
