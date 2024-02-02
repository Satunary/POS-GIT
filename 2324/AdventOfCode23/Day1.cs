using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace AdventOfCode23
{
    public class Day1
    {
        public void Run()
        {
            string[] inp = File.ReadAllLines("../../../input1.txt");
            List<int> list = new List<int>();
            foreach (string item in inp)
            {
                char[] split = item.ToCharArray();
                var temp = split.Where(s => Regex.IsMatch(s.ToString(), @"[0-9]")).Select(c => c.ToString());
                if(temp.Count() > 1 )
                {
                    list.Add(Int32.Parse(temp.First() + temp.Last()));
                }
                if(temp.Count() ==1 ) 
                {
                    list.Add(Int32.Parse(temp.First() + temp.First()));
                }
            }
            Console.WriteLine(list.Sum());
        }
    }
}
