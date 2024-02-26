using System.Data.SqlTypes;
using System.Xml;
using System.Xml.Linq;

namespace Lab14
{
    public partial class MainPage : ContentPage
    {
        private bool tryme = false;
        XmlTextReader reader = new XmlTextReader("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        Dictionary<string,double> prices = new Dictionary<string,double>();

        public MainPage()
        {
            InitializeComponent();
            init();
        }

        public void init()
        {
            while(reader.Read())
            {
                switch(reader.NodeType)
                {
                    case XmlNodeType.Element:
                        if (reader.Name == "Cube" && reader.GetAttribute("currency") != null && reader.GetAttribute("rate") != null)
                        {
                            prices.Add(reader.GetAttribute("currency"), double.Parse(reader.GetAttribute("rate").Replace(".",",")));
                        }
                        break;
                }
            }

            foreach (var item in prices)
            {
                pickme.Items.Add(item.Key);   
            }
        }

        private void pickme_SelectedIndexChanged(object sender, EventArgs e)
        {
            btnAnd.Text = pickme.SelectedItem.ToString()+" => Euro";
            btnEur.Text = "Euro => "+pickme.SelectedItem.ToString();
           sum.Text="Summe in "+ pickme.SelectedItem.ToString();
            
        }

        private void valEur_TextChanged(object sender, TextChangedEventArgs e)
        {
            
            if (valEur.Text != null && pickme.SelectedItem != null)
            {
                valAnd.Text = (double.Parse(valEur.Text) * prices[pickme.SelectedItem.ToString()]).ToString();
               
            }
        }

        private void valAnd_TextChanged(object sender, TextChangedEventArgs e)
        {
            
            if ( valAnd.Text != null&& double.TryParse(valAnd.Text,out double a) && pickme.SelectedItem != null)
            {
                valEur.Text = (double.Parse(valAnd.Text) / prices[pickme.SelectedItem.ToString()]).ToString();
                
            }
        }
    }

}
