// See https://aka.ms/new-console-template for more information
using ConsoleApp;
using Microsoft.EntityFrameworkCore;
using System.Text.RegularExpressions;

Console.WriteLine("Hello, World!");


using (var db = new Schule2023Context())
{
    // For LLChefNavigation!.LName see
    // https://learn.microsoft.com/en-us/ef/core/miscellaneous/nullable-reference-types#navigating-and-including-nullable-relationships

    var schueler = from p in db.Lehrers
                   select new { p.LName, p.LGebdat, Chef = p.LLChefNavigation!.LName ?? "?", p.Pruefungens.Count }
                   ;
    
    foreach (var s in schueler.ToList())
    {
        Console.WriteLine(s);
    }

    Console.WriteLine("--------------------------------");
    var erg1 = db.Stundens.Where(st => Regex.IsMatch(st.StRRaum, "^LA")).Count();
    Console.WriteLine(erg1);


    Console.WriteLine("--------------------------------");
    //nicht das schönset (select) aber ka wie man das auf eine eindimensionale liste runterbricht
    var erg2 = db.Klassens.Where(k => k.Stundens.Any(st => st.StRRaum == "B1")).Select(k => k.Schuelers);
    foreach (var item in erg2)
    {
        foreach (var s in item)
        {
            Console.WriteLine(s.SName);
        }
    }

    Console.WriteLine("--------------------------------");
    var erg3 = db.Vorgesetztes.Where(v=>v.VArt=="AV").GroupBy(v => v.VLVorg).Select(v => v.First().VLVorg);
    foreach (var v in erg3)
    {
        Console.WriteLine(v);
    }

    Console.WriteLine("--------------------------------");
    var erg4 = db.Lehrers.Where(l=>l.LLChef==null).Select(l=>l.LName);
    foreach (var l in erg4)
    {
        Console.WriteLine(l);
    }

    Console.WriteLine("--------------------------------");
    var erg5 = db.Pruefungens.GroupBy(p => p.PGFach).Select(p => new {note=  p.Average(n => n.PNote), fach=p.First().PGFach });
    foreach (var item in erg5)
    {
        Console.WriteLine($"fach: {item.fach} note: {item.note}");
    }

    Console.WriteLine("--------------------------------");
    var erg6 = db.Vorgesetztes.Select(v => new { vorg = v.VLVorg, unt = v.VLUnt });
    foreach (var item in erg6)
    {
        var erg6_1 = db.Stundens.Where(s => s.StLLehrer == item.vorg).GroupBy(s => s.StKKlasse).Select(s=>s.Key);
        var erg6_2 = db.Stundens.Where(s => s.StLLehrer == item.unt).GroupBy(s => s.StKKlasse).Select(s => s.Key);

        foreach(var klasse in erg6_1)
        {
            if (erg6_2.Contains(klasse))
            {
                Console.WriteLine($"klasse: {klasse} | vorgesetzter: {item.vorg} | untergebener: {item.unt}");
            }
        }
    }
    Console.WriteLine("--------------------------------");
    var erg7 = db.Klassens.Where(k => (k.KSKlasprNavigation.SKKlasse != k.KBez)&&k.KSKlaspr!=null).Select(k => k.KSKlasprNavigation.SSchnr);
    foreach (var item in erg7) {

        Console.WriteLine(item);
    }

    Console.WriteLine("--------------------------------");
    var erg8 = db.Klassens.Where(k => k.KLKlavstNavigation.Stundens.Any(s => s.StGFach == "PR")).Select(k => k.KLKlavstNavigation.LName);
    foreach (var item in erg8)
    {

        Console.WriteLine(item);
    }

    Console.WriteLine("--------------------------------");
    var erg9 = db.Schuelers.Where(s => !(db.Pruefungens.Select(p => p.PSKandidat).Contains(s.SSchnr))).Select(s => s.SName);
    foreach (var item in erg9)
    {

        Console.WriteLine(item);
    }


    Console.WriteLine("--------------------------------");
    var erg10 = db.Schuelers.OrderBy(s=>s.SGebdat).Select(s=> s.SName).ToList();
    Console.WriteLine(erg10[2]);
}
