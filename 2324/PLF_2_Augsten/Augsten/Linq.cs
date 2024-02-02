using LinqInAction.LinqBooks.Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.WebSockets;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Augsten
{
    public class Linq
    {
        public void SummeUmsatz()
        {
            var data = SampleData.Books.Where(b => b.Authors.All(a => a.Birthdate.Year > 1980)).Sum(b => (b.Price * b.Sold));
            ObjectDumper.Write(data);
        }

        public void ListBooks()
        {
            var data = SampleData.Reviews.GroupBy(r => r.Book).OrderByDescending(d => d.Average(r=>r.Rating)).Select(r => new { name = r.Key.Title, raiting = r.Average(r=> r.Rating)});
            
            ObjectDumper.Write(data);
        }

        public void Subjects()
        {
            var data = SampleData.Books.GroupBy(b => b.Subject).Select(b => new
            {
                subject = b.Key.Name,
                umsatz = b.Sum(r => r.Price * r.Sold)
            });
            ObjectDumper.Write(data);
        }

        public void XMLSimson()
        {
            var data = SampleData.Books.Where(b => b.Authors.First().LastName == "Simson").Select(b => new XElement("Book",
                new XAttribute("Title",b.Title),
                b.Authors.Select(a=>new XElement("Author",a.LastName))
                ));
            var root = new XElement("SimsonFirst", data);
            Console.WriteLine(root);
        }

        public void MaedchenLoad()
        {
            var root = XElement.Load("schueler.xml");
            var data = root.Descendants("Schueler").Where(m => m.Attribute("Ges").Value == "w").Select(m => new
            {
                name = m.Attribute("Name").Value,
                klasse = m.Parent.Attribute("Klasse").Value
            });

            ObjectDumper.Write(data);
        }

    }
}
