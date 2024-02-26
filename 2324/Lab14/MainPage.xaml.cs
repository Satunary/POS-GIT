using System.Data.SqlTypes;
using System.Xml;
using System.Xml.Linq;

namespace Lab14
{
    public partial class MainPage : ContentPage
    {
        
        XmlTextReader reader = new XmlTextReader("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
        Dictionary<string,int> prices = new Dictionary<string,int>();

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
                    case XmlNodeType.Attribute:
                        //
                        //reader.Value;
                        break;
                }
            }
        }
       
    }

}
