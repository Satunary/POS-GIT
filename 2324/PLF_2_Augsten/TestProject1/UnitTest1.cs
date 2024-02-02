using Augsten;
using Augsten.Figs;

namespace TestProject1
{
    public class UnitTest1
    {
        [Fact]
        public void TestUmfang()
        {
            RechteckB re = new RechteckB(5, 5);

            Assert.Equal(20, re.Umfang());
        }

        [Fact]
        public void TestAdd()
        {
            FigurenB fign = new FigurenB();
            RechteckB re = new RechteckB(5, 5);

            fign.AddFigur(re);

            Assert.Equal(1,fign.figuren.Count());
        }
        [Fact]
        public void TestAddErr()
        {
            FigurenB fign = new FigurenB();
            try
            {
                fign.AddFigur(null);
                Assert.True(false);
            }catch(Exception ex)
            {
                Assert.True(true);
            }
        }

        [Fact]
        public void TestSummeUmf()
        {
            FigurenB fign = new FigurenB();
            RechteckB re = new RechteckB(5, 5);
            RechteckB re2 = new RechteckB(7, 7);
            fign.AddFigur(re);
            fign.AddFigur(re2);

            Assert.Equal(48, fign.figuren.SummeUmfang());
        }

        [Fact]
        public void TestMinUmf()
        {
            FigurenB fign = new FigurenB();
            RechteckB re = new RechteckB(5, 5);
            RechteckB re2 = new RechteckB(7, 7);
            fign.AddFigur(re);
            fign.AddFigur(re2);

            Assert.Equal(20, fign.MinUmf());
        }
    }
}