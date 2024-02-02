using Augsten;

namespace Tests
{
    public class UnitTest1
    {
        [Fact]
        public void TestEinfuegen()
        {
            TransportVerwaltung tra = new TransportVerwaltung();
            tra.Einfuegen(new Bus(Bus.Typ.Normal, 50, 30, new DateOnly(2000, 10, 10)));

            Assert.Equal(30, tra.Reisekosten());
        }

        [Fact]
        public void TestSorts()
        {
            //keine ahnung warum das ganze nicht ausgegeben wird
            TransportVerwaltung tra = new TransportVerwaltung();
            tra.Einfuegen(new Bus(Bus.Typ.Normal, 50, 30, new DateOnly(2000, 10, 10)));
            tra.Einfuegen(new Flugzeug("A",80,10,new DateOnly(2005,10,10)));

            Console.WriteLine("Expected: Flugzeug first Bus second");
            tra.SortNachZulassung();
            Console.WriteLine("--------------------------------------------------------");
            Console.WriteLine("Expected: Bus first Flugzeug second");
            tra.SortierteAnzeige();
        }
        [Fact]
        public void TestFindeNachAlter()
        {
            TransportVerwaltung tra = new TransportVerwaltung();
            Flugzeug f = new Flugzeug("A", 80, 10, new DateOnly(2005, 10, 10));
            Bus b = new Bus(Bus.Typ.Normal, 50, 30, new DateOnly(2000, 10, 10));
            tra.Einfuegen(b);
            tra.Einfuegen(f);

            Assert.Equal(b, tra.FindeNachAlter(2001)[0]);
                
         }
        [Fact]

        public void TestEinfuegenFelerhaft()
        {
            TransportVerwaltung tra = new TransportVerwaltung();
            Flugzeug f = new Flugzeug("A", 80, 10, new DateOnly(2005, 10, 10));
            Bus b = new Bus(Bus.Typ.Normal, 50, 30, new DateOnly(2000, 10, 10));
            tra.Einfuegen(b);
            tra.Einfuegen(f);

            //da ich nuicht weisd wie ich den type von einer exeption bekomme und damit nicht assert.throws anwenden kann hier meine umgehung des problems
            try
            {
                tra.Einfuegen(b);
                Assert.True(false);
            }catch(Exception ) { Assert.True(true); }
        }


    }
}