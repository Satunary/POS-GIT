using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab05
{
    public class Person
    {
        public enum typ
        {
            Kunde,
            Stammkunde,
            Mitarbeiter
        }
        public enum erinnerung
        {
            Nie,
            Monatlich,
            Jaehrlich,
            blank
        }

        public string Adresse {  get; init; }
        public string Name { get; init; }
        public string Email { get; init; }
        public string Telefonnummer {  get; init; }
        public decimal Rabatt {  get; init; }
        public string Zusatz {  get; init; }

        public typ Typus { get; init; }

        public erinnerung Erinerung { get; init; }

        public decimal StundenLohn {  get; init; }
        
        

        public Person(string adresse, string name, string email, string telefonnummer, typ art, erinnerung er, decimal stundenlohn,decimal rabatt,string zusatz) 
        {
            Adresse = adresse;
            Name = name;
            Email = email;
            Telefonnummer = telefonnummer;
            Typus = art;
            if(Typus==typ.Kunde) Erinerung = er;
            if (Typus==typ.Mitarbeiter) StundenLohn = stundenlohn;
            if (Typus == typ.Stammkunde) Rabatt = rabatt; Zusatz = zusatz;
        }

    }
}
