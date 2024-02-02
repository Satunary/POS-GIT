using spg.Lab6.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Intrinsics.X86;
using System.Text;
using System.Xml;
using System.Xml.Linq;

namespace spg.Lab6
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
           
            Verwaltung vw = new Verwaltung();
            Console.WriteLine("============= Dienstleistungen ===================");
            foreach (Dienstleistung d in vw.Dienstleistungen)
            {
                Console.WriteLine(d.ToString());
                Console.WriteLine();
            }
            Console.WriteLine("============= Kunden ===================");
            foreach (Kunde k in vw.Kunden)
            {
                Console.WriteLine(k.ToString());
                Console.WriteLine();
            }
            Console.WriteLine("============= Termine ===================");
            foreach (Termin t in vw.Termine)
            {
                Console.WriteLine(t.ToString());
                Console.WriteLine();
            }

            vw.XmlAusgabe();

            Outp(vw);

        }
        //this is the main mentioned in the task
        public static void Outp(Verwaltung vw)
        {
            Console.WriteLine("============= Sorted Name Promi Normal ===================");
            OutName(vw);
            Console.WriteLine("============= Verna ===================");
            OutVerna(vw);
            Console.WriteLine("============= Max Dienstl ===================");
            OutMaxPrDienst(vw);
            Console.WriteLine("============= Dienste anzahl geb ===================");
            OutDienstlAnzahl(vw);
            Console.WriteLine(" Ich weiß beim besten willen nicht wie ich termine nach azahl termine sortieren soll");
            OutTermSorted(vw);
        }

        public static void OutTermSorted(Verwaltung vw)
        {
            var temp = vw.Termine.GroupBy(t => t.Kunde).Select(g => new {Kundenname = g.Key.Name, Termine=g.ToList() });

            foreach (var item in temp)
            {
                Console.WriteLine($"Kunde: {item.Kundenname} hat an folgenden tagen Termine:");
                foreach (var item1 in item.Termine)
                {
                    Console.WriteLine($"Datum: {item1.Date}");
                }

            }
        }


        public static void OutName(Verwaltung vw)
        {
            foreach (var item in PromNormSortedName(vw))
            {
                Console.WriteLine(item);
            }
        }

        private static IEnumerable<string> PromNormSortedName(Verwaltung vw)
        {
            return vw.Kunden.Where(k => k.GetType()==typeof(Normal) || k.GetType()==typeof(Prominent)).OrderBy(k=>k.Name).Select(k=>k.Name);
        }

        public static void OutVerna(Verwaltung vw)
        {
            
            var temp = vw.Termine.Where(t => t.Kunde.Name == "Vera Russwurm");
            foreach (var item in temp)
            {
                Console.WriteLine($"Date: {item.Date.ToString()}");
                Console.WriteLine($"Name: {item.Kunde.Name}");
                Console.WriteLine($"Anzahl Leistungen: {item.Leistungen.Count()}");
            }

        }

        public static void OutTerm(Verwaltung vw)
        {
            foreach (var item in vw.Termine)
            {
                Console.WriteLine($"Date: {item.Date.ToString()}");
                Console.WriteLine($"Name: {item.Kunde.Name}");
                Console.WriteLine($"Kosten Leistungen: {item.Leistungen.Sum(l=>l.Preis)}");
            }
        }

        public static void OutMaxPrDienst(Verwaltung vw)
        {
            Console.WriteLine(DienstlMaxPreis(vw).Leistung);
        }
        private static Dienstleistung DienstlMaxPreis(Verwaltung vw)
        {
            return vw.Dienstleistungen.Where(d=> d.Preis==vw.Dienstleistungen.Max(l=>l.Preis)).FirstOrDefault();
        }

        public static void OutDienstlAnzahl(Verwaltung vw)
        {
            var allDienstleistungen = vw.Termine.SelectMany(t => t.Leistungen);
            var dienstleistungCounts = allDienstleistungen
                                        .GroupBy(d => d.Leistung)
                                        .Select(g => new { Dienstleistung = g.Key, Count = g.Count() })
                                        .OrderByDescending(g => g.Count);
            foreach (var d in dienstleistungCounts)
            {
                Console.WriteLine($"'{d.Dienstleistung}' wurde {d.Count} mal gebucht.");
            }
        }

    }
}
