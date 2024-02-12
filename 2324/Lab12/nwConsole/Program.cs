// See https://aka.ms/new-console-template for more information
using nwConsole.Model;

Console.WriteLine("Hello, World!");
using (var db = new Northwind4SqliteContext())
{
     var erg1 = db.Employees.Where(e => e.Title == "Vice President, Sales").Select(e=>e.FirstName);
     foreach (var item in erg1)
     {
         Console.WriteLine(item);
     }
    

 
}