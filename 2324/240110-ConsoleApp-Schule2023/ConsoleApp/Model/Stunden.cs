using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Stunden
{
    public string StKKlasse { get; set; } = null!;
    public virtual Klassen StKKlasseNavigation { get; set; } = null!;

    public string? StLLehrer { get; set; }
    public virtual Lehrer? StLLehrerNavigation { get; set; }

    public string? StGFach { get; set; }
    public virtual Gegenstaende? StGFachNavigation { get; set; }

    public string StStunde { get; set; } = null!;

    public string? StRRaum { get; set; }
    public virtual Raeume? StRRaumNavigation { get; set; }




}
