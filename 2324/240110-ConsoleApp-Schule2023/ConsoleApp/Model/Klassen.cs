using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Klassen
{
    public string KId { get; set; } = null!;

    public string? KBez { get; set; }

    public int? KSKlaspr { get; set; }

    public int? KSKlasprstv { get; set; }

    public string? KLKlavst { get; set; }

    public virtual Lehrer? KLKlavstNavigation { get; set; }
    public virtual Schueler? KSKlasprNavigation { get; set; }
    public virtual Schueler? KSKlasprstvNavigation { get; set; }

    public virtual ICollection<Schueler> Schuelers { get; set; } = new List<Schueler>();

    public virtual ICollection<Stunden> Stundens { get; set; } = new List<Stunden>();
}
