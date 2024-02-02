using Lab03;


Firma f = new Firma("WalterWhite");
Teilzeitangestellter te = new Teilzeitangestellter(15, 500, "Dan", "bbbbbbbbbb");
Abteilungsleiter abt = new Abteilungsleiter(50, 50, "DA", "ABABABABAB");
f.eintstellen(te);
f.eintstellen(abt);

f.printMitarbeiter(400);
Console.WriteLine("---------------");
f.printMitarbeiter(1600);
Console.WriteLine("---------------");
f.printMitarbeiter(true);
Console.WriteLine("---------------");
f.printMitarbeiter(false);
