using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Gegenstaende
{
    public string GId { get; set; } = null!;

    public string? GBez { get; set; }

    public virtual ICollection<Pruefungen> Pruefungens { get; set; } = new List<Pruefungen>();

    public virtual ICollection<Stunden> Stundens { get; set; } = new List<Stunden>();
}
