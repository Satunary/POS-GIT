using Augsten.Figs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Augsten
{
    static public class Extention
    {
        public static double SummeUmfang(this List<FigurB> figs)
        {
            return figs.Sum(f => f.Umfang());
        }
    }
}
