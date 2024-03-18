using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
using System.Threading.Tasks;
using CommunityToolkit.Mvvm.ComponentModel;

using CommunityToolkit.Mvvm.Input;


namespace Lab16
{
    public class MotorcycleViewModel : ObservableObject
    {
        MotorcycleModel models;
        HttpClient httpClient = new()
        {
            BaseAddress = new Uri("https://api.api-ninjas.com/v1/motorcycles?make=KTM" + "X-Api-Key=ieXotCDQwJeZ4vpH+SkGXw==L6kbEKfYEEAvcGUH")

        };

        public IRelayCommand Fetching => new RelayCommand<Object>((param,parma) => this.Fetch(param,parma));

        public async void Fetch(string mark, string model)
        {
            models.MotorcycleList = await httpClient.GetFromJsonAsync<MotorcycleList>("https://api.api-ninjas.com/v1/motorcycles?make=KTM" + "X-Api-Key=ieXotCDQwJeZ4vpH+SkGXw==L6kbEKfYEEAvcGUH");
        }
    }
}
