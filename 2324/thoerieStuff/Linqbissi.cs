
var erg = from b in SampleData.Books
          where b.PublicationDate.CompareTo(new DateTime(2007, 8, 1)) < 0
          orderby b.Title
          select (b.Isbn, b.PublicationDate, b.Title);

var erg2 = from b in SampleData.Books
           where b.Publisher.Name == "FunBooks"
           select b;
