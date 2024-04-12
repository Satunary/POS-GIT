using System;
using System.Collections.Generic;

namespace DB.Model;

public partial class Klassen
{
    public string KId { get; set; } = null!;

    public string? KBez { get; set; }

    public int? KSKlaspr { get; set; }

    public int? KSKlasprstv { get; set; }

    public string? KLKlavst { get; set; }

    public virtual ICollection<Schueler> Schuelers { get; set; } = new List<Schueler>();

    public virtual ICollection<Stunden> Stundens { get; set; } = new List<Stunden>();
}
