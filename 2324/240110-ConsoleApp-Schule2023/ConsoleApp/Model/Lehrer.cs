using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Lehrer
{
    public string LId { get; set; } = null!;

    public string? LName { get; set; }

    public string? LVorname { get; set; }

    public DateTime? LGebdat { get; set; }

    public int? LGehalt { get; set; }

    public string? LLChef { get; set; }
    public virtual Lehrer? LLChefNavigation { get; set; }

    public virtual ICollection<Lehrer> InverseLLChefNavigation { get; set; } = new List<Lehrer>();

    public virtual ICollection<Pruefungen> Pruefungens { get; set; } = new List<Pruefungen>();
    public virtual ICollection<Stunden> Stundens { get; set; } = new List<Stunden>();
    public virtual ICollection<Klassen> Klassens { get; set; } = new List<Klassen>();

    public virtual ICollection<Vorgesetzte> VorgesetzteVLUntNavigations { get; set; } = new List<Vorgesetzte>();
    public virtual ICollection<Vorgesetzte> VorgesetzteVLVorgNavigations { get; set; } = new List<Vorgesetzte>();
}
