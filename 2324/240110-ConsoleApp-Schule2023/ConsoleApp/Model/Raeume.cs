using System;
using System.Collections.Generic;

namespace ConsoleApp.Model;

public partial class Raeume
{
    public string RId { get; set; } = null!;

    public short? RPlaetze { get; set; }

    public virtual ICollection<Stunden> Stundens { get; set; } = new List<Stunden>();
}
