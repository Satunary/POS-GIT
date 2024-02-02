using System;
using System.Collections.Generic;
using System.Text;

namespace LinqInAction.LinqBooks.Common
{
    static public class SampleData
    {
        static public Publisher[] Publishers =
        {
          new Publisher {Name="FunBooks"},
          new Publisher {Name="Joe Publishing"},
          new Publisher {Name="I Publisher"}
        };

        static public Author[] Authors =
        {
          new Author {FirstName="Johnny", LastName="Good", Birthdate=new DateTime(1960, 1, 2), WebSite = "https://www.oreilly.com/"},
          new Author {FirstName="Graziella", LastName="Simson", Birthdate=new DateTime(1961, 2, 3), WebSite = "https://www.oreilly.com/"},
          new Author {FirstName="Octavio", LastName="Prince", Birthdate=new DateTime(1956, 3, 4)},
          new Author {FirstName="Jeremy", LastName="Legrand", Birthdate=new DateTime(1993, 4, 5), WebSite = "https://www.oreilly.com/"}
        };

        static public Subject[] Subjects =
        {
          new Subject {Name="Software development",Description="developing and others"},
          new Subject {Name="Novel",Description="great feelings"},
          new Subject {Name="Science fiction",Description="out of space and everywhere"}
        };

        static public Book[] Books =
        {
          new Book {                                        // [0]
            Title="Funny Stories",
            Publisher=Publishers[0],
            Authors=new[]{Authors[0], Authors[1]},
            PageCount=101,
            Sold = 100000,
            Price=25.55M,
            PublicationDate=new DateTime(2004, 11, 10),
            Isbn="0-000-77777-2",
            Subject=Subjects[0]
          },
          new Book {                                        // [1]
            Title="LINQ rules",
            Publisher=Publishers[1],
            Authors=new[]{ Authors[1], Authors[2]},
            PageCount=300,
            Sold = 10000,
            Price=12M,
            PublicationDate=new DateTime(2007, 9, 2),
            Isbn="0-111-77777-2",
            Subject=Subjects[0]
          },
          new Book {                                        // [2]
            Title="C# on Rails",
            Publisher=Publishers[1],
            Authors=new[]{Authors[2]},
            PageCount=256,
            Sold = 1000,
            Price=35.5M,
            PublicationDate=new DateTime(2007, 4, 1),
            Isbn="0-222-77777-2",
            Subject=Subjects[0]
          },
          new Book {                                        // [3]
            Title="All your base are belong to us",
            Publisher=Publishers[1],
            Authors=new[]{Authors[3]},
            PageCount=1205,
            Sold = 100000,
            Price=35.5M,
            PublicationDate=new DateTime(2006, 5, 5),
            Isbn="0-333-77777-2",
            Subject=Subjects[2]
          },
          new Book {                                        // [4]
            Title="Bonjour mon Amour",
            Publisher=Publishers[0],
            Authors=new[]{Authors[1], Authors[2]},
            PageCount=50,
            Sold = 1000000,
            Price=29M,
            PublicationDate=new DateTime(1973, 2, 18),
            Isbn="2-444-77777-2",
            Subject=Subjects[1]
          }
        };

        static public User[] Users =
        {
            new User{Name="Fred"},
            new User{Name="Barney"},
            new User{Name="Wilma"}
        };

        static public Review[] Reviews =
        {
            new Review{ Book = Books[0], Comments="cc1", Rating=2, User=Users[0]},
            new Review{ Book = Books[0], Comments="cc2", Rating=3, User=Users[2]},
            new Review{ Book = Books[1], Comments="cc3", Rating=1, User=Users[0]},
            new Review{ Book = Books[1], Comments="cc4", Rating=2, User=Users[1]},
            new Review{ Book = Books[1], Comments="cc5", Rating=1, User=Users[2]},
            new Review{ Book = Books[2], Comments="cc6", Rating=3, User=Users[2]},
            new Review{ Book = Books[3], Comments="cc7", Rating=4, User=Users[2]},
            new Review{ Book = Books[4], Comments="cc8", Rating=5, User=Users[1]}
        };

        static SampleData()
        {
            // Books -- Reviews haben einnen Doppelverweise
            //          daher kann erst hier  Book-->Review gesetzt werden
            Books[0].Reviews = new[] { Reviews[0], Reviews[1] };
            Books[1].Reviews = new[] { Reviews[2], Reviews[3], Reviews[4] };
            Books[2].Reviews = new[] { Reviews[5] };
            Books[3].Reviews = new[] { Reviews[6] };
            Books[4].Reviews = new[] { Reviews[7] };

            Authors[0].Books = new[] { Books[0] };
            Authors[1].Books = new[] { Books[0], Books[4] };
            Authors[2].Books = new[] { Books[1], Books[2], Books[4] };
            Authors[3].Books = new[] { Books[3] };
        }

    }
}