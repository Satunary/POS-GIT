using System.Xml;
using System.Xml.Linq;
XElement x = XElement.Load(@"../../../Moore.xml");
XElement y = XElement.Load(@"../../../kundenbestellungen.xml");


Console.WriteLine("-----------------------A1----------------------------");
var outp1 = x.Descendants("Movie").Where(x => Int32.Parse(x.Element("Year").Value) > 1995).Select(d=>d.Element("Title").Value);

foreach (var item in outp1)
{
    Console.WriteLine(item);
}


Console.WriteLine("-----------------------A2----------------------------");
var outp2 = x.Descendants("Actor").Select(d => new
{
    name = ""+d.Element("Name").Element("FirstName").Value+" " + d.Element("Name").Element("LastName").Value,
    anzahl = d.Element("Filmography").Elements("Movie").Count()
});

foreach (var item in outp2)
{
    Console.WriteLine($"Name: {item.name}");
    Console.WriteLine($"Anzahl: {item.anzahl}");
}



Console.WriteLine("-----------------------A3----------------------------");
var outp3 = y.Descendants("Kunden").OrderBy(o=>o.Attribute("Land")?.Value).Select(d => new
{
    name = d.Attribute("Firma")?.Value,
    land = d.Attribute("Land")?.Value
});

foreach (var item in outp3)
{
    Console.WriteLine($"Land: {item.land}  Firma: {item.name}");
}


Console.WriteLine("-----------------------A4----------------------------");
var outp4 = y.Descendants("Kunden").Select(d => new 
{
    name = d.Attribute("Firma")?.Value,
    Kosten = d.Descendants("Bestellungen").Sum(b=>Double.Parse(b.Element("Frachtkosten").Value))
});


foreach (var item in outp4)
{
    Console.WriteLine($"Firma: {item.name}  Frachtkosten: {item.Kosten}");
}


Console.WriteLine("-----------------------A5----------------------------");
var outp5 = y.Descendants("Kunden").GroupBy(d => d.Element("Personal_Nr").Value).Select(g => new
{
    nr = g.Key,
    anz = g.Descendants("Bestellungen").Count()
}) ;

foreach (var item in outp5)
{
    Console.WriteLine($"NR: {item.nr}   Anzahl: {item.anz}");
}

//-------------------A6-------------

x.Descendants("Movie").Where(d => d.Element("Title")?.Value == "Live and Let Die").First().SetElementValue("Year", "1972");
x.Save(@"../../../Moore.xml");