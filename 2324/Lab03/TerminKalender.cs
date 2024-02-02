using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics.Metrics;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Lab03
{
    public class TerminKalender:List<Termin>
    {
        public static void Main(string[] args)
        {
            TerminKalender termins = new TerminKalender();
            bool checker = true;
            while (checker)
            {
                Console.Clear();
                checker = Worker(termins);
            }
        }

        public static bool Worker(TerminKalender termins)
        {
            
            Console.WriteLine("enter 'Ausgeben' to see your meetings");
            Console.WriteLine("enter 'Einlesen' to enter a new meeting");
            Console.WriteLine("enter 'Laden' to input your from a file meetings");
            Console.WriteLine("enter 'Speichern' to save your meetings to a file");
            Console.WriteLine("enter 'Exit' to end the programm. Please not that your changes will not be automaticly saved");
            Console.WriteLine("further instructions will be given once you enter a command");
            string inp = Console.ReadLine();

            switch (inp)
            {
                case "Ausgeben":
                    Console.WriteLine("if you whish to sort your meetings please enter 'Sort' and either 'DateTime' or 'Priority' to sort after the respectiv attributes");
                    Console.WriteLine("if you whish to limit the output input 'Limit' and a phrase that is contained in the topic of the meetings you whis to retrieve");
                    Console.WriteLine("you may use both limiters at the same time however please use them in the following order 'Sort DateTime/Priority Limit Topic' as it may not work as intendet otherwise");
                    inp = Console.ReadLine();
                                   
                    if (inp.Contains("Sort"))
                    {
                       
                        string tempp = inp.Replace("\\s+", "").Substring(4, 8);
                        if (tempp.Contains("DateTime")) termins.SortTermineDatum();
                        if (tempp.Contains("Priority")) termins.SortPrioritaet();
                    }
                    if (inp.Contains("Limit"))
                    {
                        string temp = "";
                        if (inp.Contains("Sort")) { temp = inp.Trim().Substring(4).Trim().Substring(8).Trim().Substring(5); }
                        else
                        {
                          temp = inp.Trim().Substring(5);
                        }
                        
                        foreach (Termin ter in termins)
                        {
                            if (ter.Thema.Contains(temp)) Console.WriteLine(ter.ToString() + "\n------------------------------------------------------------------------");
                        }
                    }
                    else
                    {
                        foreach (Termin ter in termins)
                        {
                            Console.WriteLine(ter.ToString() + "\n------------------------------------------------------------------------");
                        }
                    }
                    return true;
                   

                case "Einlesen":
                    Console.WriteLine("input a meeting with the format of: yyyy-mm-ddThh:mm:ss#Priority#Topic#PostalCode#City#Street");
                    termins.InpString(Console.ReadLine());
                    return true;

                case "Laden":
                    Console.WriteLine("please enter the filpath that you whish to load");
                    termins.Laden(Console.ReadLine());
                    return true;
                    
                case "Speichern":
                    Console.WriteLine("please enter the filpath that you whish to save to");
                    termins.Speichern(Console.ReadLine());
                    return true;

                case "Exit":
                    return false;
                default:
                    Console.WriteLine("Invalid command");
                    return true;
                   
            }
            return false;
        }
        
        public int GetAnzahlTeil(string s)
        {
            int x = 0;
            foreach(Termin ter in this)
            {
                if (ter.Thema.Contains(s)) x++;
            }
            return x;
        }

        public void SortTermineDatum()
        {
            this.Sort((emp1,emp2) =>emp1.DatumUndZeit.CompareTo(emp2.DatumUndZeit));

        }

        public void SortPrioritaet()
        {
            this.Sort();

        }

        public void Speichern(string filenPath)
        {
            
            try
            {
                FileStream file = new FileStream(filenPath, FileMode.OpenOrCreate);
                using (StreamWriter strWr = new StreamWriter(file, Encoding.UTF8))
                {
                    foreach (Termin termin in this)
                    {
                        strWr.WriteLine(termin.WriteData());
                    }
                }
            }catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            
        }

        public void Laden(string filenPath)
        {
            try { 
                string[] inp = File.ReadAllLines(filenPath);
                int counter = 0;
                foreach (string inpStr in inp)
                {
                    counter++;
                    try
                    {

                        string[] dec = inpStr.Split('#');
                        string[] dat = Regex.Split(dec[0], @"[-T:]");
                        int[] numb = new int[6];
                        for (int i = 0; i < 6; i++)
                        {
                            numb[i] = int.Parse(dat[i]);
                        }
                        DateTime dateTime = new DateTime(numb[0], numb[1], numb[2], numb[3], numb[4], numb[5]);
                        this.Add(new Termin(dateTime, int.Parse(dec[1]), dec[2], new Ort(int.Parse(dec[3]), dec[4], dec[5])));
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine("error in line " + counter + " please check if the input maches the required format of: yyyy-mm-ddThh:mm:ss#Prioritaet#Thema#Postleitzahl#Stadt#Strasse");

                    }
                }
            }catch (Exception ex) { Console.WriteLine(ex.Message); }
            
            
        }

        public void InpString(string inpStr)
        {
            try
            {
                string[] dec = inpStr.Split('#');
                string[] dat = Regex.Split(dec[0], @"[-T:]");
                int[] numb = new int[6];
                for (int i = 0; i < 6; i++)
                {
                    numb[i] = int.Parse(dat[i]);
                }
                new DateTime(5, 5, 5, 5, 5, 5);
                DateTime dateTime = new DateTime(numb[0], numb[1], numb[2], numb[3], numb[4], numb[5]);
                this.Add(new Termin(dateTime, int.Parse(dec[1]), dec[2], new Ort(int.Parse(dec[3]), dec[4], dec[5])));
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                Console.WriteLine("error please check if the input maches the required format of: yyyy-mm-ddThh:mm:ss#Prioritaet#Thema#Postleitzahl#Stadt#Strasse");

            }
        }
    }
}
