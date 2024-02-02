using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace spg.Lab6.Model
{
    public class Verwaltung
    {
        public List<Dienstleistung> Dienstleistungen { set; get; } = new List<Dienstleistung>();
        public List<Kunde> Kunden { set; get; } = new List<Kunde>();
        public List<Termin> Termine { set; get; } = new List<Termin>();
        public Verwaltung()
        {
            Init();
        }
        /// <summary>
        /// ES gibt KEIN pruefen auf falsche Eintraege -> Exceptions!!!
        /// TODO: Umbauen auf sicheres einlesen d.h. Fehler melden (z.B. Telefonnummer fehlt).
        /// </summary>
        public void Init()
        {
            // Achtung: Autohaus.txt hat CopyToOutput... gesetzt!!!
            string[] lines = File.ReadAllLines("Autohaus.txt", Encoding.UTF8);
            foreach (string line in lines)
            {
                if (!string.IsNullOrEmpty(line))
                {
                    string[] split = line.Split(";");
                    switch (split[0])
                    {
                        case "Promi":
                            if (split.Length > 6 && Int32.TryParse(split[6], out int i0))
                            {
                                Kunden.Add(new Prominent(Int32.Parse(split[6]), split[5], split[2], split[4], split[1], split[3]));
                            }
                            else { Console.WriteLine($"{line} is invalid"); }
                            break;
                        case "Normal":
                            Intervall? intervall = null;
                            if (split.Length > 6 && Enum.TryParse<Intervall>(split[6], true, out Intervall intervallFile))
                            {
                                intervall = intervallFile;

                                Kunden.Add(new Normal(split[2], split[4], split[1], split[3], split[5], intervall));
                            }
                            else { Console.WriteLine($"{line} is invalid"); }
                            break;
                        case "TestPerson":
                            if (split.Length > 6 && decimal.TryParse(split[6], out decimal i1))
                            {
                                Kunden.Add(new TestPerson(split[2], split[4], split[1], split[3], split[5], decimal.Parse(split[6])));
                            }
                            break;
                        case "Dienstleistung":
                            split[2] = split[2].Replace(".", ",");
                            split[3] = split[3].Replace(".", ",");
                            if (split.Length > 3 && Decimal.TryParse(split[2], out decimal i2) && Double.TryParse(split[3], out double d0))
                            {
                                Dienstleistungen.Add(new Dienstleistung(split[1], Decimal.Parse(split[2]), Double.Parse(split[3])));
                                break;
                            }
                            Console.WriteLine($"{line} is invalid");
                            break;
                        case "Termin":
                            if (split.Length > 3)
                            {
                                Kunde kunde = null!; //split[1], keine Pruefung!!!
                                foreach (Kunde k in Kunden)
                                {
                                    if (split[1].Equals(k.Name))
                                        kunde = k;
                                }
                                if (kunde != null)
                                {
                                    LinkedList<Dienstleistung> leistungen = new LinkedList<Dienstleistung>(); //split[2]
                                    string[] l = split[2].Split(" ");
                                    Termin t = new Termin(DateTime.Parse(split[3]), kunde);
                                    foreach (string leistung in l)
                                    {
                                        foreach (Dienstleistung d in Dienstleistungen)
                                        {
                                            if (leistung.Equals(d.Leistung))
                                            {
                                                t.AddLeisung(d);
                                            }
                                        }
                                    }
                                    if (t.Leistungen.Count > 0) Termine.Add(t);
                                }
                                break;
                            }
                            Console.WriteLine($"{line} is invalid");
                            break;
                    }
                }
            }
            Sort();
        }
        public void Sort()
        {
            SortDienstleistungen();
            SortKunden();
            SortTermine();
        }
        public void SortDienstleistungen()
        {
            // Anonymous delegate
            Dienstleistungen.Sort(delegate (Dienstleistung dl1, Dienstleistung dl2)
            {
                return dl1.Leistung.CompareTo(dl2.Leistung);
            });
        }
        public void SortKunden()
        {
            // Delegate
            Kunden.Sort((x, y) => x.Name.CompareTo(y.Name));
        }
        public void SortTermine()
        {
            // IComparable
            Termine.Sort();
        }
        public void SortKundenMail()
        {
            // Comparer
            Kunden.Sort(new SortMail());
        }

        /// <summary>
        /// Das Delegate "besser" wird auf sämtliche Termine der "Termine" Collection angewendet.
        /// </summary>
        /// <param name="besser"></param>
        /// <returns>Den besten Termin</returns>
        public Termin BesterTermin(Func<Termin, Termin, Termin> besser)
        {
            // TODO: Implementierung fehlt!
            if (Termine.Count == 0)
            {
                return null;
            }
            Termin bestTermin = Termine[0];
            Termine.ForEach(t => besser(t, bestTermin));
            return bestTermin;
        }

        /// <summary>
        /// Das Delegate ausgeben wird auf sämtliche Kunden der "Kunden" Collection angewendet.
        /// </summary>
        /// <param name="ausgeben"></param>
        public void Ausgeben(Action<Kunde> ausgeben)
        {
            // TODO: Implementierung fehlt!

            Kunden.ForEach(k => ausgeben(k));
        }

        public void XmlAusgabe()
        {
            var data = from d in Dienstleistungen
                       select new XElement("Dienstleistung",
                                             new XAttribute("Leistung", d.Leistung),
                                             new XElement("Preis", d.Preis),
                                             new XElement("Aufwand", d.ZeitAufwand)
                       );
            var root = new XElement("Dienstleistungen", data);
            Console.WriteLine(root);

            // TODO: Weitere Ausgeben fehlen! Kunde, ...

            var kun = from k in Kunden
                      select new XElement("Kunde",
                                            new XAttribute("Adresse", k.Adresse),
                                            new XAttribute("Email", k.Email),
                                            new XAttribute("Telefonnummer", k.Telefonnummer),
                                            new XAttribute("Name", k.Name)
                      );
            var roots = new XElement("Kunden", kun);
            Console.WriteLine(roots);

            //termin
            var ter = from t in Termine
                      select new XElement("Termin",
                                            new XElement("Datum", t.Date),
                                            new XAttribute("Kunde", t.Kunde.Name),
                                            new XElement("Leistungen", from l in t.Leistungen select new XElement("Leistung", l.Leistung))

                      );
            var rootss = new XElement("Termine", ter);
            Console.WriteLine(rootss);
        }

    }

    class SortMail : Comparer<Kunde>
    {
        public override int Compare(Kunde x, Kunde y)
        {
            return x.Email.CompareTo(y.Email);
        }
    }
}
