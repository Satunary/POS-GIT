using Augsten;
using LinqInAction.LinqBooks.Common;
using System;
using System.Diagnostics;
using System.Xml.Linq;

namespace ConsoleApp
{
    class Program
    {
        
        static void Main(string[] args)
        {
            Linq l = new Linq();
            Console.WriteLine("------------SampleData--------------------");
            l.SummeUmsatz();
            Console.WriteLine("------------SampleData2--------------------");
            l.ListBooks();
            Console.WriteLine("------------SampleData3--------------------");
            l.Subjects();

            Console.WriteLine("------------SampleData XML--------------------");
            l.XMLSimson();
            Console.WriteLine("------------ XML load--------------------");
            l.MaedchenLoad();

            Console.WriteLine("Happy coding!");
        }

        
    }
}
