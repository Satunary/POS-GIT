using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab02
{
    public abstract class Mitarbeiter
    {
        private string _name;
        public string Name
        {
            get
            {
                return _name;
            }
            set
            {
                if (value != null)
                {
                    _name = value;
                }
                else { Console.Write("invalid Name"); }
            }
        }

       private string _sozVersNum;
       public string SozVersNum {
            get
            {
                return _sozVersNum;
            } set
            {
                if(value.Length == 10)
                {
                    _sozVersNum = value;
                }
                else { Console.Write("invalid SozVersNum"); }
            } 
        }

        public Mitarbeiter(string name, string sozVersNum)
        {
            Name=name;
            SozVersNum=sozVersNum;  
        }

        public abstract decimal BerechneGehalt();

        public override string ToString()
        {
            return "Name: " + Name + "\nSozVersNum: " + SozVersNum + "\nGehalt: " + BerechneGehalt();
        }

        public void PrintInfo()
        {
            Console.WriteLine(ToString());
        }

        public override bool Equals(object? obj)
        {
            if (obj == null) { return false; } 
            else
            {
                Mitarbeiter m = (Mitarbeiter) obj;
                if (m.SozVersNum == this.SozVersNum)
                {
                    return true;
                }
                else { return false; }
            };
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
