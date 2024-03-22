using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Net;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text;
using System.Threading.Tasks;
using CommunityToolkit.Mvvm.ComponentModel;

using CommunityToolkit.Mvvm.Input;


namespace Lab16
{

    public class MotorcycleViewModel : ObservableObject

    {
        //select noch einbauen liste:
        /*ktm
        honda
        kawasaki
        yamaha
        aprilia
        malaguti
        vins
        ajp
        access
        beta*/

        private ObservableCollection<Motorcycle> _motorcycles;
        public ObservableCollection<Motorcycle> Motorcycles
        {
            get { return _motorcycles; }
            set
            {
                SetProperty(ref _motorcycles, value);
            }
        }
        HttpClient httpClient = new()
        {
            BaseAddress = new Uri("https://api.api-ninjas.com/v1/motorcycles?make=KTM" + "")
        };

        public MotorcycleViewModel() { Motorcycles = new ObservableCollection<Motorcycle>();
            //Fetch("KTM");
        }

        public IRelayCommand<string> Fetching => new RelayCommand<string>(Fetch);

        //public object Request { get => request; set => request = value;

        public async void Fetch(string make)
        {
            httpClient.DefaultRequestHeaders.Add("X-Api-Key", "ieXotCDQwJeZ4vpH+SkGXw==L6kbEKfYEEAvcGUH");
            Motorcycles = await httpClient.GetFromJsonAsync<ObservableCollection<Motorcycle>>($"https://api.api-ninjas.com/v1/motorcycles?make={make}");
        }
    }
}
