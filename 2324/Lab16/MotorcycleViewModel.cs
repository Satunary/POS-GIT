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

        private int _limitLoc;
        public int LimitLoc { get { return _limitLoc; } set { SetProperty(ref _limitLoc, value); } }

        private ObservableCollection<Motorcycle> motorcyclesIntern;

        private ObservableCollection<Motorcycle> _motorcycles;
        public ObservableCollection<Motorcycle> Motorcycles
        {
            get { return _motorcycles; }
            set
            {
                SetProperty(ref _motorcycles, value);
            }
        }
        private bool _BTNON;
        public bool BTNON { get { return _BTNON; } set { SetProperty(ref _BTNON, value); } }

        private string _loadBtnText;
        public string LoadBtnText { get { return _loadBtnText; }set { SetProperty(ref _loadBtnText, value); } }

        //private Motorcycle _selectedItem;
        //public Motorcycle SelectedItem { get { return _selectedItem; } set { SetProperty(ref _selectedItem,value); } }


        HttpClient httpClient = new()
        {
            BaseAddress = new Uri("https://api.api-ninjas.com/v1/motorcycles?make=KTM" + "")
        };

        public MotorcycleViewModel() { Motorcycles = new ObservableCollection<Motorcycle>();
            //Fetch("KTM");
            LimitLoc = 0;
            BTNON = true;
            LoadBtnText = "Load";
        }

        public IRelayCommand<string> Fetching => new RelayCommand<string>(Fetch);

        public IRelayCommand NextStep => new RelayCommand(Next);
        public IRelayCommand PrevStep => new RelayCommand(Prev);

        //public object Request { get => request; set => request = value;

        public async void Fetch(string make)
        {
            BTNON = false;
            try
            {
                
                httpClient.DefaultRequestHeaders.Add("X-Api-Key", "ieXotCDQwJeZ4vpH+SkGXw==L6kbEKfYEEAvcGUH");
                motorcyclesIntern = await httpClient.GetFromJsonAsync<ObservableCollection<Motorcycle>>($"https://api.api-ninjas.com/v1/motorcycles?make={make}");
                
                Next();
            }
            catch(Exception e) { LoadBtnText = "Invalid Make"; }
            BTNON = true;
        }

        public void Next()
        {
            Motorcycles.Clear();
            foreach (var item in motorcyclesIntern.Skip(LimitLoc * 10).Take(10))
            {
                Motorcycles.Add(item);
            }
            LimitLoc++;
        }

        public void Prev()
        {
            Motorcycles.Clear();
            foreach (var item in motorcyclesIntern.Skip((LimitLoc * 10)-10).Take(10))
            {
                Motorcycles.Add(item);
            }
            LimitLoc--;
        }

    }
}
