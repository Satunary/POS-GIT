using System;
using System.Collections.Generic;

namespace DB.Model;

public partial class Raeume
{
    public string RId { get; set; } = null!;

    public int? RPlaetze { get; set; }

    public virtual ICollection<Stunden> Stundens { get; set; } = new List<Stunden>();
}
