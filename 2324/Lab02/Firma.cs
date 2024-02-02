using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab02
{
    public class Firma
    {
        public string Name {  get; set; }
        private ArrayList mitarbeiter;

        public Firma(string name)
        {
            Name = name;
            mitarbeiter = new ArrayList();
        }

        public void eintstellen(Mitarbeiter m)
        {
            if(!mitarbeiter.Contains(m))
            {
                mitarbeiter.Add(m);
            }
            else
            {
                Console.WriteLine("mitarbeiter existiert bereits");
            }
        }

        public bool entlassen(string sozVersNum)
        {
            foreach(Mitarbeiter m in mitarbeiter)
            {
                if(m.SozVersNum == sozVersNum)
                {
                    mitarbeiter.Remove(m);
                    return true;
                }
            }
            return false;
        }

        public void printMitarbeiter(decimal gehalt)
        {
            foreach (Mitarbeiter m in mitarbeiter)
            {
                if (m.BerechneGehalt() >= gehalt)
                {
                    m.PrintInfo();
                }
            }
        }

        public void printMitarbeiter(bool nurAbtLeiter)
        {
            if (nurAbtLeiter)
            {
           
                foreach(Mitarbeiter m in mitarbeiter)
                {
                    if (m.GetType() == typeof(Abteilungsleiter))
                    {
                        m.PrintInfo();
                    }
                }
            }
            else
            {  
                printMitarbeiter(0);
            }
        }

        public Mitarbeiter sucheMitarbeiter(string name)
        {
            foreach (Mitarbeiter m in mitarbeiter)
            {
                if (m.Name == name)
                {
                   
                    return m;
                }
            }
            return null;
        }
    }
}
