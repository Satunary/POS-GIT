
using DB;
using Microsoft.EntityFrameworkCore;

var option = new DbContextOptionsBuilder<Schule2000Context>()
    .UseSqlite("Data Source=Schule2000.db")
    //.LogTo(Console.WriteLine, Microsoft.Extensions.Logging.LogLevel.Information)
    .Options
    ;

using (var db = new Schule2000Context(option))
{
    var erg1 = db.Pruefungens.Count();
    var erg2 = db.Pruefungens.Average(p => p.PNote);
    Console.WriteLine($"Anzahl: {erg1}, Average: {erg2}");

    

    var erg3 = db.Pruefungens.GroupBy(p => p.PLPruefer).Where(p => p.Average(e=>e.PNote) < 2.61).Select(p => new
    {
        Name = p.First().PLPrueferNavigation.LName,
        Anzahl = p.Count(),
        Average = p.Average(a => a.PNote)

    });

    foreach (var p in erg3)
    {
        Console.WriteLine($"Lehrer: {p.Name}, Anzahl: {p.Anzahl}, Average: {p.Average}");
    }

    var erg4 = db.Lehrers.Where(l => l.LGebdat != null && l.LGebdat.Value.Year > 1940).Select(l => new
    {
        Name = l.LName,
        Gebdat = l.LGebdat!.Value
    });

    foreach (var l in erg4)
    {
      Console.WriteLine($"Lehrer: {l.Name}, Gebdat: {l.Gebdat}");
    }

}
