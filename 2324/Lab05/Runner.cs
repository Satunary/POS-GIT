using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Lab05
{
    public class Runner
    {
        private List<Service> services;
        private List<Person> kunden;
        private List<Person> arbeiter;
        private List<Termin> termine;

        public Runner()
        {
            services = new List<Service>();
            kunden = new List<Person>();
            arbeiter = new List<Person>();
            termine = new List<Termin>();
        }

        
        public void ReadFromFile(string filename)
        {
            
            try
            {
                string[] lines = File.ReadAllLines(filename);
                foreach (string line in lines)
                {
                    Insert(line);
                }
            }catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
       
        public void Insert(string s)
        {
            if(s.Contains(";")) 
            {
                string[] split = s.Split(';');
                
                /*
                 * darf ich nicht warum auch immer
                split[0] switch
                {
                    "Promi" => InsertStamKunde(split),
                    "Normal" => InsertKunde(split),
                    "Angestellter" => InsertArbeiter(split),
                    "Dienstleistung" => InsertService(split),
                    "Termin" => InsertTermin(split),
                    _ => Nothing(), eine exeption funktioniert auch nicht
                }; */
                switch(split[0])
                {
                    case "Promi":
                        InsertStamKunde(split);
                        break;
                    case "Normal":
                        InsertKunde(split);
                        break;
                    case "Angestellter":
                        InsertArbeiter(split);
                        break;
                    case "Dienstleistung":
                        InsertService(split);
                        break;
                    case "Termin":
                        InsertTermin(split);
                        break;
                    default: break;
                }
            }
        }
        private void InsertService(string[] s)
        {
            if (s.Length < 4) Console.WriteLine("Invalid dataset");
            else
            {
                if (services.FindIndex(x => x.Bez == s[1]) != -1)
                {
                    throw new DuplicateWaitObjectException($"{s[1]} existiert bereits");
                }
                services.Add(new Service(s[1], decimal.Parse(s[2].Replace(".", ",")), decimal.Parse(s[3].Replace(".", ","))));
            }
        }
        private void InsertArbeiter(string[] s)
        {
            if (s.Length < 6) Console.WriteLine("Invalid dataset");
            else
            {
                if (arbeiter.FindIndex(x => x.Name == s[1]) != -1)
                {
                    throw new DuplicateWaitObjectException($"{s[1]} existiert bereits");
                }
                arbeiter.Add(new Person(s[2], s[1], s[4], s[3], Person.typ.Mitarbeiter, Person.erinnerung.blank, decimal.Parse(Regex.Replace(s[5], "[A-Za-z\\s]", "")), 0, ""));
            }
        }
        private void InsertKunde(string[] s)
        {
            if (s.Length < 6) Console.WriteLine("Invalid dataset");
            else
            {
                if (kunden.FindIndex(x => x.Name == s[1]) != -1)
                {
                    throw new DuplicateWaitObjectException($"{s[1]} existiert bereits");
                }
                Person.erinnerung er = Person.erinnerung.Nie;
                switch (s[5])
                {
                    case "nie":
                        er = Person.erinnerung.Nie; break;
                    case "monatlich":
                        er = Person.erinnerung.Monatlich; break;
                    case "jaehrlich":
                        er = Person.erinnerung.Jaehrlich; break;
                    default: break;
                }
                kunden.Add(new Person(s[2], s[1], s[4], s[3], Person.typ.Kunde, er, 0, 0, ""));
            }
        }
        private void InsertStamKunde(string[] s)
        {
            if (s.Length < 7) Console.WriteLine("Invalid dataset");
            else
            {
                if (kunden.FindIndex(x => x.Name == s[1]) != -1)
                {
                    throw new DuplicateWaitObjectException($"{s[1]} existiert bereits");
                }
                kunden.Add(new Person(s[2], s[1], s[4], s[3], Person.typ.Stammkunde, Person.erinnerung.blank, 0, decimal.Parse(s[6].Trim()), s[5]));
            }
        }
        private void InsertTermin(string[] s)
        {
            if (s.Length < 5) Console.WriteLine("Invalid dataset");
            else
            {
                int k;
                int a;
                int snum;

                if ((k = kunden.FindIndex(x => x.Name == s[1])) != -1 && (a = arbeiter.FindIndex(x => x.Name == s[4])) != -1)
                {
                    string[] sd = Regex.Split(s[3], "[.:\\s]");
                    int[] ints = new int[sd.Length];
                    for (int i = 0; i < sd.Length; i++)
                    {
                        ints[i] = int.Parse(sd[i]);
                    }

                    Termin t = new Termin(kunden[k], arbeiter[a], new DateTime(ints[0], ints[1], ints[2], ints[3], ints[4], 0));
                    string[] split = s[2].Split(" ");
                    foreach (string s2 in split)
                    {
                        if ((snum = services.FindIndex(x => x.Bez == s2)) != -1)
                        {
                            t.AddService(services[snum]);
                        }
                        else throw new MissingMemberException($"service {s2} existiert nicht");
                    }

                    if (IsBuisy(t, s[4])) throw new ArgumentException($"{s[4]}ist beschäftigt");

                    if (termine.Contains(t)) throw new DuplicateWaitObjectException("dieser Termin existiert bereits");

                    termine.Add(t);
                }
                else throw new MissingMemberException($"Kunde oder Arbeiter existiert nicht");
            }
        }

        private bool IsBuisy(Termin t, string name)
        {
            var res = Enumerable.Range(0,termine.Count)
                .Where(x => termine[x].Mitarbeiter.Name.Equals(name)) 
                .ToList();

            bool over = false;
            int i = 0;
            while (!over && i<res.Count)
            {
                over = t.Overlaps(termine[res[i]]);
            }
            return over;
        }
        //private void Nothing() { }

        public decimal Gez(string kundenname,DateTime begin, DateTime end)
        {
            var res = Enumerable.Range(0, termine.Count)
                .Where(x => termine[x].Kunde.Name.Equals(kundenname))
                .ToList();

            decimal erg = 0;
            foreach(int i in res)
            {
                if(termine[i].Overlaps(begin,end)) erg+= termine[i].Beza();
               
            }
            return erg;
        }
        public decimal Bez(string arbeitername, DateTime begin, DateTime end)
        {
            var res = Enumerable.Range(0, termine.Count)
                .Where(x => termine[x].Mitarbeiter.Name.Equals(arbeitername))
                .ToList();

            decimal erg = 0;
            foreach (int i in res)
            {
                if (termine[i].Overlaps(begin, end)) erg += termine[i].DauerInH() * termine[i].Mitarbeiter.StundenLohn;

            }
            return erg;
        }

        public decimal GesUms()
        {
            decimal erg = 0;
            foreach(Termin t in termine)
            {
                erg += t.Beza();
            }
            return erg;
        }

        public decimal Gewinn()
        {
            decimal ums = GesUms();
            decimal pay = 0;
            foreach(Termin t in termine)
            {
               pay+= t.DauerInH() * t.Mitarbeiter.StundenLohn;
            }
            return ums - pay;
        }
    }
}

