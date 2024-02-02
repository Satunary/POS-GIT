using Lab02;
namespace Tests
{
    public class UTestLab03
    {
        [Fact]
        public void TestEinstellenEntlassen()
        {
            Firma f = new Firma("waltrud");
            Abteilungsleiter abt = new Abteilungsleiter(10, 2000, "Paul", "aaaaaaaaaa");

            f.eintstellen(abt);

            Assert.Equal(true, f.entlassen("aaaaaaaaaa"));
        }
        [Fact]
        public void TestprintMitarb()
        {
            // da mir der Console.write output aus mir unbekannten gründen nicht angezeigt wird werde ich den folgenden Code auch in Programm.cs von Lab03 implementiern
            Firma f = new Firma("WalterWhite");
            Teilzeitangestellter te = new Teilzeitangestellter(15, 500, "Dan", "bbbbbbbbbb");
            Abteilungsleiter abt = new Abteilungsleiter(50, 50, "DA", "ABABABABAB");
            f.eintstellen(te);
            f.eintstellen(abt);

            f.printMitarbeiter(400);
            f.printMitarbeiter(1600);
            f.printMitarbeiter(true);
        }
        [Fact]
        public void TestSuche()
        {
            Firma f = new Firma("WalterWhite");
            Teilzeitangestellter te = new Teilzeitangestellter(15, 500, "Dan", "bbbbbbbbbb");
            Abteilungsleiter abt = new Abteilungsleiter(50, 50, "DA", "ABABABABAB");
            f.eintstellen(te);
            f.eintstellen(abt);

            Assert.Equal(abt, f.sucheMitarbeiter("DA"));
        }

    }
}