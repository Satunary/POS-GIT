using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace spg.Lab6.Model
{
    public abstract class Kunde : IEquatable<Kunde>
    {
        public string Adresse { set; get; }
        public string Email { set; get; }
        public string Name { set; get; }
        public string Telefonnummer { get; init; }  // key
        public Kunde(string adresse, string email, string name, string telefonnummer)
        {
            Adresse = adresse;
            Email = email;
            Name = name;
            Telefonnummer = telefonnummer;
        }
        public abstract decimal Kosten(Dienstleistung d);
        public void Print()
        {
            Console.WriteLine(ToString());
        }
        public override string ToString()
        {
            return $"Name: {Name} \nAdresse: {Adresse} \nEmail: {Email} \nTelefonnummer: {Telefonnummer}";
        }
        public override bool Equals(object? obj)
        {
            return this.Equals(obj as Kunde);
        }
        public bool Equals(Kunde? other)
        {
            return (other == null) ? false : Telefonnummer == other.Telefonnummer;
        }
        public override int GetHashCode()
        {
            return HashCode.Combine(Adresse, Email, Name, Telefonnummer);
        }
    }
}
