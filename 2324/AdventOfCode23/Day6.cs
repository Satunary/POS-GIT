using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace AdventOfCode23
{
    public class Day6
    {
        public void Run()
        {
            string[] inp = File.ReadAllLines("../../../input6.txt");
            string werte = "";
            bool vals = false;
            string keys = "";
            foreach (string input in inp) 
            {
                string[] tem = input.Split(' ');
                if (!vals)
                {
                    foreach (var item in tem)
                    {
                        if(Int32.TryParse(item,out int it))
                        {
                            keys += item;
                        }
                        
                    }
                    vals = true;
                }
                else
                {
                    int i = 0;
                    foreach (var item in tem)
                    {
                        if (Int32.TryParse(item, out int it))
                        {
                            werte += item;
                        }

                    }
                }
            }
            long key = long.Parse(keys);
            long wert = long.Parse(werte);

            int y = 1;
            long ergfin = 1;
            int erg = 0;
            
               while(y < key)
                {
                    if ((y * (key - y)) > wert)
                    {
                        erg++;
                    }
                    y++;
                }
            Console.WriteLine(erg);
        }
    }
}
