using Plfs3.ViewModel;

namespace Plfs3 {
    public partial class MainPage : ContentPage {
        

        public MainPage()
        {
            InitializeComponent();
            BindingContext = new SchuelerViewModel();
        }

        
    }

}
