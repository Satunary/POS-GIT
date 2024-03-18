using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http.Json;
using System.ComponentModel;
using System.Collections.ObjectModel;

namespace Lab16
{
    public class MotorcycleModel : ObservableCollection<MotorcycleList>
    {
        public MotorcycleList MotorcycleList { get; set; }
       
    }
}
