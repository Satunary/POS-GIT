using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Pruefungen
{
    public DateTime PDatum { get; set; }

    public int PSKandidat { get; set; }
    public virtual Schueler PSKandidatNavigation { get; set; } = null!;

    public string PLPruefer { get; set; } = null!;
    public virtual Lehrer PLPrueferNavigation { get; set; } = null!;

    public string PGFach { get; set; } = null!;
    public virtual Gegenstaende PGFachNavigation { get; set; } = null!;

    public string? PArt { get; set; }

    public int? PNote { get; set; }



}
