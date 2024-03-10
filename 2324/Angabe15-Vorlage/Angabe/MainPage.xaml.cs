using System.Collections.ObjectModel;

namespace Angabe {
    public partial class MainPage : ContentPage {
        
        private ObservableCollection<WeirdThing> weirdThings=new();
        public MainPage()
        {
            InitializeComponent();
            col.ItemsSource = weirdThings;
        }

        private void Search(object sender, EventArgs e)
        {
            weirdThings.Add(new WeirdThing() { Bez=entry1.Text});
        }
    }

}
