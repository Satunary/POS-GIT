using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Augsten.Figs
{
    public class RechteckB:FigurB
    {
        private int _a;
        public int A { get { return _a; } init { if (value > 0) _a = value; } }

        private int _b;
        public int B { get { return _b; } init { if (value > 0) _b = value; } }
        public RechteckB(int a, int b)
        {
            A= a;
            B= b;
        }

        public double Umfang()
        {
            return (A+B)*2;
        }

        public override string ToString()
        {
            return $"A: {A}; B: {B}; Umfang: {Umfang()}";
        }
    }
}
