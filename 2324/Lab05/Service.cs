using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab05
{
    public class Service
    {
        public string Bez {  get; init; }
        public decimal PreisInEur {  get; init; }
        public decimal DauerInH {  get; init; }

        public Service(string bez, decimal preisInEur, decimal dauerInH)
        {
            Bez = bez;
            PreisInEur = preisInEur;
            DauerInH = dauerInH;
        }
    }
}
