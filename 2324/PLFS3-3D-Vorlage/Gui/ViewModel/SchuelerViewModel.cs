using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using PlfsMaui.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.ApplicationModel.Appointments.DataProvider;
using static System.Net.Mime.MediaTypeNames;

namespace Plfs3.ViewModel;

public class SchuelerViewModel : ObservableObject {

    private int _loc;
    public int Loc {get { return _loc;} set { SetProperty(ref _loc, value); } }

    private Schueler _current;
    public Schueler Current {  get { return _current; } set { SetProperty(ref _current, value); } }

    public ObservableCollection<Schueler> Schuelers;

    public SchuelerViewModel()
    {
        Schuelers = new ObservableCollection<Schueler>();
        Schuelers.Add(new Schueler() { Vorname = "Max", Nachname = "Augsten", Adresse = "Muster", Gebdat = new DateTime(), Klasse = "3DHIF", Schnr = 1 });
        Schuelers.Add(new Schueler() { Vorname = "Daniel", Nachname = "Walter", Adresse = "Muster", Gebdat = new DateTime(), Klasse = "3DHIF", Schnr = 2 });
        Schuelers.Add(new Schueler() { Vorname = "Viktor", Nachname = "Novak", Adresse = "Muster", Gebdat = new DateTime(), Klasse = "3DHIF", Schnr = 3 });
        Current = Schuelers[0];
        Loc = 0;
    }

    public void Forward()
    {
        Loc++;
        Current = Schuelers[_loc]; 
    }

    public void Backward()
    {
        Loc--;
        Current = Schuelers[_loc];
    }

    public IRelayCommand Vor => new RelayCommand(Forward);
    public IRelayCommand Back => new RelayCommand(Backward);

}
