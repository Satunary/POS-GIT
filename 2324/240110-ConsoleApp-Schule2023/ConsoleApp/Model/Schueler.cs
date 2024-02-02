using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Schueler
{
    public int SSchnr { get; set; }

    public string? SName { get; set; }

    public string? SVorname { get; set; }

    public DateTime? SGebdat { get; set; }

    public string? SAdresse { get; set; }

    public string? SKKlasse { get; set; }

    public virtual ICollection<Pruefungen> Pruefungens { get; set; } = new List<Pruefungen>();
    public virtual Klassen? SKKlasseNavigation { get; set; }

    public virtual ICollection<Klassen> KlassenKSKlasprNavigations { get; set; } = new List<Klassen>();
    public virtual ICollection<Klassen> KlassenKSKlasprstvNavigations { get; set; } = new List<Klassen>();
}
