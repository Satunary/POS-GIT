using System;
using System.Collections.Generic;

namespace DB.Model;

public partial class Stunden
{
    public string StKKlasse { get; set; } = null!;

    public string? StLLehrer { get; set; }

    public string? StGFach { get; set; }

    public string StStunde { get; set; } = null!;

    public string? StRRaum { get; set; }

    public virtual Gegenstaende? StGFachNavigation { get; set; }

    public virtual Klassen StKKlasseNavigation { get; set; } = null!;

    public virtual Lehrer? StLLehrerNavigation { get; set; }

    public virtual Raeume? StRRaumNavigation { get; set; }
}
