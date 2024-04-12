using System;
using System.Collections.Generic;

namespace DB.Model;

public partial class Pruefungen
{
    public DateTime PDatum { get; set; }

    public int PSKandidat { get; set; }

    public string PLPruefer { get; set; } = null!;

    public string PGFach { get; set; } = null!;

    public string? PArt { get; set; }

    public int? PNote { get; set; }

    public virtual Gegenstaende PGFachNavigation { get; set; } = null!;

    public virtual Lehrer PLPrueferNavigation { get; set; } = null!;

    public virtual Schueler PSKandidatNavigation { get; set; } = null!;
}
