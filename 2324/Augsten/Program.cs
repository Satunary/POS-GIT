
using Augsten;

TransportVerwaltung tra = new TransportVerwaltung();
Bus b0 = new Bus(Bus.Typ.Kleinbus, 30, 40, new DateOnly(2007, 5, 3));
tra.Einfuegen(new Flugzeug("aaaa", 50, 50, new DateOnly(2020, 12, 31)));
tra.Einfuegen(new Bus(Bus.Typ.Normal, 20, 20, new DateOnly(2000, 1, 1)));
tra.Einfuegen(b0);

tra.SortierteAnzeige();

tra.Loeschen(2005);

Console.WriteLine("------------------------------");
tra.SortNachZulassung();
Console.WriteLine("-------------------------------------");
Console.WriteLine(tra.Reisekosten());

try
{
    tra.Einfuegen(b0);
}
catch (Exception)
{
    Console.WriteLine("catch");
}

Console.WriteLine();
Console.WriteLine("Aufgrund meines unwissens wie ich Console.Writeline im test zum funjktionieren bekomme hier der TestSortieren nocheinmal");

TransportVerwaltung tra2 = new TransportVerwaltung();
tra2.Einfuegen(new Bus(Bus.Typ.Normal, 50, 30, new DateOnly(2000, 10, 10)));
tra2.Einfuegen(new Flugzeug("A", 80, 10, new DateOnly(2005, 10, 10)));

Console.WriteLine("Expected: Flugzeug first Bus second");
tra2.SortNachZulassung();
Console.WriteLine("--------------------------------------------------------");
Console.WriteLine("Expected: Bus first Flugzeug second");
tra2.SortierteAnzeige();


