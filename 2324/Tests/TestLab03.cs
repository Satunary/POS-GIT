using Lab03;
namespace Tests
{
    public class TestLab03
    {
        [Fact]
        public void TestOrtWriteDataAndToString()
        {
            Ort ort = new Ort(2325, "Himberg", "AAAAA");

            Assert.Equal("2325#Himberg#AAAAA",ort.WriteData());
            Assert.Equal("Postal Code: 2325 City: Himberg Street: AAAAA",ort.ToString());
        }
        [Fact]
        public void TestOrtEquals()
        {
            Ort ort = new Ort(2325, "Himberg", "AAAAA");

            Assert.True(ort.Equals(ort));
        }
        
    }
}