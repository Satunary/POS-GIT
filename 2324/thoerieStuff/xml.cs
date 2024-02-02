using System.Xml.Linq;

internal class book
{
    string Titel { get; set;}
    int Seiten { get; set;}
    string ISBN { get; set;}

    public book(string titel, int seiten, string isbn)
    {
        Titel= titel;
        Seiten= seiten;
        ISBN= isbn;
    }
}

public class Tem
{
    
    static void Main(string[] args)
    {
        XElement book = XElement.Load("Container.xml");

        var erBooks = from b in book.Descendants("Buch")
                      select new book(
                          titel: b!.Attribute("Titel")!.Value,
                          seiten: Int32.Parse(b!.Attribute("Seiten")!.Value),
                          isbn: b!.Attribute("Isbn")!.Value
                          );
    }
}
