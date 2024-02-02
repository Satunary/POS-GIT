using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Augsten.Figs
{
    public class FigurenB
    {
        public List<FigurB> figuren;

        public FigurenB()
        {
            figuren = new List<FigurB>();
        }

        public void AddFigur(FigurB fig)
        {
            if (fig != null)
            {
                figuren.Add(fig);
            }
            else { throw new Exception(); }
        }

        public IEnumerable<FigurB> GroesserAls(double d)
        {
            return figuren.Where(f => f.Umfang() >= d);
        }

       public double MinUmf()
        {
            return figuren.Min(f=> f.Umfang());
        }

    }
}
